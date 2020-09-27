package uns.ftn.mbrs.model;

import javax.persistence.*;
import java.util.*;

import uns.ftn.mbrs.model.Item;
import uns.ftn.mbrs.model.Examination;

@Entity
@Table
public class Report {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;


    @ManyToMany
    private Set<Item> reportItems;

    @ManyToOne
    private Examination examination;

    public Long getId(){
         return id;
    }
    public void setId(Long id){
         this.id = id;
    }


    public Examination getExamination(){
        return examination;
    }
    public void setExamination(Examination examination){
        this.examination = examination;
    }

}
