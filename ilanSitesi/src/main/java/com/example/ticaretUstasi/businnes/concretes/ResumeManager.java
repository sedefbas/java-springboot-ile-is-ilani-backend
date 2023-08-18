package com.example.ticaretUstasi.businnes.concretes;
import com.example.ticaretUstasi.businnes.abstracts.CoverLetterService;
import com.example.ticaretUstasi.businnes.abstracts.EducationService;
import com.example.ticaretUstasi.businnes.abstracts.ExperienceService;
import com.example.ticaretUstasi.businnes.abstracts.ResumeService;
import com.example.ticaretUstasi.businnes.request.Resume.ResumeAddRequest;
import com.example.ticaretUstasi.core.ultities.results.*;
import com.example.ticaretUstasi.entity.concretes.*;
import com.example.ticaretUstasi.repository.abstracts.ResumeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ResumeManager implements ResumeService {
    private ResumeDao resumeDao;
    private CoverLetterService coverLetterService;
    private EducationService educationService;
    private ExperienceService experienceService;

    @Autowired
    public ResumeManager(ResumeDao resumeDao, CoverLetterService coverLetterService, EducationService educationService, ExperienceService experienceService) {
        this.resumeDao = resumeDao;
        this.coverLetterService = coverLetterService;
        this.educationService = educationService;
        this.experienceService = experienceService;
    }

    @Override
    public Result add(ResumeAddRequest resumeAddRequest) {
        Resume resume = new Resume();
        resume.setCreationDate(LocalDateTime.now());
        resume.getCandidate().setId(resumeAddRequest.getCandidateId());
        resume.getCoverLetter().setId(resumeAddRequest.getCoverLetterId());
        Candidate candidate = new Candidate();
        candidate.setId(resumeAddRequest.getCandidateId());
        resume.setCandidate(candidate);

        CoverLetter coverLetter = new CoverLetter();
        coverLetter.setId(resumeAddRequest.getCoverLetterId());
        resume.setCoverLetter(coverLetter);

        List<Education> educations = resumeAddRequest.getEducations();
        for (Education education : educations) {
            education.setResume(resume);
            educationService.add(education);
        }

        List<Experience> experiences = resumeAddRequest.getExperiences();
        for (Experience experience : experiences) {
            experience.setResume(resume);
            experienceService.add(experience);
        }

        resumeDao.save(resume);
        return new SuccessResult(resume, "Özgeçmiş başarıyla eklendi.");
    }

    @Override
    public Result update(ResumeAddRequest resumeAddRequest) {
        Optional<Resume> existingResumeOptional = resumeDao.findById(resumeAddRequest.getId());
        if (existingResumeOptional.isEmpty()) {
            return new ErrorResult("Özgeçmiş bulunamadı.");
        }

        Resume existingResume = existingResumeOptional.get();
        existingResume.setCreationDate(LocalDateTime.now());

        resumeDao.save(existingResume);
        return new SuccessResult("Özgeçmiş güncellendi.");
    }


    @Override
    public Result delete(int id) {
        resumeDao.deleteById(id);
        return new SuccessResult("Özgeçmiş silindi.");
    }

    @Override
    public DataResult<List<Resume>> getAll() {
        Sort sort = Sort.by(Sort.Direction.DESC, "creationDate");
        return new SuccessDataResult<List<Resume>>(resumeDao.findAll(sort));
    }

    @Override
    public DataResult<ResumeAddRequest> getById(int id) {
        return new SuccessDataResult<Optional<Resume>>(resumeDao.findById(id));
    }

    @Override
    public Result addCoverLetterToResume(int resumeId, int coverLetterId) {
        ResumeAddRequest resumeAddRequest = getById(resumeId).getData();
        resumeAddRequest.setCoverLetterId(coverLetterId);

        update(resumeAddRequest);
        return new SuccessResult("Ön yazı özgeçmişe eklendi.");
    }

    @Override
    public Result deleteCoverLetterFromResume(int resumeId) {
        ResumeAddRequest resumeAddRequest = getById(resumeId).getData();
        resumeAddRequest.setCoverLetterId(null);

        update(resumeAddRequest);
        return new SuccessResult("Ön yazı özgeçmişten kaldırıldı.");
    }

    @Override
    public DataResult<Resume> getByCandidateId(int candidateId) {
        return new SuccessDataResult<Resume>(resumeDao.findByCandidate_Id(candidateId));
    }
}
