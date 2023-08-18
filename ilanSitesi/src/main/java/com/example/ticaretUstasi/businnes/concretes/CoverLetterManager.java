package com.example.ticaretUstasi.businnes.concretes;

import com.example.ticaretUstasi.businnes.abstracts.CoverLetterService;
import com.example.ticaretUstasi.core.ultities.results.DataResult;
import com.example.ticaretUstasi.core.ultities.results.Result;
import com.example.ticaretUstasi.core.ultities.results.SuccessDataResult;
import com.example.ticaretUstasi.core.ultities.results.SuccessResult;
import com.example.ticaretUstasi.entity.concretes.CoverLetter;
import com.example.ticaretUstasi.repository.abstracts.CoverLetterDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CoverLetterManager implements CoverLetterService {

    private CoverLetterDao coverLetterDao;

    @Autowired
    public CoverLetterManager(CoverLetterDao coverLetterDao) {
        this.coverLetterDao = coverLetterDao;
    }

    @Override
    public Result add(CoverLetter coverLetter) {

        return new SuccessResult(  this.coverLetterDao.save(coverLetter),"Ön yazı eklendi.");
    }

    @Override
    public Result update(CoverLetter coverLetter) {

        return new SuccessResult(  this.coverLetterDao.save(coverLetter),"Ön yazı eklendi.");
    }

    @Override
    public Result delete(int id) {

        coverLetterDao.deleteById(id);
        return new SuccessResult("Ön yazı silindi.");
    }

    @Override
    public DataResult<List<CoverLetter>> getAll() {
        return new SuccessDataResult<List<CoverLetter>>(coverLetterDao.findAll());
    }

    @Override
    public DataResult<CoverLetter> getById(int id) {
        return new SuccessDataResult<Optional<CoverLetter>>(coverLetterDao.findById(id));
    }

    @Override
    public DataResult<List<CoverLetter>> getAllByCandidateId(int candidateId) {
        return new SuccessDataResult<List<CoverLetter>>(coverLetterDao.getByCandidate_Id(candidateId));
    }

}
