package com.example.ticaretUstasi.controller;

import com.example.ticaretUstasi.businnes.abstracts.ExperienceService;
import com.example.ticaretUstasi.core.ultities.results.DataResult;
import com.example.ticaretUstasi.core.ultities.results.Result;
import com.example.ticaretUstasi.entity.concretes.Experience;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/experiences")
@CrossOrigin
public class ExperienceController {

    private ExperienceService experienceService;

    @Autowired
    public ExperienceController(ExperienceService experienceService) {
        this.experienceService = experienceService;
    }

    @PostMapping("/add")
    public Result add(@RequestBody Experience experience) {
        return experienceService.add(experience);
    }

    @PutMapping("/update")
    public Result update(@RequestBody Experience experience) {
        return experienceService.update(experience);
    }

    @DeleteMapping("/delete")
    public Result delete(@RequestParam int id) {
        return experienceService.delete(id);
    }

    @GetMapping("/getAll")
    public DataResult<List<Experience>> getAll() {
        return experienceService.getAll();
    }

    @GetMapping("/getById")
    public DataResult<Experience> getById(@RequestParam int id) {
        return experienceService.getById(id);
    }

    @GetMapping("/getAllByResumeIdSortedByTerminationDate")
    public DataResult<List<Experience>> getAllByResumeIdSortedByTerminationDate(@RequestParam int resumeId) {
        return experienceService.getAllByResumeIdSortedByTerminationDate(resumeId);
    }

}
