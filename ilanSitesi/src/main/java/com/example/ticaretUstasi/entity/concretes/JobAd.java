package com.example.ticaretUstasi.entity.concretes;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "job_ad")
@Getter
@Setter
public class JobAd {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "job_ad_title")
    private String JobTitle;

    @Column(name = "job_description")
    private String jobDescription;
    @NotNull
    @Column(name = "number_of_open_positions")
    private int numberOfOpenPositions;

    @Column(name = "salary_min")
    private String salaryMin;

    @Column(name = "salary_max")
    private String salaryMax;

    @Column(name = "posting_date")
    private LocalDateTime postingDate;

    @Column(name = "closing_date")
    private LocalDate closingDate;

    @Column(name = "is_active")
    private boolean isActive;

    @ManyToOne
    @JoinColumn(name = "employer_id")
    private Employer employer;


    @ManyToOne()
    @JoinColumn(name = "job_title_id")
    private JobPosition jobPosition;

    @JsonIgnoreProperties({"cityName"})
    @ManyToOne()
    @JoinColumn(name = "city_id")
    private City city;

    @JsonIgnoreProperties({"WorkTimeName"})
    @ManyToOne()
    @JoinColumn(name = "working_time_id")
    private WorkTime workingTime;

    @JsonIgnoreProperties({"WorktypeName"})
    @ManyToOne()
    @JoinColumn(name = "working_type_id")
    private WorkType workingType;




}
