package com.example.ticaretUstasi.entity.concretes;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "educations")
public class Education {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "university_name")
    private String universityName;
    @Column(name = "departman")
    private String departman;
    @Column(name = "starting_date")
    private LocalDate startingDate;
    @Column(name = "graduation_date")
    private LocalDate graduationDate;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "resume_id")
    private Resume resume;


    public String getGraduationDate() {

        if (graduationDate == null) {
            return "Devam ediyor.";
        }

        return graduationDate.toString();
    }


}
