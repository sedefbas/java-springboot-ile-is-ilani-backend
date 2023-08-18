package com.example.ticaretUstasi.entity.concretes;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
@Table(name = "resumes")
@Getter
@Setter
public class Resume {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "creation_date")
    private LocalDateTime creationDate;

    @OneToOne
    @JoinColumn(name = "candidate_id")
    private Candidate candidate;


    @OneToOne
    @JoinColumn(name = "cover_letter_id")
    private CoverLetter coverLetter;


    @OneToMany(mappedBy = "resume")
    private List<Education> educations;


    @OneToMany(mappedBy = "resume")
    private List<Experience> experiences;


    @OneToMany()
    private List<LanguageLevel> languageLevels;


    @OneToMany(mappedBy = "resume")
    private List<Link> links;


    @OneToMany(mappedBy = "resume")
    private List<SkillFeature> skillFeatures;

    public Resume(Candidate candidate) {
        this.setCandidate(candidate);
    }

}
