package com.example.ticaretUstasi.repository.abstracts;
import com.example.ticaretUstasi.entity.concretes.Resume;
import org.springframework.data.jpa.repository.JpaRepository;
public interface ResumeDao extends JpaRepository<Resume,Integer> {

    Resume findByCandidate_Id(int candidateId);

    Resume findByCoverLetter_Id(int coverLetterId);



}
