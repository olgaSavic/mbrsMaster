package uns.ftn.mbrs.controller;
import java.util.*;


import uns.ftn.mbrs.model.*;

import uns.ftn.mbrs.service.ExaminationService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uns.ftn.mbrs.model.*;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;



@RestController
@RequestMapping(value = "/api/examinations/")
public class ExaminationController {

    @Autowired
    private ExaminationService examinationService;

    @GetMapping(value = "allExaminations")
    public ResponseEntity getAllExamination() {

        List<Examination> allExaminations = this.examinationService.getAll();

        if (allExaminations.isEmpty()) {
        return ResponseEntity.notFound().build();
        }

        return new ResponseEntity<>(allExaminations, HttpStatus.OK);
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



