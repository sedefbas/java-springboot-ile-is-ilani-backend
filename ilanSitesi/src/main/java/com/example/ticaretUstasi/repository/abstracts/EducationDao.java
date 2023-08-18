package com.example.ticaretUstasi.repository.abstracts;

import com.example.ticaretUstasi.entity.concretes.Education;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EducationDao extends JpaRepository<Education,Integer> {

    List<Education> getByResume_Id(int resumeId);

    List<Education> getByResume_Id(int resumeId, Sort sort);

}
