package uns.ftn.mbrs.model;

import javax.persistence.*;
import java.util.*;

import uns.ftn.mbrs.model.Doctor;
import uns.ftn.mbrs.model.Symptom;
import uns.ftn.mbrs.model.Examination;
import uns.ftn.mbrs.model.Diagnosis;
import uns.ftn.mbrs.model.Therapy;

@Entity
@Table
public class Patient {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @Column
    private String surname;

    @Column
    private Long jmbg;
    @Column
    private String address;

    @Column
    private String phoneNumber;


    @ManyToOne
    private Doctor doctor;

    @ManyToMany
    private Set<Symptom> symptom;

    @OneToMany
    private Set<Examination> examination;

    @OneToMany
    private Set<Diagnosis> diagnosis;

    @ManyToMany
    private Set<Therapy> therapy;

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

    public String getSurname(){
    return surname;
    }

    public void setSurname(String surname){
         this.surname = surname;
    }

    public Long getJmbg(){
         return jmbg;
    }
    public void setJmbg(Long jmbg){
         this.jmbg = jmbg;
    }

    public String getAddress(){
    return address;
    }

    public void setAddress(String address){
         this.address = address;
    }

    public String getPhoneNumber(){
    return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber){
         this.phoneNumber = phoneNumber;
    }


    public Doctor getDoctor(){
        return doctor;
    }
    public void setDoctor(Doctor doctor){
        this.doctor = doctor;
    }

    public Set<Symptom> getSymptom(){
        return symptom;
    }
    public void setSymptom(Set<Symptom> symptom){
        this.symptom = symptom;
    }

    public Set<Examination> getExamination(){
        return examination;
    }
    public void setExamination(Set<Examination> examination){
        this.examination = examination;
    }

    public Set<Diagnosis> getDiagnosis(){
        return diagnosis;
    }
    public void setDiagnosis(Set<Diagnosis> diagnosis){
        this.diagnosis = diagnosis;
    }

    public Set<Therapy> getTherapy(){
        return therapy;
    }
    public void setTherapy(Set<Therapy> therapy){
        this.therapy = therapy;
    }

}
