package com.example.ticaretUstasi.controller;

import com.example.ticaretUstasi.businnes.abstracts.LanguageService;
import com.example.ticaretUstasi.core.ultities.results.DataResult;
import com.example.ticaretUstasi.core.ultities.results.Result;
import com.example.ticaretUstasi.entity.concretes.Language;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/languages")
@CrossOrigin

public class LanguageController {
    private LanguageService languageService;

    @Autowired
    public LanguageController(LanguageService languageService) {
        this.languageService = languageService;
    }

    @PostMapping("/add")
    public Result add(@RequestBody Language language) {
        return languageService.add(language);
    }

    @PutMapping("/update")
    public Result update(@RequestBody Language language) {
        return languageService.update(language);
    }

    @GetMapping("/getAll")
    public DataResult<List<Language>> getAll() {
        return languageService.getAll();
    }

    @GetMapping("/getById")
    public DataResult<Language> getById(@RequestParam int id) {
        return languageService.getById(id);
    }
}
