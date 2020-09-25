package uns.ftn.mbrs.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uns.ftn.mbrs.repository.ReportItemRepository;
import uns.ftn.mbrs.service.ReportItemService;
import uns.ftn.mbrs.model.*;
import java.util.Optional;


import java.util.Date;


@Service
public class ReportItemServiceImpl implements ReportItemService {

    @Autowired
    private ReportItemRepository reportItemRepository;

    @Override
    public List < ReportItem > getAll() {
    return this.reportItemRepository.findAll();
    }

    @Override
    public Optional <ReportItem> getOne(Long id) {
    return this.reportItemRepository.findById(id);
    }

    @Override
    public void update(ReportItem reportItem) {
    this.reportItemRepository.save(reportItem);
    }

    @Override
    public void add(ReportItem reportItem) {
    this.reportItemRepository.save(reportItem);
    }

    @Override
    public void delete(Long id) {
        Optional <ReportItem> reportItem = reportItemRepository.findById(id);
        if (reportItem.isPresent()) {
        reportItemRepository.delete(reportItem.get());
        }
    }
}


