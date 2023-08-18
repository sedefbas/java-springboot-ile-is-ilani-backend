package com.example.ticaretUstasi.repository.abstracts;

import com.example.ticaretUstasi.entity.concretes.JobAd;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface JobAdDao extends JpaRepository<JobAd,Integer> {
    List<JobAd>  findByIsActive(boolean active);
    List<JobAd>  findAllByEmployerIdAndIsActive(int employerId,boolean active);

    List<JobAd> findByIsActiveOrderByPostingDateDesc(boolean active);


}
