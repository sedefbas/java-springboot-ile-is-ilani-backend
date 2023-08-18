package com.example.ticaretUstasi.entity.concretes;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
@Table(name = "job_ad_confirmations")
public class JobAdConfirmation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "is_confirmed")
    private boolean isConfirmed;

    @Column(name = "is_confirmed_date")
    private LocalDateTime isConfirmedDate;

    @OneToOne()
    @JoinColumn(name = "job_posting_id")
    private JobAd jobAd;

    @ManyToOne()
    @JoinColumn(name = "company_staff_id")
    private CompanyStaff companyStaff;

    @ManyToOne()
    @JoinColumn(name = "job_posting_confirmation_type_id")
    private JobAdConfirmationType jobAdConfirmationType;

    public JobAdConfirmation(JobAd jobAd, CompanyStaff companyStaff, JobAdConfirmationType jobAdConfirmationType, boolean isConfirmed) {
        this.setJobAd(jobAd);
        this.setCompanyStaff(companyStaff);
        this.setJobAdConfirmationType(jobAdConfirmationType);
        this.setConfirmed(isConfirmed);
    }

}
