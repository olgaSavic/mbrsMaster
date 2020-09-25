package uns.ftn.mbrs.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import uns.ftn.mbrs.model.Examination;


@Repository
public interface ExaminationRepository extends JpaRepository<Examination, Long> {

}