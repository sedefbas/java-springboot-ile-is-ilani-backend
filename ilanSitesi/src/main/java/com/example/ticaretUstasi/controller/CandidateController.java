package com.example.ticaretUstasi.controller;

import com.example.ticaretUstasi.businnes.abstracts.CandicateService;
import com.example.ticaretUstasi.core.ultities.results.DataResult;
import com.example.ticaretUstasi.core.ultities.results.Result;
import com.example.ticaretUstasi.entity.concretes.Candidate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/candidates")
@CrossOrigin
public class CandidateController {
    private CandicateService candicateService;

    @Autowired
    public CandidateController(CandicateService candicateService) {
        this.candicateService = candicateService;
    }

    @GetMapping("/getAll")
    public DataResult<List<Candidate>> getAll() {
        return candicateService.getAll();
    }

    @PostMapping("/add")
    public Result Add(@RequestBody Candidate candidate){
        return candicateService.add(candidate);
    }
    @DeleteMapping("/delete")
    public Result delete(@RequestParam int id){
        return candicateService.delete(id);
    }
    @PutMapping("/update")
    public Result update(@RequestBody Candidate candidate){
        return candicateService.update(candidate);
    }
    @GetMapping("/getById")
    public Result getById(int id){
        return candicateService.getById(id);
    }

}
