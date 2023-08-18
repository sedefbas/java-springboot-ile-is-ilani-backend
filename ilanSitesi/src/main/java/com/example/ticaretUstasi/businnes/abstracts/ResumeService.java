package com.example.ticaretUstasi.businnes.abstracts;

import com.example.ticaretUstasi.businnes.request.Resume.ResumeAddRequest;
import com.example.ticaretUstasi.core.ultities.results.DataResult;
import com.example.ticaretUstasi.core.ultities.results.Result;
import com.example.ticaretUstasi.entity.concretes.Resume;

import java.util.List;

public interface ResumeService {

    Result addCoverLetterToResume(int resumeId, int coverLetterId);

    Result deleteCoverLetterFromResume(int resumeId);

    DataResult<Resume> getByCandidateId(int candidateId);
    DataResult<ResumeAddRequest> getById(int id);
    public Result delete(int id);
    Result update(ResumeAddRequest resumeAddRequest);
    Result add(ResumeAddRequest resumeAddRequest);
    DataResult<List<Resume>> getAll();

}
