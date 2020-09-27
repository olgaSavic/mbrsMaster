package uns.ftn.mbrs.model;

import javax.persistence.*;
import java.util.*;

import uns.ftn.mbrs.model.Report;

@Entity
@Table
public class ReportItem {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @Column
    private String descriptioin;


    @ManyToMany
    private Set<Report> report;

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

    public String getDescriptioin(){
    return descriptioin;
    }

       public void setDescriptioin(String descriptioin){
         this.descriptioin = descriptioin;
    }


}
