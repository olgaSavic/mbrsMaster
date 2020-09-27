package uns.ftn.mbrs.service;

import java.util.Optional;
import java.util.List;
import uns.ftn.mbrs.model.*;
import org.springframework.stereotype.Service;

@Service
public interface PatientService {

    List <Patient> getAll();

    Optional < Patient > getOne(Long id);

    void update(Patient patient);

    void add(Patient patient);

    void delete(Long id);
}

