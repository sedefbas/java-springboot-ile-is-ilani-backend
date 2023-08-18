package com.example.ticaretUstasi.controller;


import com.example.ticaretUstasi.businnes.abstracts.EducationService;
import com.example.ticaretUstasi.core.ultities.results.DataResult;
import com.example.ticaretUstasi.core.ultities.results.Result;
import com.example.ticaretUstasi.entity.concretes.Education;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/educations")
@CrossOrigin
public class EducationController {

    private EducationService educationService;

    @Autowired
    public EducationController(EducationService educationService) {
        this.educationService = educationService;
    }

    @PostMapping("/add")
    public Result add(@RequestBody Education education) {
        return educationService.add(education);
    }

    @PutMapping("/update")
    public Result update(@RequestBody Education education) {
        return educationService.update(education);
    }

    @DeleteMapping("/delete")
    public Result delete(@RequestParam int id) {
        return educationService.delete(id);
    }

    @GetMapping("/getAll")
    public DataResult<List<Education>> getAll() {
        return educationService.getAll();
    }

    @GetMapping("/getById")
    public DataResult<Education> getById(@RequestParam int id) {
        return educationService.getById(id);
    }

    @GetMapping("/getAllByResumeIdSortedByGraduationDate")
    public DataResult<List<Education>> getAllByResumeIdSortedByGraduationDate(@RequestParam int resumeId) {
        return educationService.getAllByResumeIdSortedByGraduationDate(resumeId);
    }

}