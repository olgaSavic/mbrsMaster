package uns.ftn.mbrs.controller;
import java.util.*;


import uns.ftn.mbrs.model.*;

import uns.ftn.mbrs.service.DiagnosisService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uns.ftn.mbrs.model.*;
import java.util.Optional;

import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;



@Controller
public class DiagnosisController {

    @Autowired
    private DiagnosisService diagnosisService;

    @GetMapping(value = "allDiagnosiss")
    public String getAllDiagnosis(Model model) {

        List<Diagnosis> allDiagnosiss = this.diagnosisService.getAll();
        model.addAttribute("diagnosiss", allDiagnosiss);
        return "DiagnosisList";
    }

    @GetMapping(value = "diagnosis/new")
    public String newDiagnosis(Model model) {
        model.addAttribute("diagnosis", new Diagnosis());
        return "DiagnosisForm";
    }

    @GetMapping(value = "diagnosis/{id}")
    public String showDiagnosisDetails (@PathVariable("id") Long id, Model model) {
        model.addAttribute("diagnosis", diagnosisService.getOne(id).orElse(null));
        return "DiagnosisDetails";
    }

    @GetMapping(value = "oneDiagnosis")
    public ResponseEntity getOneDiagnosis(@RequestParam Long id) {

        Optional<Diagnosis> diagnosis = diagnosisService.getOne(id);

        if (diagnosis == null) {
            return ResponseEntity.notFound().build();        }

        return new ResponseEntity(diagnosis, HttpStatus.OK);
    }



    @DeleteMapping(value = "deleteDiagnosis")
    public ResponseEntity deleteDiagnosis(@RequestParam Long id) {

        diagnosisService.delete(id);
        return ResponseEntity.ok().build();
    }

    @PostMapping(value = "updateDiagnosis")
    public ResponseEntity updateDiagnosis(@RequestBody Diagnosis diagnosis) {

        if (diagnosis == null) {
            return ResponseEntity.notFound().build();
        }

        diagnosisService.update(diagnosis);
        return ResponseEntity.ok().build();
    }


    @PostMapping(value = "addDiagnosis")
    public ResponseEntity addDiagnosis(@RequestBody Diagnosis diagnosis) {

        if (diagnosis == null) {
            return ResponseEntity.notFound().build();
        }

        diagnosisService.add(diagnosis);
        return ResponseEntity.ok().build();
    }

}



