package uns.ftn.mbrs.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uns.ftn.mbrs.repository.PatientRepository;
import uns.ftn.mbrs.service.PatientService;
import uns.ftn.mbrs.model.*;
import java.util.Optional;


import java.util.Date;


@Service
public class PatientServiceImpl implements PatientService {

    @Autowired
    private PatientRepository patientRepository;

    @Override
    public List < Patient > getAll() {
    return this.patientRepository.findAll();
    }

    @Override
    public Optional <Patient> getOne(Long id) {
    return this.patientRepository.findById(id);
    }

    @Override
    public void update(Patient patient) {
    this.patientRepository.save(patient);
    }

    @Override
    public void add(Patient patient) {
    this.patientRepository.save(patient);
    }

    @Override
    public void delete(Long id) {
        Optional <Patient> patient = patientRepository.findById(id);
        if (patient.isPresent()) {
        patientRepository.delete(patient.get());
        }
    }
}


