package uns.ftn.mbrs.controller;
import java.util.*;


import uns.ftn.mbrs.model.*;

import uns.ftn.mbrs.service.DiagnosisService;
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
public class DiagnosisController {

    @Autowired
    private DiagnosisService diagnosisService;

    @Autowired
    private PatientService patientService;
    @Autowired
    private DoctorService doctorService;

    @GetMapping(value = "allDiagnosiss")
    public String getAllDiagnosis(Model model) {
        List<Diagnosis> allDiagnosiss = this.diagnosisService.getAll();
        model.addAttribute("diagnosiss", allDiagnosiss);
        return "DiagnosisList";
    }

    @GetMapping(value = "diagnosis/new")
    public String newDiagnosis(Model model) {
        model.addAttribute("diagnosis", new Diagnosis());
        List<Patient> patients = patientService.getAll();
        model.addAttribute("patients", patients);
        List<Doctor> doctors = doctorService.getAll();
        model.addAttribute("doctors", doctors);
        return "DiagnosisForm";
    }

    @GetMapping(value = "diagnosis/edit")
    public String editDiagnosis(@RequestParam("id") String id, Model model) {
        Diagnosis diagnosis = diagnosisService.getOne(Long.parseLong(id)).orElse(null);
        model.addAttribute("diagnosis", diagnosis);
                List<Patient> patients = patientService.getAll();
                model.addAttribute("patients", patients);
                List<Doctor> doctors = doctorService.getAll();
                model.addAttribute("doctors", doctors);
        return "DiagnosisForm";
    }

    @GetMapping(value = "diagnosis/{id}")
    public String showDiagnosisDetails (@PathVariable("id") Long id, Model model) {
        model.addAttribute("diagnosis", diagnosisService.getOne(id).orElse(null));
        return "DiagnosisDetails";
    }


    @GetMapping("diagnosis/delete")
    public String deleteDiagnosis(@RequestParam("id") String id, Model model) {
        diagnosisService.delete(Long.parseLong(id));
        List<Diagnosis> allDiagnosiss = this.diagnosisService.getAll();
        model.addAttribute("diagnosiss", allDiagnosiss);
        return "DiagnosisList";
    }


    @PostMapping(value = "addDiagnosis")
    public String addDiagnosis(@ModelAttribute Diagnosis diagnosis, Model model) {
        diagnosisService.add(diagnosis);
        List<Diagnosis> allDiagnosiss = this.diagnosisService.getAll();
        model.addAttribute("diagnosiss", allDiagnosiss);
        return "DiagnosisList";
    }






}



