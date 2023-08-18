package com.example.ticaretUstasi.controller;

import com.example.ticaretUstasi.businnes.abstracts.SkillService;
import com.example.ticaretUstasi.core.ultities.results.DataResult;
import com.example.ticaretUstasi.core.ultities.results.Result;
import com.example.ticaretUstasi.entity.concretes.Skill;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/skill")
@CrossOrigin
public class SkillController {
    private SkillService skillService;

    @Autowired
    public SkillController(SkillService skillService) {
        this.skillService = skillService;
    }

    @PostMapping("/add")
    public Result add(@RequestBody Skill skill) {
        return skillService.add(skill);
    }

    @PutMapping("/update")
    public Result update(@RequestBody Skill skill) {
        return skillService.update(skill);
    }

    @DeleteMapping("/delete")
    public Result delete(@RequestParam int id) {
        return skillService.delete(id);
    }

    @GetMapping("/getAll")
    public DataResult<List<Skill>> getAll() {
        return skillService.getAll();
    }

    @GetMapping("/getById")
    public DataResult<Skill> getById(@RequestParam int id) {
        return skillService.getById(id);
    }


}
