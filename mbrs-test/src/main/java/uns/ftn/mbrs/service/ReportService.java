package uns.ftn.mbrs.service;

import java.util.Optional;
import java.util.List;
import uns.ftn.mbrs.model.*;
import org.springframework.stereotype.Service;

@Service
public interface ReportService {

    List <Report> getAll();

    Optional < Report > getOne(Long id);

    void update(Report report);

    void add(Report report);

    void delete(Long id);
}

