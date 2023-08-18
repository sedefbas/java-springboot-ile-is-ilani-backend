package com.example.ticaretUstasi.controller;

import com.example.ticaretUstasi.businnes.abstracts.EmployerService;
import com.example.ticaretUstasi.core.ultities.results.DataResult;
import com.example.ticaretUstasi.entity.concretes.Employer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/employers")
@CrossOrigin
public class EmployerController {
    private EmployerService employerService;
    @Autowired
    public EmployerController(EmployerService employerService) {
        this.employerService = employerService;
    }
    @GetMapping("/getAll")
    public DataResult<List<Employer>> getAll() {
        return employerService.getAll();
    }
}
