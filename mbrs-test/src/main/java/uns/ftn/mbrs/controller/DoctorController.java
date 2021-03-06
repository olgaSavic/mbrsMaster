package uns.ftn.mbrs.controller;
import java.util.*;


import uns.ftn.mbrs.model.*;

import uns.ftn.mbrs.service.DoctorService;
import uns.ftn.mbrs.service.PatientService;
import uns.ftn.mbrs.service.ExaminationService;
import uns.ftn.mbrs.service.DiagnosisService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uns.ftn.mbrs.model.*;
import java.util.Optional;

import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;



@Controller
public class DoctorController {

    @Autowired
    private DoctorService doctorService;

    @Autowired
    private PatientService patientService;
    @Autowired
    private ExaminationService examinationService;
    @Autowired
    private DiagnosisService diagnosisService;

    @GetMapping(value = "allDoctors")
    public String getAllDoctor(Model model) {
        List<Doctor> allDoctors = this.doctorService.getAll();
        model.addAttribute("doctors", allDoctors);
        return "DoctorList";
    }

    @GetMapping(value = "doctor/new")
    public String newDoctor(Model model) {
        model.addAttribute("doctor", new Doctor());
        List<Patient> patients = patientService.getAll();
        model.addAttribute("patients", patients);
        List<Examination> examinations = examinationService.getAll();
        model.addAttribute("examinations", examinations);
        List<Diagnosis> diagnosiss = diagnosisService.getAll();
        model.addAttribute("diagnosiss", diagnosiss);
        return "DoctorForm";
    }

    @GetMapping(value = "doctor/edit")
    public String editDoctor(@RequestParam("id") String id, Model model) {
        Doctor doctor = doctorService.getOne(Long.parseLong(id)).orElse(null);
        model.addAttribute("doctor", doctor);
            List<Patient> patients = patientService.getAll();
            model.addAttribute("patients", patients);
            List<Examination> examinations = examinationService.getAll();
            model.addAttribute("examinations", examinations);
            List<Diagnosis> diagnosiss = diagnosisService.getAll();
            model.addAttribute("diagnosiss", diagnosiss);
        return "DoctorForm";
    }

    @GetMapping(value = "doctor/{id}")
    public String showDoctorDetails (@PathVariable("id") Long id, Model model) {
        model.addAttribute("doctor", doctorService.getOne(id).orElse(null));
        return "DoctorDetails";
    }


    @GetMapping("doctor/delete")
    public String deleteDoctor(@RequestParam("id") String id, Model model) {
        doctorService.delete(Long.parseLong(id));
        List<Doctor> allDoctors = this.doctorService.getAll();
        model.addAttribute("doctors", allDoctors);
        return "DoctorList";
    }


    @PostMapping(value = "addDoctor")
    public String addDoctor(@ModelAttribute Doctor doctor, Model model) {
        doctorService.add(doctor);
        List<Doctor> allDoctors = this.doctorService.getAll();
        model.addAttribute("doctors", allDoctors);
        return "DoctorList";
    }






}



