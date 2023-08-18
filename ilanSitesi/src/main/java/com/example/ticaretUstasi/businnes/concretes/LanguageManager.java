package com.example.ticaretUstasi.businnes.concretes;
import com.example.ticaretUstasi.businnes.abstracts.LanguageService;
import com.example.ticaretUstasi.core.ultities.results.DataResult;
import com.example.ticaretUstasi.core.ultities.results.Result;
import com.example.ticaretUstasi.core.ultities.results.SuccessDataResult;
import com.example.ticaretUstasi.core.ultities.results.SuccessResult;
import com.example.ticaretUstasi.entity.concretes.Language;
import com.example.ticaretUstasi.repository.abstracts.LanguageDao;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class LanguageManager implements LanguageService {
    private LanguageDao languageDao;

    public LanguageManager(LanguageDao languageDao) {
        this.languageDao = languageDao;
    }

    @Override
    public Result add(Language language) {
        return new SuccessResult(this.languageDao.save(language),"language eklendi");
    }

    @Override
    public Result update(Language language) {
        return new SuccessResult(this.languageDao.save(language),"language güncellendi");
    }

    @Override
    public Result delete(int id) {
        this.languageDao.deleteById(id);
        return new SuccessResult( id + " numaralı language silindi");
    }

    @Override
    public DataResult<List<Language>> getAll() {
        return new SuccessDataResult<List<Language>>(this.languageDao.findAll(),"hepsi listelendi");
    }

    @Override
    public DataResult<Language> getById(int id) {
        return new SuccessDataResult<Optional<Language>>(this.languageDao.findById(id),"hepsi listelendi");
    }
}
