package uns.ftn.mbrs.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uns.ftn.mbrs.repository.ReportRepository;
import uns.ftn.mbrs.service.ReportService;
import uns.ftn.mbrs.model.*;
import java.util.Optional;


import java.util.Date;


@Service
public class ReportServiceImpl implements ReportService {

    @Autowired
    private ReportRepository reportRepository;

    @Override
    public List < Report > getAll() {
    return this.reportRepository.findAll();
    }

    @Override
    public Optional <Report> getOne(Long id) {
    return this.reportRepository.findById(id);
    }

    @Override
    public void update(Report report) {
    this.reportRepository.save(report);
    }

    @Override
    public void add(Report report) {
    this.reportRepository.save(report);
    }

    @Override
    public void delete(Long id) {
        Optional <Report> report = reportRepository.findById(id);
        if (report.isPresent()) {
        reportRepository.delete(report.get());
        }
    }
}


