package uns.ftn.mbrs.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uns.ftn.mbrs.repository.PacientRepository;
import uns.ftn.mbrs.service.PacientService;
import uns.ftn.mbrs.model.*;
import java.util.Optional;


import java.util.Date;


@Service
public class PacientServiceImpl implements PacientService {

    @Autowired
    private PacientRepository pacientRepository;

    @Override
    public List < Pacient > getAll() {
    return this.pacientRepository.findAll();
    }

    @Override
    public Optional <Pacient> getOne(Long id) {
    return this.pacientRepository.findById(id);
    }

    @Override
    public void update(Pacient pacient) {
    this.pacientRepository.save(pacient);
    }

    @Override
    public void add(Pacient pacient) {
    this.pacientRepository.save(pacient);
    }

    @Override
    public void delete(Long id) {
        Optional <Pacient> pacient = pacientRepository.findById(id);
        if (pacient.isPresent()) {
        pacientRepository.delete(pacient.get());
        }
    }
}


