package uns.ftn.mbrs.controller;
import java.util.*;


import uns.ftn.mbrs.model.*;

import uns.ftn.mbrs.service.ReportService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uns.ftn.mbrs.model.*;
import java.util.Optional;

import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;



@Controller
public class ReportController {

    @Autowired
    private ReportService reportService;

    @GetMapping(value = "allReports")
    public String getAllReport(Model model) {

        List<Report> allReports = this.reportService.getAll();
        model.addAttribute("reports", allReports);
        return "ReportList";
    }

    @GetMapping(value = "report/new")
    public String newReport(Model model) {
        model.addAttribute("report", new Report());
        return "ReportForm";
    }

    @GetMapping(value = "report/{id}")
    public String showReportDetails (@PathVariable("id") Long id, Model model) {
        model.addAttribute("report", reportService.getOne(id).orElse(null));
        return "ReportDetails";
    }

    /*
    @GetMapping(value = "oneReport")
    public ResponseEntity getOneReport(@RequestParam Long id) {

        Optional<Report> report = reportService.getOne(id);
        if (report == null) {
            return ResponseEntity.notFound().build();
        }
        return new ResponseEntity(report, HttpStatus.OK);
    }
    */


    @GetMapping("report/delete")
    public String deleteReport(@RequestParam("id") String id) {
        reportService.delete(Long.parseLong(id));
        return "ReportList";
    }

    @PostMapping(value = "updateReport")
    public ResponseEntity updateReport(@RequestBody Report report) {

        if (report == null) {
            return ResponseEntity.notFound().build();
        }

        reportService.update(report);
        return ResponseEntity.ok().build();
    }
    /*
    @PostMapping(value = "addReport")
    public String addReport(@RequestBody Report report) {

        Report Report = Report.builder()
                .id(Report.getId())

        .build();

        reportService.add(Report);
        return "ReportList";
    }
    */





}



