package uns.ftn.mbrs.service;

import java.util.Optional;
import java.util.List;
import uns.ftn.mbrs.model.*;
import org.springframework.stereotype.Service;

@Service
public interface ExaminationService {

    List <Examination> getAll();

    Optional < Examination > getOne(Long id);

    void update(Examination examination);

    void add(Examination examination);

    void delete(Long id);
}

