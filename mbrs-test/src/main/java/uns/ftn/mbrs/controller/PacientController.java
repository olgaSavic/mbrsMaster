package uns.ftn.mbrs.controller;
import java.util.*;


import uns.ftn.mbrs.model.*;

import uns.ftn.mbrs.service.PacientService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uns.ftn.mbrs.model.*;
import java.util.Optional;

import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;



@Controller
public class PacientController {

    @Autowired
    private PacientService pacientService;

    @GetMapping(value = "allPacients")
    public String getAllPacient(Model model) {

        List<Pacient> allPacients = this.pacientService.getAll();
        model.addAttribute("pacients", allPacients);
        return "PacientList";
    }

    @GetMapping(value = "pacient/new")
    public String newPacient(Model model) {
        model.addAttribute("pacient", new Pacient());
        return "PacientForm";
    }

    @GetMapping(value = "pacient/{id}")
    public String showPacientDetails (@PathVariable("id") Long id, Model model) {
        model.addAttribute("pacient", pacientService.getOne(id).orElse(null));
        return "PacientDetails";
    }

    @GetMapping(value = "onePacient")
    public ResponseEntity getOnePacient(@RequestParam Long id) {

        Optional<Pacient> pacient = pacientService.getOne(id);

        if (pacient == null) {
            return ResponseEntity.notFound().build();        }

        return new ResponseEntity(pacient, HttpStatus.OK);
    }



    @DeleteMapping(value = "deletePacient")
    public ResponseEntity deletePacient(@RequestParam Long id) {

        pacientService.delete(id);
        return ResponseEntity.ok().build();
    }

    @PostMapping(value = "updatePacient")
    public ResponseEntity updatePacient(@RequestBody Pacient pacient) {

        if (pacient == null) {
            return ResponseEntity.notFound().build();
        }

        pacientService.update(pacient);
        return ResponseEntity.ok().build();
    }


    @PostMapping(value = "addPacient")
    public ResponseEntity addPacient(@RequestBody Pacient pacient) {

        if (pacient == null) {
            return ResponseEntity.notFound().build();
        }

        pacientService.add(pacient);
        return ResponseEntity.ok().build();
    }

}



