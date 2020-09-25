package uns.ftn.mbrs.controller;
import java.util.*;


import uns.ftn.mbrs.model.*;

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
public class DoctorController {

    @Autowired
    private DoctorService doctorService;

    @GetMapping(value = "allDoctors")
    public String getAllDoctor(Model model) {

        List<Doctor> allDoctors = this.doctorService.getAll();
        model.addAttribute("doctors", allDoctors);
        return "DoctorList";
    }

    @GetMapping(value = "doctor/new")
    public String newDoctor(Model model) {
        model.addAttribute("doctor", new Doctor());
        return "DoctorForm";
    }

    @GetMapping(value = "doctor/{id}")
    public String showDoctorDetails (@PathVariable("id") Long id, Model model) {
        model.addAttribute("doctor", doctorService.getOne(id).orElse(null));
        return "DoctorDetails";
    }

    @GetMapping(value = "oneDoctor")
    public ResponseEntity getOneDoctor(@RequestParam Long id) {

        Optional<Doctor> doctor = doctorService.getOne(id);

        if (doctor == null) {
            return ResponseEntity.notFound().build();        }

        return new ResponseEntity(doctor, HttpStatus.OK);
    }



    @DeleteMapping(value = "deleteDoctor")
    public ResponseEntity deleteDoctor(@RequestParam Long id) {

        doctorService.delete(id);
        return ResponseEntity.ok().build();
    }

    @PostMapping(value = "updateDoctor")
    public ResponseEntity updateDoctor(@RequestBody Doctor doctor) {

        if (doctor == null) {
            return ResponseEntity.notFound().build();
        }

        doctorService.update(doctor);
        return ResponseEntity.ok().build();
    }


    @PostMapping(value = "addDoctor")
    public ResponseEntity addDoctor(@RequestBody Doctor doctor) {

        if (doctor == null) {
            return ResponseEntity.notFound().build();
        }

        doctorService.add(doctor);
        return ResponseEntity.ok().build();
    }

}



