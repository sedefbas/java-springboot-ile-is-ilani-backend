package com.example.ticaretUstasi.controller;

import com.example.ticaretUstasi.businnes.abstracts.SkillFeatureService;
import com.example.ticaretUstasi.businnes.request.skill.SkillfeatureAdd;
import com.example.ticaretUstasi.core.ultities.results.DataResult;
import com.example.ticaretUstasi.core.ultities.results.Result;
import com.example.ticaretUstasi.entity.concretes.SkillFeature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/skillFeatures")
@CrossOrigin
public class SkillFeatureController {
    private SkillFeatureService skillFeatureService;

    @Autowired
    public SkillFeatureController(SkillFeatureService skillFeatureService) {
        this.skillFeatureService = skillFeatureService;
    }

    @PostMapping("/add")
    public Result add(@RequestBody SkillfeatureAdd skillFeature) {
        return skillFeatureService.add(skillFeature);
    }

    @PutMapping("/update")
    public Result update(@RequestBody SkillfeatureAdd skill) {
        return skillFeatureService.update(skill);
    }

    @DeleteMapping("/delete")
    public Result delete(@RequestParam int id) {
        return skillFeatureService.delete(id);
    }

    @GetMapping("/getAll")
    public DataResult<List<SkillfeatureAdd>> getAll() {
        return skillFeatureService.getAll();
    }

    @GetMapping("/getById")
    public DataResult<SkillfeatureAdd> getById(@RequestParam int id) {
        return skillFeatureService.getById(id);
    }
}
