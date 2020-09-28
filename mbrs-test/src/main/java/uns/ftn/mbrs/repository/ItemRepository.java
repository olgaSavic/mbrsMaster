package uns.ftn.mbrs.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import uns.ftn.mbrs.model.Item;


@Repository
public interface ItemRepository extends JpaRepository<Item, Long> {

}