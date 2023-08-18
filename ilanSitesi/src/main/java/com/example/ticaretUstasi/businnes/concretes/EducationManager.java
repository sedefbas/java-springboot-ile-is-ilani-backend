package com.example.ticaretUstasi.businnes.concretes;

import com.example.ticaretUstasi.businnes.abstracts.EducationService;
import com.example.ticaretUstasi.core.ultities.results.DataResult;
import com.example.ticaretUstasi.core.ultities.results.Result;
import com.example.ticaretUstasi.core.ultities.results.SuccessDataResult;
import com.example.ticaretUstasi.core.ultities.results.SuccessResult;
import com.example.ticaretUstasi.entity.concretes.Education;
import com.example.ticaretUstasi.repository.abstracts.EducationDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EducationManager implements EducationService {

    private EducationDao educationDao;

    @Autowired
    public EducationManager(EducationDao educationDao) {
        this.educationDao = educationDao;
    }

    @Override
    public Result add(Education education) {
        return new SuccessResult(this.educationDao.save(education),"Eğitim eklendi.");
    }

    @Override
    public Result update(Education education) {
        educationDao.save(education);
        return new SuccessResult("Eğitim güncellendi.");
    }

    @Override
    public Result delete(int id) {

        educationDao.deleteById(id);
        return new SuccessResult("Eğitim silindi.");
    }

    @Override
    public DataResult<List<Education>> getAll() {
        return new SuccessDataResult<List<Education>>(educationDao.findAll(),"tüm eğitimler getirildi.");
    }

    @Override
    public DataResult<Education> getById(int id) {
        return new SuccessDataResult<Optional<Education>>(educationDao.findById(id),"id ye göre getirildi.");
    }

    @Override
    public DataResult<List<Education>> getAllByResumeId(int resumeId) {
        return new SuccessDataResult<List<Education>>(educationDao.getByResume_Id(resumeId));
    }

    @Override
    public DataResult<List<Education>> getAllByResumeIdSortedByGraduationDate(int resumeId) {

        Sort sort = Sort.by(Sort.Direction.DESC, "graduationDate");

        return new SuccessDataResult<List<Education>>(educationDao.getByResume_Id(resumeId, sort));
    }

}
