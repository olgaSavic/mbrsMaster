package uns.ftn.mbrs.model;

import javax.persistence.*;
import java.util.*;

import uns.ftn.mbrs.model.ReportItem;
import uns.ftn.mbrs.model.Examination;

@Entity
@Table
public class Report {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;


    @ManyToMany
    private Set<ReportItem> reportItems;

    @OneToOne
    private Examination examination;

    public Long getId(){
         return id;
    }
    public void setId(Long id){
         this.id = id;
    }


}
