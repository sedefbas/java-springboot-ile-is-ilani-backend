package com.example.ticaretUstasi.controller;

import com.example.ticaretUstasi.businnes.abstracts.ResumeService;
import com.example.ticaretUstasi.businnes.request.Resume.ResumeAddRequest;
import com.example.ticaretUstasi.core.ultities.results.DataResult;
import com.example.ticaretUstasi.core.ultities.results.Result;
import com.example.ticaretUstasi.entity.concretes.Resume;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/resumes")
@CrossOrigin
public class ResumeController {

    private ResumeService resumeService;

    @Autowired
    public ResumeController(ResumeService resumeService) {
        this.resumeService = resumeService;
    }

    @PostMapping("/add")
    public Result add(@RequestBody ResumeAddRequest resume) {
        return resumeService.add(resume);
    }

    @PutMapping("/update")
    public Result update(@RequestBody ResumeAddRequest resume) {
        return resumeService.update(resume);
    }

    @DeleteMapping("/delete")
    public Result delete(@RequestParam int id) {
        return resumeService.delete(id);
    }

    @GetMapping("/getAll")
    public DataResult<List<Resume>> getAll() {
        return resumeService.getAll();
    }

    @GetMapping("/getById")
    public DataResult<ResumeAddRequest> getById(@RequestParam int id) {
        return resumeService.getById(id);
    }

    @PostMapping("/addCoverLetterToResume")
    public Result addCoverLetterToResume(@RequestParam int resumeId, @RequestParam int coverLetterId) {
        return resumeService.addCoverLetterToResume(resumeId, coverLetterId);
    }

    @DeleteMapping("/deleteCoverLetterFromResume")
    public Result deleteCoverLetterFromResume(@RequestParam int resumeId) {
        return resumeService.deleteCoverLetterFromResume(resumeId);
    }


    @GetMapping("/getByCandidateId")
    public DataResult<Resume> getByCandidateId(@RequestParam int candidateId) {
        return resumeService.getByCandidateId(candidateId);
    }

}
