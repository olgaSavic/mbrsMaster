package uns.ftn.mbrs.controller;
import java.util.*;


import uns.ftn.mbrs.model.*;

import uns.ftn.mbrs.service.SymptomService;
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
public class SymptomController {

    @Autowired
    private SymptomService symptomService;

    @Autowired
    private PatientService patientService;

    @GetMapping(value = "allSymptoms")
    public String getAllSymptom(Model model) {
        List<Symptom> allSymptoms = this.symptomService.getAll();
        model.addAttribute("symptoms", allSymptoms);
        return "SymptomList";
    }

    @GetMapping(value = "symptom/new")
    public String newSymptom(Model model) {
        model.addAttribute("symptom", new Symptom());
        List<Patient> patients = patientService.getAll();
        model.addAttribute("patients", patients);
        return "SymptomForm";
    }

    @GetMapping(value = "symptom/edit")
    public String editSymptom(@RequestParam("id") String id, Model model) {
        Symptom symptom = symptomService.getOne(Long.parseLong(id)).orElse(null);
        model.addAttribute("symptom", symptom);
            List<Patient> patients = patientService.getAll();
            model.addAttribute("patients", patients);
        return "SymptomForm";
    }

    @GetMapping(value = "symptom/{id}")
    public String showSymptomDetails (@PathVariable("id") Long id, Model model) {
        model.addAttribute("symptom", symptomService.getOne(id).orElse(null));
        return "SymptomDetails";
    }


    @GetMapping("symptom/delete")
    public String deleteSymptom(@RequestParam("id") String id, Model model) {
        symptomService.delete(Long.parseLong(id));
        List<Symptom> allSymptoms = this.symptomService.getAll();
        model.addAttribute("symptoms", allSymptoms);
        return "SymptomList";
    }


    @PostMapping(value = "addSymptom")
    public String addSymptom(@ModelAttribute Symptom symptom, Model model) {
        symptomService.add(symptom);
        List<Symptom> allSymptoms = this.symptomService.getAll();
        model.addAttribute("symptoms", allSymptoms);
        return "SymptomList";
    }






}



