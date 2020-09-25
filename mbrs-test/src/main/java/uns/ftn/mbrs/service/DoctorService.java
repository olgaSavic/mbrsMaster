package uns.ftn.mbrs.service;

import java.util.Optional;
import java.util.List;
import uns.ftn.mbrs.model.*;
import org.springframework.stereotype.Service;

@Service
public interface DoctorService {

    List <Doctor> getAll();

    Optional < Doctor > getOne(Long id);

    void update(Doctor doctor);

    void add(Doctor doctor);

    void delete(Long id);
}

