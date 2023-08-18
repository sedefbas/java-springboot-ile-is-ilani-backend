package com.example.ticaretUstasi.controller;
import com.example.ticaretUstasi.businnes.abstracts.LanguageLevelService;
import com.example.ticaretUstasi.core.ultities.results.DataResult;
import com.example.ticaretUstasi.core.ultities.results.Result;
import com.example.ticaretUstasi.entity.concretes.LanguageLevel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/languageLevels")
@CrossOrigin
public class LanguageLevelController {

    private LanguageLevelService languageLevelService;

    @Autowired
    public LanguageLevelController(LanguageLevelService languageLevelService) {
        this.languageLevelService = languageLevelService;
    }

    @PostMapping("/add")
    public Result add(@RequestBody LanguageLevel languageLevel) {
        return languageLevelService.add(languageLevel);
    }

    @PutMapping("/update")
    public Result update(@RequestBody LanguageLevel languageLevel) {
        return languageLevelService.update(languageLevel);
    }

    @DeleteMapping("/delete")
    public Result delete(@RequestParam int id) {
        return languageLevelService.delete(id);
    }

    @GetMapping("/getAll")
    public DataResult<List<LanguageLevel>> getAll() {
        return languageLevelService.getAll();
    }

    @GetMapping("/getById")
    public DataResult<LanguageLevel> getById(@RequestParam int id) {
        return languageLevelService.getById(id);
    }
}