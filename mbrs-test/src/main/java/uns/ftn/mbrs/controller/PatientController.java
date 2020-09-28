package uns.ftn.mbrs.controller;
import java.util.*;


import uns.ftn.mbrs.model.*;

import uns.ftn.mbrs.service.PatientService;
import uns.ftn.mbrs.service.DoctorService;
import uns.ftn.mbrs.service.SymptomService;
import uns.ftn.mbrs.service.ExaminationService;
import uns.ftn.mbrs.service.DiagnosisService;
import uns.ftn.mbrs.service.TherapyService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uns.ftn.mbrs.model.*;
import java.util.Optional;

import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;



@Controller
public class PatientController {

    @Autowired
    private PatientService patientService;

    @Autowired
    private DoctorService doctorService;
    @Autowired
    private SymptomService symptomService;
    @Autowired
    private ExaminationService examinationService;
    @Autowired
    private DiagnosisService diagnosisService;
    @Autowired
    private TherapyService therapyService;

    @GetMapping(value = "allPatients")
    public String getAllPatient(Model model) {
        List<Patient> allPatients = this.patientService.getAll();
        model.addAttribute("patients", allPatients);
        return "PatientList";
    }

    @GetMapping(value = "patient/new")
    public String newPatient(Model model) {
        model.addAttribute("patient", new Patient());
        List<Doctor> doctors = doctorService.getAll();
        model.addAttribute("doctors", doctors);
        List<Symptom> symptoms = symptomService.getAll();
        model.addAttribute("symptoms", symptoms);
        List<Examination> examinations = examinationService.getAll();
        model.addAttribute("examinations", examinations);
        List<Diagnosis> diagnosiss = diagnosisService.getAll();
        model.addAttribute("diagnosiss", diagnosiss);
        List<Therapy> therapys = therapyService.getAll();
        model.addAttribute("therapys", therapys);
        return "PatientForm";
    }

    @GetMapping(value = "patient/edit")
    public String editPatient(@RequestParam("id") String id, Model model) {
        Patient patient = patientService.getOne(Long.parseLong(id)).orElse(null);
        model.addAttribute("patient", patient);
            List<Doctor> doctors = doctorService.getAll();
            model.addAttribute("doctors", doctors);
            List<Symptom> symptoms = symptomService.getAll();
            model.addAttribute("symptoms", symptoms);
            List<Examination> examinations = examinationService.getAll();
            model.addAttribute("examinations", examinations);
            List<Diagnosis> diagnosiss = diagnosisService.getAll();
            model.addAttribute("diagnosiss", diagnosiss);
            List<Therapy> therapys = therapyService.getAll();
            model.addAttribute("therapys", therapys);
        return "PatientForm";
    }

    @GetMapping(value = "patient/{id}")
    public String showPatientDetails (@PathVariable("id") Long id, Model model) {
        model.addAttribute("patient", patientService.getOne(id).orElse(null));
        return "PatientDetails";
    }


    @GetMapping("patient/delete")
    public String deletePatient(@RequestParam("id") String id, Model model) {
        patientService.delete(Long.parseLong(id));
        List<Patient> allPatients = this.patientService.getAll();
        model.addAttribute("patients", allPatients);
        return "PatientList";
    }


    @PostMapping(value = "addPatient")
    public String addPatient(@ModelAttribute Patient patient, Model model) {
        patientService.add(patient);
        List<Patient> allPatients = this.patientService.getAll();
        model.addAttribute("patients", allPatients);
        return "PatientList";
    }






}



