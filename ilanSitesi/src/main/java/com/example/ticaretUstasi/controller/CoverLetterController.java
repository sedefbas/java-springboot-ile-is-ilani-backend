package com.example.ticaretUstasi.controller;


import com.example.ticaretUstasi.businnes.abstracts.CoverLetterService;
import com.example.ticaretUstasi.core.ultities.results.DataResult;
import com.example.ticaretUstasi.core.ultities.results.Result;
import com.example.ticaretUstasi.entity.concretes.CoverLetter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/coverLetters")
@CrossOrigin
public class CoverLetterController {

    private CoverLetterService coverLetterService;

    @Autowired
    public CoverLetterController(CoverLetterService coverLetterService) {
        this.coverLetterService = coverLetterService;
    }

    @PostMapping("/add")
    public Result add(@RequestBody CoverLetter coverLetter) {
        return coverLetterService.add(coverLetter);
    }

    @PutMapping("/update")
    public Result update(@RequestBody CoverLetter coverLetter) {
        return coverLetterService.update(coverLetter);
    }

    @DeleteMapping("/delete")
    public Result delete(@RequestParam int id) {
        return coverLetterService.delete(id);
    }

    @GetMapping("/getAll")
    public DataResult<List<CoverLetter>> getAll() {
        return coverLetterService.getAll();
    }

    @GetMapping("/getById")
    public DataResult<CoverLetter> getById(@RequestParam int id) {
        return coverLetterService.getById(id);
    }

    @GetMapping("/getAllByCandidateId")
    public DataResult<List<CoverLetter>> getAllByCandidateId(@RequestParam int candidateId) {
        return coverLetterService.getAllByCandidateId(candidateId);
    }

}
