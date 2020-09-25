package uns.ftn.mbrs.service;

import java.util.Optional;
import java.util.List;
import uns.ftn.mbrs.model.*;
import org.springframework.stereotype.Service;

@Service
public interface PacientService {

    List <Pacient> getAll();

    Optional < Pacient > getOne(Long id);

    void update(Pacient pacient);

    void add(Pacient pacient);

    void delete(Long id);
}

