package uns.ftn.mbrs.controller;
import java.util.*;


import uns.ftn.mbrs.model.*;

import uns.ftn.mbrs.service.TherapyService;
import uns.ftn.mbrs.service.DiagnosisService;
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
public class TherapyController {

    @Autowired
    private TherapyService therapyService;

    @Autowired
    private DiagnosisService diagnosisService;
    @Autowired
    private PatientService patientService;

    @GetMapping(value = "allTherapys")
    public String getAllTherapy(Model model) {
        List<Therapy> allTherapys = this.therapyService.getAll();
        model.addAttribute("therapys", allTherapys);
        return "TherapyList";
    }

    @GetMapping(value = "therapy/new")
    public String newTherapy(Model model) {
        model.addAttribute("therapy", new Therapy());
        List<Diagnosis> diagnosiss = diagnosisService.getAll();
        model.addAttribute("diagnosiss", diagnosiss);
        List<Patient> patients = patientService.getAll();
        model.addAttribute("patients", patients);
        return "TherapyForm";
    }

    @GetMapping(value = "therapy/edit")
    public String editTherapy(@RequestParam("id") String id, Model model) {
        Therapy therapy = therapyService.getOne(Long.parseLong(id)).orElse(null);
        model.addAttribute("therapy", therapy);
            List<Diagnosis> diagnosiss = diagnosisService.getAll();
            model.addAttribute("diagnosiss", diagnosiss);
            List<Patient> patients = patientService.getAll();
            model.addAttribute("patients", patients);
        return "TherapyForm";
    }

    @GetMapping(value = "therapy/{id}")
    public String showTherapyDetails (@PathVariable("id") Long id, Model model) {
        model.addAttribute("therapy", therapyService.getOne(id).orElse(null));
        return "TherapyDetails";
    }


    @GetMapping("therapy/delete")
    public String deleteTherapy(@RequestParam("id") String id, Model model) {
        therapyService.delete(Long.parseLong(id));
        List<Therapy> allTherapys = this.therapyService.getAll();
        model.addAttribute("therapys", allTherapys);
        return "TherapyList";
    }


    @PostMapping(value = "addTherapy")
    public String addTherapy(@ModelAttribute Therapy therapy, Model model) {
        therapyService.add(therapy);
        List<Therapy> allTherapys = this.therapyService.getAll();
        model.addAttribute("therapys", allTherapys);
        return "TherapyList";
    }






}



