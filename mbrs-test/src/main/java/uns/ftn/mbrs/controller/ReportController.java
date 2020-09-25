package uns.ftn.mbrs.controller;
import java.util.*;


import uns.ftn.mbrs.model.*;

import uns.ftn.mbrs.service.ReportService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uns.ftn.mbrs.model.*;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;



@RestController
@RequestMapping(value = "/api/reports/")
public class ReportController {

    @Autowired
    private ReportService reportService;

    @GetMapping(value = "allReports")
    public ResponseEntity getAllReport() {

        List<Report> allReports = this.reportService.getAll();

        if (allReports.isEmpty()) {
        return ResponseEntity.notFound().build();
        }

        return new ResponseEntity<>(allReports, HttpStatus.OK);
    }

    @GetMapping(value = "oneReport")
    public ResponseEntity getOneReport(@RequestParam Long id) {

        Optional<Report> report = reportService.getOne(id);

        if (report == null) {
            return ResponseEntity.notFound().build();        }

        return new ResponseEntity(report, HttpStatus.OK);
    }



    @DeleteMapping(value = "deleteReport")
    public ResponseEntity deleteReport(@RequestParam Long id) {

        reportService.delete(id);
        return ResponseEntity.ok().build();
    }

    @PostMapping(value = "updateReport")
    public ResponseEntity updateReport(@RequestBody Report report) {

        if (report == null) {
            return ResponseEntity.notFound().build();
        }

        reportService.update(report);
        return ResponseEntity.ok().build();
    }


    @PostMapping(value = "addReport")
    public ResponseEntity addReport(@RequestBody Report report) {

        if (report == null) {
            return ResponseEntity.notFound().build();
        }

        reportService.add(report);
        return ResponseEntity.ok().build();
    }

}



