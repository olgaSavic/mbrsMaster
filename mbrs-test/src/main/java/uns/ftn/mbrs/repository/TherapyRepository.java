package uns.ftn.mbrs.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import uns.ftn.mbrs.model.Therapy;


@Repository
public interface TherapyRepository extends JpaRepository<Therapy, Long> {

}