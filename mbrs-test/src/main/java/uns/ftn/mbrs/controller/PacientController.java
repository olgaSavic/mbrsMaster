package uns.ftn.mbrs.controller;
import java.util.*;


import uns.ftn.mbrs.model.*;

import uns.ftn.mbrs.service.PacientService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uns.ftn.mbrs.model.*;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;



@RestController
@RequestMapping(value = "/api/pacients/")
public class PacientController {

    @Autowired
    private PacientService pacientService;

    @GetMapping(value = "allPacients")
    public ResponseEntity getAllPacient() {

        List<Pacient> allPacients = this.pacientService.getAll();

        if (allPacients.isEmpty()) {
        return ResponseEntity.notFound().build();
        }

        return new ResponseEntity<>(allPacients, HttpStatus.OK);
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



