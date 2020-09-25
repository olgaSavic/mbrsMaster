package uns.ftn.mbrs.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uns.ftn.mbrs.repository.TherapyRepository;
import uns.ftn.mbrs.service.TherapyService;
import uns.ftn.mbrs.model.*;
import java.util.Optional;


import java.util.Date;


@Service
public class TherapyServiceImpl implements TherapyService {

    @Autowired
    private TherapyRepository therapyRepository;

    @Override
    public List < Therapy > getAll() {
    return this.therapyRepository.findAll();
    }

    @Override
    public Optional <Therapy> getOne(Long id) {
    return this.therapyRepository.findById(id);
    }

    @Override
    public void update(Therapy therapy) {
    this.therapyRepository.save(therapy);
    }

    @Override
    public void add(Therapy therapy) {
    this.therapyRepository.save(therapy);
    }

    @Override
    public void delete(Long id) {
        Optional <Therapy> therapy = therapyRepository.findById(id);
        if (therapy.isPresent()) {
        therapyRepository.delete(therapy.get());
        }
    }
}


