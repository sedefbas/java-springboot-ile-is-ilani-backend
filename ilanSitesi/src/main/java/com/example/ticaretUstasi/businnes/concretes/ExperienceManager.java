package com.example.ticaretUstasi.businnes.concretes;

import com.example.ticaretUstasi.businnes.abstracts.ExperienceService;
import com.example.ticaretUstasi.core.ultities.results.DataResult;
import com.example.ticaretUstasi.core.ultities.results.Result;
import com.example.ticaretUstasi.core.ultities.results.SuccessDataResult;
import com.example.ticaretUstasi.core.ultities.results.SuccessResult;
import com.example.ticaretUstasi.entity.concretes.Experience;
import com.example.ticaretUstasi.entity.concretes.Resume;
import com.example.ticaretUstasi.repository.abstracts.ExperienceDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class ExperienceManager implements ExperienceService {

    private ExperienceDao experienceDao;

    @Autowired
    public ExperienceManager(ExperienceDao experienceDao) {
        this.experienceDao = experienceDao;
    }

    @Override
    public Result add(Experience experience) {
        return new SuccessResult(this.experienceDao.save(experience),"İş deneyimi eklendi.");
    }

    @Override
    public Result update(Experience experience) {

        return new SuccessResult(this.experienceDao.save(experience),"İş deneyimi güncellendi.");
    }

    @Override
    public Result delete(int id) {
        experienceDao.deleteById(id);
        return new SuccessResult("İş deneyimi silindi.");
    }

    @Override
    public DataResult<List<Experience>> getAll() {
        return new SuccessDataResult<List<Experience>>(experienceDao.findAll());
    }

    @Override
    public DataResult<Experience> getById(int id) {
        return new SuccessDataResult<Optional<Experience>>(experienceDao.findById(id));
    }

    @Override
    public DataResult<List<Experience>> getAllByResumeId(int resumeId) {
        return new SuccessDataResult<List<Experience>>(experienceDao.getByResume_Id(resumeId));
    }

    @Override
    public DataResult<List<Experience>> getAllByResumeIdSortedByTerminationDate(int resumeId) {

        Sort sort = Sort.by(Sort.Direction.DESC, "terminationDate");

        return new SuccessDataResult<List<Experience>>(experienceDao.getByResume_Id(resumeId, sort));
    }



}