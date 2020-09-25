package uns.ftn.mbrs.controller;
import java.util.*;


import uns.ftn.mbrs.model.*;

import uns.ftn.mbrs.service.ReportItemService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uns.ftn.mbrs.model.*;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;



@RestController
@RequestMapping(value = "/api/reportitems/")
public class ReportItemController {

    @Autowired
    private ReportItemService reportitemService;

    @GetMapping(value = "allReportItems")
    public ResponseEntity getAllReportItem() {

        List<ReportItem> allReportItems = this.reportitemService.getAll();

        if (allReportItems.isEmpty()) {
        return ResponseEntity.notFound().build();
        }

        return new ResponseEntity<>(allReportItems, HttpStatus.OK);
    }

    @GetMapping(value = "oneReportItem")
    public ResponseEntity getOneReportItem(@RequestParam Long id) {

        Optional<ReportItem> reportitem = reportitemService.getOne(id);

        if (reportitem == null) {
            return ResponseEntity.notFound().build();        }

        return new ResponseEntity(reportitem, HttpStatus.OK);
    }



    @DeleteMapping(value = "deleteReportItem")
    public ResponseEntity deleteReportItem(@RequestParam Long id) {

        reportitemService.delete(id);
        return ResponseEntity.ok().build();
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
    public ResponseEntity addReportItem(@RequestBody ReportItem reportitem) {

        if (reportitem == null) {
            return ResponseEntity.notFound().build();
        }

        reportitemService.add(reportitem);
        return ResponseEntity.ok().build();
    }

}



