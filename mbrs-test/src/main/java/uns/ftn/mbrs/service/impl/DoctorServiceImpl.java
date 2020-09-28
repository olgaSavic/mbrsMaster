package uns.ftn.mbrs.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uns.ftn.mbrs.repository.DoctorRepository;
import uns.ftn.mbrs.service.DoctorService;
import uns.ftn.mbrs.model.*;
import java.util.Optional;


import java.util.Date;


@Service
public class DoctorServiceImpl implements DoctorService {

    @Autowired
    private DoctorRepository doctorRepository;

    @Override
    public List < Doctor > getAll() {
    return this.doctorRepository.findAll();
    }

    @Override
    public Optional <Doctor> getOne(Long id) {
    return this.doctorRepository.findById(id);
    }

    @Override
    public void update(Doctor doctor) {
    this.doctorRepository.save(doctor);
    }

    @Override
    public void add(Doctor doctor) {
    this.doctorRepository.save(doctor);
    }

    @Override
    public void delete(Long id) {
        Optional <Doctor> doctor = doctorRepository.findById(id);
        if (doctor.isPresent()) {
        doctorRepository.delete(doctor.get());
        }
    }
}


