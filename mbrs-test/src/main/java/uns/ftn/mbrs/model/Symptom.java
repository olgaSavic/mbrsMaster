package uns.ftn.mbrs.model;

import javax.persistence.*;
import java.util.*;

import uns.ftn.mbrs.model.Patient;

@Entity
@Table
public class Symptom {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @Column
    private String description;


    @ManyToMany
    private Set<Patient> patient;

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



    public Set<Patient> getPatient(){
        return patient;
    }
    public void setPatient(Set<Patient> patient){
        this.patient = patient;
    }

}
