package uns.ftn.mbrs.model;

import javax.persistence.*;
import java.util.*;

import uns.ftn.mbrs.model.Pacient;
import uns.ftn.mbrs.model.Doctor;
import uns.ftn.mbrs.model.Therapy;

@Entity
@Table
public class Diagnosis {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @Column
    private String description;


    @OneToOne
    private Pacient pacient;

    @ManyToOne
    private Doctor doctor;

    @ManyToMany
    private Set<Therapy> therapies;

    public Long getId(){
         return id;
    }
    public void setId(Long id){
         this.id = id;
    }

    public String getName(){
    return name;
    }

       public void setName(String name){
         this.name = name;
    }

    public String getDescription(){
    return description;
    }

       public void setDescription(String description){
         this.description = description;
    }


}
