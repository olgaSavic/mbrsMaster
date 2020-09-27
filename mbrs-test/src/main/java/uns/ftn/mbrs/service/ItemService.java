package uns.ftn.mbrs.service;

import java.util.Optional;
import java.util.List;
import uns.ftn.mbrs.model.*;
import org.springframework.stereotype.Service;

@Service
public interface ItemService {

    List <Item> getAll();

    Optional < Item > getOne(Long id);

    void update(Item item);

    void add(Item item);

    void delete(Long id);
}

