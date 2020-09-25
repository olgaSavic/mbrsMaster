package uns.ftn.mbrs.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import uns.ftn.mbrs.model.Pacient;


@Repository
public interface PacientRepository extends JpaRepository<Pacient, Long> {

}