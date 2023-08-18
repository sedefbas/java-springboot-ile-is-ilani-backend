package com.example.ticaretUstasi.repository.abstracts;

import com.example.ticaretUstasi.entity.concretes.JobAdConfirmation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobAdConfirmationDao extends JpaRepository<JobAdConfirmation,Integer> {
    JobAdConfirmation findByJobAd_Id(int jobPostingId);
}
