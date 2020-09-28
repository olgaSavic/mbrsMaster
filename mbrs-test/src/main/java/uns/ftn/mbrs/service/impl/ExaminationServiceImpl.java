package uns.ftn.mbrs.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uns.ftn.mbrs.repository.ExaminationRepository;
import uns.ftn.mbrs.service.ExaminationService;
import uns.ftn.mbrs.model.*;
import java.util.Optional;


import java.util.Date;


@Service
public class ExaminationServiceImpl implements ExaminationService {

    @Autowired
    private ExaminationRepository examinationRepository;

    @Override
    public List < Examination > getAll() {
    return this.examinationRepository.findAll();
    }

    @Override
    public Optional <Examination> getOne(Long id) {
    return this.examinationRepository.findById(id);
    }

    @Override
    public void update(Examination examination) {
    this.examinationRepository.save(examination);
    }

    @Override
    public void add(Examination examination) {
    this.examinationRepository.save(examination);
    }

    @Override
    public void delete(Long id) {
        Optional <Examination> examination = examinationRepository.findById(id);
        if (examination.isPresent()) {
        examinationRepository.delete(examination.get());
        }
    }
}


