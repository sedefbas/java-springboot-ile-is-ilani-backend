package com.example.ticaretUstasi.businnes.concretes;

import com.example.ticaretUstasi.businnes.abstracts.LanguageLevelService;
import com.example.ticaretUstasi.core.ultities.results.DataResult;
import com.example.ticaretUstasi.core.ultities.results.Result;
import com.example.ticaretUstasi.core.ultities.results.SuccessDataResult;
import com.example.ticaretUstasi.core.ultities.results.SuccessResult;

import com.example.ticaretUstasi.entity.concretes.LanguageLevel;
import com.example.ticaretUstasi.repository.abstracts.LanguageLevelDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LanguageLevelManager implements LanguageLevelService {

    private LanguageLevelDao languageLevelDao;

    @Autowired
    public LanguageLevelManager(LanguageLevelDao languageLevelDao) {
        this.languageLevelDao = languageLevelDao;
    }

    @Override
    public Result add(LanguageLevel languageLevel) {

        return new SuccessResult(this.languageLevelDao.save(languageLevel),"language eklendi");
    }

    @Override
    public Result update(LanguageLevel languageLevel) {
        return new SuccessResult(this.languageLevelDao.save(languageLevel),"Dil seviyesi güncellendi.");
    }

    @Override
    public Result delete(int id) {
        languageLevelDao.deleteById(id);
        return new SuccessResult("Dil seviyesi silindi.");
    }

    @Override
    public DataResult<List<LanguageLevel>> getAll() {
        return new SuccessDataResult<List<LanguageLevel>>(languageLevelDao.findAll());
    }

    @Override
    public DataResult<LanguageLevel> getById(int id) {
        return new SuccessDataResult<Optional<LanguageLevel>>(this.languageLevelDao.findById(id),"hepsi listelendi");
    }
}
