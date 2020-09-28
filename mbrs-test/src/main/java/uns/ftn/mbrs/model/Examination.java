package uns.ftn.mbrs.model;

import javax.persistence.*;
import java.util.*;

import uns.ftn.mbrs.model.Doctor;
import uns.ftn.mbrs.model.Patient;
import uns.ftn.mbrs.model.Report;

@Entity
@Table
public class Examination {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @Column
    private String date;


    @ManyToOne
    private Doctor doctor;

    @ManyToOne
    private Patient patient;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "examination")
    private Set<Report> report;

    public Long getId(){
         return id;
    }
    public void setId(Long id){
         this.id = id;
    }

    public String getDate(){
    return date;
    }

    public void setDate(String date){
         this.date = date;
    }


    public Doctor getDoctor(){
        return doctor;
    }
    public void setDoctor(Doctor doctor){
        this.doctor = doctor;
    }
    public Patient getPatient(){
        return patient;
    }
    public void setPatient(Patient patient){
        this.patient = patient;
    }

    public Set<Report> getReport(){
        return report;
    }
    public void setReport(Set<Report> report){
        this.report = report;
    }

}
