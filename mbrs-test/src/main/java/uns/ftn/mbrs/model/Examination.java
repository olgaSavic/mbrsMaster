package uns.ftn.mbrs.model;

import javax.persistence.*;
import java.util.*;

import uns.ftn.mbrs.model.Doctor;
import uns.ftn.mbrs.model.Pacient;
import uns.ftn.mbrs.model.Report;

@Entity
@Table
public class Examination {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @Column
    private Date date;

    @ManyToOne
    private Doctor doctor;

    @ManyToOne
    private Pacient pacient;

    @OneToOne
    private Report report;

    public Long getId(){
         return id;
    }
    public void setId(Long id){
         this.id = id;
    }

    public Date getDate(){
         return date;
    }
    public void setDate(Date date){
         this.date = date;
    }


}
