package uns.ftn.mbrs.controller;
import java.util.*;


import uns.ftn.mbrs.model.*;

import uns.ftn.mbrs.service.ReportService;
import uns.ftn.mbrs.service.ExaminationService;

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

    @Autowired
    private ExaminationService examinationService;

    @GetMapping(value = "allReports")
    public String getAllReport(Model model) {
        List<Report> allReports = this.reportService.getAll();
        model.addAttribute("reports", allReports);
        return "ReportList";
    }

    @GetMapping(value = "report/new")
    public String newReport(Model model) {
        model.addAttribute("report", new Report());
        List<Examination> examinations = examinationService.getAll();
        model.addAttribute("examinations", examinations);
        return "ReportForm";
    }

    @GetMapping(value = "report/edit")
    public String editReport(@RequestParam("id") String id, Model model) {
        Report report = reportService.getOne(Long.parseLong(id)).orElse(null);
        model.addAttribute("report", report);
                List<Examination> examinations = examinationService.getAll();
                model.addAttribute("examinations", examinations);
        return "ReportForm";
    }

    @GetMapping(value = "report/{id}")
    public String showReportDetails (@PathVariable("id") Long id, Model model) {
        model.addAttribute("report", reportService.getOne(id).orElse(null));
        return "ReportDetails";
    }


    @GetMapping("report/delete")
    public String deleteReport(@RequestParam("id") String id, Model model) {
        reportService.delete(Long.parseLong(id));
        List<Report> allReports = this.reportService.getAll();
        model.addAttribute("reports", allReports);
        return "ReportList";
    }


    @PostMapping(value = "addReport")
    public String addReport(@ModelAttribute Report report, Model model) {
        reportService.add(report);
        List<Report> allReports = this.reportService.getAll();
        model.addAttribute("reports", allReports);
        return "ReportList";
    }






}



