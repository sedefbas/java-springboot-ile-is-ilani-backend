package com.example.ticaretUstasi.repository.abstracts;

import com.example.ticaretUstasi.entity.concretes.Candidate;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CandidateDao extends JpaRepository<Candidate,Integer> {
    boolean existsByIdentityNumber(String identityNumber);
    void deleteById(int id);
}
