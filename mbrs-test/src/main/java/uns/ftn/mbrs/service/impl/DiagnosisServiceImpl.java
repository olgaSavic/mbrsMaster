package uns.ftn.mbrs.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uns.ftn.mbrs.repository.DiagnosisRepository;
import uns.ftn.mbrs.service.DiagnosisService;
import uns.ftn.mbrs.model.*;
import java.util.Optional;


import java.util.Date;


@Service
public class DiagnosisServiceImpl implements DiagnosisService {

    @Autowired
    private DiagnosisRepository diagnosisRepository;

    @Override
    public List < Diagnosis > getAll() {
    return this.diagnosisRepository.findAll();
    }

    @Override
    public Optional <Diagnosis> getOne(Long id) {
    return this.diagnosisRepository.findById(id);
    }

    @Override
    public void update(Diagnosis diagnosis) {
    this.diagnosisRepository.save(diagnosis);
    }

    @Override
    public void add(Diagnosis diagnosis) {
    this.diagnosisRepository.save(diagnosis);
    }

    @Override
    public void delete(Long id) {
        Optional <Diagnosis> diagnosis = diagnosisRepository.findById(id);
        if (diagnosis.isPresent()) {
        diagnosisRepository.delete(diagnosis.get());
        }
    }
}


