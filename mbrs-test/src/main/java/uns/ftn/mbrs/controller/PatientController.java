package uns.ftn.mbrs.controller;
import java.util.*;


import uns.ftn.mbrs.model.*;

import uns.ftn.mbrs.service.PatientService;
import uns.ftn.mbrs.service.DoctorService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uns.ftn.mbrs.model.*;
import java.util.Optional;

import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;



@Controller
public class PatientController {

    @Autowired
    private PatientService patientService;

    @Autowired
    private DoctorService doctorService;

    @GetMapping(value = "allPatients")
    public String getAllPatient(Model model) {

        List<Patient> allPatients = this.patientService.getAll();
        model.addAttribute("patients", allPatients);
        return "PatientList";
    }

    @GetMapping(value = "patient/new")
    public String newPatient(Model model) {
        model.addAttribute("patient", new Patient());
        List<Doctor> doctors = doctorService.getAll();
        model.addAttribute("doctors", doctors);
        return "PatientForm";
    }

    @GetMapping(value = "patient/{id}")
    public String showPatientDetails (@PathVariable("id") Long id, Model model) {
        model.addAttribute("patient", patientService.getOne(id).orElse(null));
        return "PatientDetails";
    }

    /*
    @GetMapping(value = "onePatient")
    public ResponseEntity getOnePatient(@RequestParam Long id) {

        Optional<Patient> patient = patientService.getOne(id);
        if (patient == null) {
            return ResponseEntity.notFound().build();
        }
        return new ResponseEntity(patient, HttpStatus.OK);
    }
    */


    @GetMapping("patient/delete")
    public String deletePatient(@RequestParam("id") String id) {
        patientService.delete(Long.parseLong(id));
        return "PatientList";
    }

    @PostMapping(value = "updatePatient")
    public ResponseEntity updatePatient(@RequestBody Patient patient) {

        if (patient == null) {
            return ResponseEntity.notFound().build();
        }

        patientService.update(patient);
        return ResponseEntity.ok().build();
    }

    @PostMapping(value = "addPatient")
    public String addPatient(@ModelAttribute Patient patient) {

        patientService.add(patient);
        return "PatientList";
    }






}



