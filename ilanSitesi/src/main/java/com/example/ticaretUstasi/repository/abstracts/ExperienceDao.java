package com.example.ticaretUstasi.repository.abstracts;
import com.example.ticaretUstasi.entity.concretes.Experience;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;


public interface ExperienceDao extends JpaRepository<Experience, Integer> {

    List<Experience> getByResume_Id(int resumeId);

    List<Experience> getByResume_Id(int resumeId, Sort sort);

}
