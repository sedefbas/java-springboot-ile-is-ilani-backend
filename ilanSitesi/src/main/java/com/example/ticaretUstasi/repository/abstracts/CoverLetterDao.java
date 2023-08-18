package com.example.ticaretUstasi.repository.abstracts;

import com.example.ticaretUstasi.entity.concretes.CoverLetter;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CoverLetterDao extends JpaRepository<CoverLetter, Integer> {

    List<CoverLetter> getByCandidate_Id(int candidateId);

}
