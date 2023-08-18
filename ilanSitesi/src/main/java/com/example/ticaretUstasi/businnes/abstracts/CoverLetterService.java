package com.example.ticaretUstasi.businnes.abstracts;
import com.example.ticaretUstasi.core.ultities.results.DataResult;
import com.example.ticaretUstasi.entity.concretes.CoverLetter;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CoverLetterService extends BaseEntityService<CoverLetter>{

    DataResult<List<CoverLetter>> getAllByCandidateId(int candidateId);
}
