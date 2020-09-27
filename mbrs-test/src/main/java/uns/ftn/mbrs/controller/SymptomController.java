package uns.ftn.mbrs.controller;
import java.util.*;


import uns.ftn.mbrs.model.*;

import uns.ftn.mbrs.service.SymptomService;

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


    @GetMapping(value = "allSymptoms")
    public String getAllSymptom(Model model) {

        List<Symptom> allSymptoms = this.symptomService.getAll();
        model.addAttribute("symptoms", allSymptoms);
        return "SymptomList";
    }

    @GetMapping(value = "symptom/new")
    public String newSymptom(Model model) {
        model.addAttribute("symptom", new Symptom());
        return "SymptomForm";
    }

    @GetMapping(value = "symptom/{id}")
    public String showSymptomDetails (@PathVariable("id") Long id, Model model) {
        model.addAttribute("symptom", symptomService.getOne(id).orElse(null));
        return "SymptomDetails";
    }

    /*
    @GetMapping(value = "oneSymptom")
    public ResponseEntity getOneSymptom(@RequestParam Long id) {

        Optional<Symptom> symptom = symptomService.getOne(id);
        if (symptom == null) {
            return ResponseEntity.notFound().build();
        }
        return new ResponseEntity(symptom, HttpStatus.OK);
    }
    */


    @GetMapping("symptom/delete")
    public String deleteSymptom(@RequestParam("id") String id) {
        symptomService.delete(Long.parseLong(id));
        return "SymptomList";
    }

    @PostMapping(value = "updateSymptom")
    public ResponseEntity updateSymptom(@RequestBody Symptom symptom) {

        if (symptom == null) {
            return ResponseEntity.notFound().build();
        }

        symptomService.update(symptom);
        return ResponseEntity.ok().build();
    }

    @PostMapping(value = "addSymptom")
    public String addSymptom(@ModelAttribute Symptom symptom) {

        symptomService.add(symptom);
        return "SymptomList";
    }






}



