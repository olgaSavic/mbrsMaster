package uns.ftn.mbrs.controller;
import java.util.*;


import uns.ftn.mbrs.model.*;

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
public class TherapyController {

    @Autowired
    private TherapyService therapyService;

    @GetMapping(value = "allTherapys")
    public String getAllTherapy(Model model) {

        List<Therapy> allTherapys = this.therapyService.getAll();
        model.addAttribute("therapys", allTherapys);
        return "TherapyList";
    }

    @GetMapping(value = "therapy/new")
    public String newTherapy(Model model) {
        model.addAttribute("therapy", new Therapy());
        return "TherapyForm";
    }

    @GetMapping(value = "therapy/{id}")
    public String showTherapyDetails (@PathVariable("id") Long id, Model model) {
        model.addAttribute("therapy", therapyService.getOne(id).orElse(null));
        return "TherapyDetails";
    }

    @GetMapping(value = "oneTherapy")
    public ResponseEntity getOneTherapy(@RequestParam Long id) {

        Optional<Therapy> therapy = therapyService.getOne(id);

        if (therapy == null) {
            return ResponseEntity.notFound().build();        }

        return new ResponseEntity(therapy, HttpStatus.OK);
    }



    @DeleteMapping(value = "deleteTherapy")
    public ResponseEntity deleteTherapy(@RequestParam Long id) {

        therapyService.delete(id);
        return ResponseEntity.ok().build();
    }

    @PostMapping(value = "updateTherapy")
    public ResponseEntity updateTherapy(@RequestBody Therapy therapy) {

        if (therapy == null) {
            return ResponseEntity.notFound().build();
        }

        therapyService.update(therapy);
        return ResponseEntity.ok().build();
    }


    @PostMapping(value = "addTherapy")
    public ResponseEntity addTherapy(@RequestBody Therapy therapy) {

        if (therapy == null) {
            return ResponseEntity.notFound().build();
        }

        therapyService.add(therapy);
        return ResponseEntity.ok().build();
    }

}



