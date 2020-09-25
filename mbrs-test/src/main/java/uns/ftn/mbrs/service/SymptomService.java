package uns.ftn.mbrs.service;

import java.util.Optional;
import java.util.List;
import uns.ftn.mbrs.model.*;
import org.springframework.stereotype.Service;

@Service
public interface SymptomService {

    List <Symptom> getAll();

    Optional < Symptom > getOne(Long id);

    void update(Symptom symptom);

    void add(Symptom symptom);

    void delete(Long id);
}

