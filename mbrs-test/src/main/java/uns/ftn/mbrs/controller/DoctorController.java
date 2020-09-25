package uns.ftn.mbrs.controller;
import java.util.*;


import uns.ftn.mbrs.model.*;

import uns.ftn.mbrs.service.DoctorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uns.ftn.mbrs.model.*;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;



@RestController
@RequestMapping(value = "/api/doctors/")
public class DoctorController {

    @Autowired
    private DoctorService doctorService;

    @GetMapping(value = "allDoctors")
    public ResponseEntity getAllDoctor() {

        List<Doctor> allDoctors = this.doctorService.getAll();

        if (allDoctors.isEmpty()) {
        return ResponseEntity.notFound().build();
        }

        return new ResponseEntity<>(allDoctors, HttpStatus.OK);
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



