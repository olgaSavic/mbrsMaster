package uns.ftn.mbrs.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import uns.ftn.mbrs.model.Report;


@Repository
public interface ReportRepository extends JpaRepository<Report, Long> {

}