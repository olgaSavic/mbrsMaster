package uns.ftn.mbrs.controller;
import java.util.*;


import uns.ftn.mbrs.model.*;

import uns.ftn.mbrs.service.SymptomService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uns.ftn.mbrs.model.*;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;



@RestController
@RequestMapping(value = "/api/symptoms/")
public class SymptomController {

    @Autowired
    private SymptomService symptomService;

    @GetMapping(value = "allSymptoms")
    public ResponseEntity getAllSymptom() {

        List<Symptom> allSymptoms = this.symptomService.getAll();

        if (allSymptoms.isEmpty()) {
        return ResponseEntity.notFound().build();
        }

        return new ResponseEntity<>(allSymptoms, HttpStatus.OK);
    }

    @GetMapping(value = "oneSymptom")
    public ResponseEntity getOneSymptom(@RequestParam Long id) {

        Optional<Symptom> symptom = symptomService.getOne(id);

        if (symptom == null) {
            return ResponseEntity.notFound().build();        }

        return new ResponseEntity(symptom, HttpStatus.OK);
    }



    @DeleteMapping(value = "deleteSymptom")
    public ResponseEntity deleteSymptom(@RequestParam Long id) {

        symptomService.delete(id);
        return ResponseEntity.ok().build();
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
    public ResponseEntity addSymptom(@RequestBody Symptom symptom) {

        if (symptom == null) {
            return ResponseEntity.notFound().build();
        }

        symptomService.add(symptom);
        return ResponseEntity.ok().build();
    }

}



