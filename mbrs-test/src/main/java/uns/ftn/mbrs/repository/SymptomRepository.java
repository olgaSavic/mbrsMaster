package uns.ftn.mbrs.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import uns.ftn.mbrs.model.Symptom;


@Repository
public interface SymptomRepository extends JpaRepository<Symptom, Long> {

}