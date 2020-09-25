package uns.ftn.mbrs.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uns.ftn.mbrs.repository.SymptomRepository;
import uns.ftn.mbrs.service.SymptomService;
import uns.ftn.mbrs.model.*;
import java.util.Optional;


import java.util.Date;


@Service
public class SymptomServiceImpl implements SymptomService {

    @Autowired
    private SymptomRepository symptomRepository;

    @Override
    public List < Symptom > getAll() {
    return this.symptomRepository.findAll();
    }

    @Override
    public Optional <Symptom> getOne(Long id) {
    return this.symptomRepository.findById(id);
    }

    @Override
    public void update(Symptom symptom) {
    this.symptomRepository.save(symptom);
    }

    @Override
    public void add(Symptom symptom) {
    this.symptomRepository.save(symptom);
    }

    @Override
    public void delete(Long id) {
        Optional <Symptom> symptom = symptomRepository.findById(id);
        if (symptom.isPresent()) {
        symptomRepository.delete(symptom.get());
        }
    }
}


