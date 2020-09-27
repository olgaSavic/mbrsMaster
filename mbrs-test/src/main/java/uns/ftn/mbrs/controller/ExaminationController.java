package uns.ftn.mbrs.controller;
import java.util.*;


import uns.ftn.mbrs.model.*;

import uns.ftn.mbrs.service.ExaminationService;
import uns.ftn.mbrs.service.DoctorService;
import uns.ftn.mbrs.service.PatientService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uns.ftn.mbrs.model.*;
import java.util.Optional;

import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;



@Controller
public class ExaminationController {

    @Autowired
    private ExaminationService examinationService;

    @Autowired
    private DoctorService doctorService;
    @Autowired
    private PatientService patientService;

    @GetMapping(value = "allExaminations")
    public String getAllExamination(Model model) {
        List<Examination> allExaminations = this.examinationService.getAll();
        model.addAttribute("examinations", allExaminations);
        return "ExaminationList";
    }

    @GetMapping(value = "examination/new")
    public String newExamination(Model model) {
        model.addAttribute("examination", new Examination());
        List<Doctor> doctors = doctorService.getAll();
        model.addAttribute("doctors", doctors);
        List<Patient> patients = patientService.getAll();
        model.addAttribute("patients", patients);
        return "ExaminationForm";
    }

    @GetMapping(value = "examination/edit")
    public String editExamination(@RequestParam("id") String id, Model model) {
        Examination examination = examinationService.getOne(Long.parseLong(id)).orElse(null);
        model.addAttribute("examination", examination);
                List<Doctor> doctors = doctorService.getAll();
                model.addAttribute("doctors", doctors);
                List<Patient> patients = patientService.getAll();
                model.addAttribute("patients", patients);
        return "ExaminationForm";
    }

    @GetMapping(value = "examination/{id}")
    public String showExaminationDetails (@PathVariable("id") Long id, Model model) {
        model.addAttribute("examination", examinationService.getOne(id).orElse(null));
        return "ExaminationDetails";
    }


    @GetMapping("examination/delete")
    public String deleteExamination(@RequestParam("id") String id, Model model) {
        examinationService.delete(Long.parseLong(id));
        List<Examination> allExaminations = this.examinationService.getAll();
        model.addAttribute("examinations", allExaminations);
        return "ExaminationList";
    }


    @PostMapping(value = "addExamination")
    public String addExamination(@ModelAttribute Examination examination, Model model) {
        examinationService.add(examination);
        List<Examination> allExaminations = this.examinationService.getAll();
        model.addAttribute("examinations", allExaminations);
        return "ExaminationList";
    }






}



