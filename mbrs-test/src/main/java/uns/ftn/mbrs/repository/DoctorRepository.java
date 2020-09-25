package uns.ftn.mbrs.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import uns.ftn.mbrs.model.Doctor;


@Repository
public interface DoctorRepository extends JpaRepository<Doctor, Long> {

}