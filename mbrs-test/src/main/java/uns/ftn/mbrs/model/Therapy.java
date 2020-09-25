package uns.ftn.mbrs.model;

import javax.persistence.*;
import java.util.*;

import uns.ftn.mbrs.model.Diagnosis;
import uns.ftn.mbrs.model.Pacient;

@Entity
@Table
public class Therapy {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @Column
    private String description;


    @ManyToMany
    private Set<Diagnosis> diagnosiss;

    @ManyToMany
    private Set<Pacient> patients;

    public Long getId(){
         return id;
    }
    public void setId(Long id){
         this.id = id;
    }

    public String getDescription(){
    return description;
    }

       public void setDescription(String description){
         this.description = description;
    }


}
