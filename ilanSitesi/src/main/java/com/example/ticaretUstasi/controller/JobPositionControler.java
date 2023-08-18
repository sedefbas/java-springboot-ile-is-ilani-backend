package com.example.ticaretUstasi.controller;

import com.example.ticaretUstasi.businnes.abstracts.JobPositionService;
import com.example.ticaretUstasi.core.ultities.results.DataResult;
import com.example.ticaretUstasi.entity.concretes.JobPosition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/jobPosition")
@CrossOrigin
public class JobPositionControler {
    private JobPositionService jobPositionService;
   @Autowired
    public JobPositionControler(JobPositionService jobPositionService) {
        this.jobPositionService = jobPositionService;
    }
    @GetMapping("/getAll")
    public DataResult<List<JobPosition>> getAll() {
        return jobPositionService.getAll();
    }

}
