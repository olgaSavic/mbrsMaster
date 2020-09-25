package uns.ftn.mbrs.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import uns.ftn.mbrs.model.ReportItem;


@Repository
public interface ReportItemRepository extends JpaRepository<ReportItem, Long> {

}