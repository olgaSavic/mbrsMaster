package uns.ftn.mbrs.controller;
import java.util.*;


import uns.ftn.mbrs.model.*;

import uns.ftn.mbrs.service.ReportItemService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uns.ftn.mbrs.model.*;
import java.util.Optional;

import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;



@Controller
public class ReportItemController {

    @Autowired
    private ReportItemService reportitemService;


    @GetMapping(value = "allReportItems")
    public String getAllReportItem(Model model) {

        List<ReportItem> allReportItems = this.reportitemService.getAll();
        model.addAttribute("reportitems", allReportItems);
        return "ReportItemList";
    }

    @GetMapping(value = "reportitem/new")
    public String newReportItem(Model model) {
        model.addAttribute("reportitem", new ReportItem());
        return "ReportItemForm";
    }

    @GetMapping(value = "reportitem/{id}")
    public String showReportItemDetails (@PathVariable("id") Long id, Model model) {
        model.addAttribute("reportitem", reportitemService.getOne(id).orElse(null));
        return "ReportItemDetails";
    }

    /*
    @GetMapping(value = "oneReportItem")
    public ResponseEntity getOneReportItem(@RequestParam Long id) {

        Optional<ReportItem> reportitem = reportitemService.getOne(id);
        if (reportitem == null) {
            return ResponseEntity.notFound().build();
        }
        return new ResponseEntity(reportitem, HttpStatus.OK);
    }
    */


    @GetMapping("reportitem/delete")
    public String deleteReportItem(@RequestParam("id") String id) {
        reportitemService.delete(Long.parseLong(id));
        return "ReportItemList";
    }

    @PostMapping(value = "updateReportItem")
    public ResponseEntity updateReportItem(@RequestBody ReportItem reportitem) {

        if (reportitem == null) {
            return ResponseEntity.notFound().build();
        }

        reportitemService.update(reportitem);
        return ResponseEntity.ok().build();
    }

    @PostMapping(value = "addReportItem")
    public String addReportItem(@ModelAttribute ReportItem reportitem) {

        reportitemService.add(reportitem);
        return "ReportItemList";
    }






}



