package uns.ftn.mbrs.controller;
import java.util.*;


import uns.ftn.mbrs.model.*;

import uns.ftn.mbrs.service.ExaminationService;
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

    @GetMapping(value = "allExaminations")
    public String getAllExamination(Model model) {

        List<Examination> allExaminations = this.examinationService.getAll();
        model.addAttribute("examinations", allExaminations);
        return "ExaminationList";
    }

    @GetMapping(value = "examination/new")
    public String newExamination(Model model) {
        model.addAttribute("examination", new Examination());
        return "ExaminationForm";
    }

    @GetMapping(value = "examination/{id}")
    public String showExaminationDetails (@PathVariable("id") Long id, Model model) {
        model.addAttribute("examination", examinationService.getOne(id).orElse(null));
        return "ExaminationDetails";
    }

    @GetMapping(value = "oneExamination")
    public ResponseEntity getOneExamination(@RequestParam Long id) {

        Optional<Examination> examination = examinationService.getOne(id);

        if (examination == null) {
            return ResponseEntity.notFound().build();        }

        return new ResponseEntity(examination, HttpStatus.OK);
    }



    @DeleteMapping(value = "deleteExamination")
    public ResponseEntity deleteExamination(@RequestParam Long id) {

        examinationService.delete(id);
        return ResponseEntity.ok().build();
    }

    @PostMapping(value = "updateExamination")
    public ResponseEntity updateExamination(@RequestBody Examination examination) {

        if (examination == null) {
            return ResponseEntity.notFound().build();
        }

        examinationService.update(examination);
        return ResponseEntity.ok().build();
    }


    @PostMapping(value = "addExamination")
    public ResponseEntity addExamination(@RequestBody Examination examination) {

        if (examination == null) {
            return ResponseEntity.notFound().build();
        }

        examinationService.add(examination);
        return ResponseEntity.ok().build();
    }

}



