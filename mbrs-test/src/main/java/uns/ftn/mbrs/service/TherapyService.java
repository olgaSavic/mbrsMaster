package uns.ftn.mbrs.service;

import java.util.Optional;
import java.util.List;
import uns.ftn.mbrs.model.*;
import org.springframework.stereotype.Service;

@Service
public interface TherapyService {

    List <Therapy> getAll();

    Optional < Therapy > getOne(Long id);

    void update(Therapy therapy);

    void add(Therapy therapy);

    void delete(Long id);
}

