package uns.ftn.mbrs.service;

import java.util.Optional;
import java.util.List;
import uns.ftn.mbrs.model.*;
import org.springframework.stereotype.Service;

@Service
public interface DiagnosisService {

    List <Diagnosis> getAll();

    Optional < Diagnosis > getOne(Long id);

    void update(Diagnosis diagnosis);

    void add(Diagnosis diagnosis);

    void delete(Long id);
}

