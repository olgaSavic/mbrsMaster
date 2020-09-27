package uns.ftn.mbrs.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import uns.ftn.mbrs.model.Patient;


@Repository
public interface PatientRepository extends JpaRepository<Patient, Long> {

}