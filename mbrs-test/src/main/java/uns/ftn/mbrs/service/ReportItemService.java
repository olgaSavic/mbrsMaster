package uns.ftn.mbrs.service;

import java.util.Optional;
import java.util.List;
import uns.ftn.mbrs.model.*;
import org.springframework.stereotype.Service;

@Service
public interface ReportItemService {

    List <ReportItem> getAll();

    Optional < ReportItem > getOne(Long id);

    void update(ReportItem reportitem);

    void add(ReportItem reportitem);

    void delete(Long id);
}

