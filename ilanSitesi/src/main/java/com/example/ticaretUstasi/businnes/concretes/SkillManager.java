package com.example.ticaretUstasi.businnes.concretes;

import com.example.ticaretUstasi.businnes.abstracts.SkillService;
import com.example.ticaretUstasi.core.ultities.results.DataResult;
import com.example.ticaretUstasi.core.ultities.results.Result;
import com.example.ticaretUstasi.core.ultities.results.SuccessDataResult;
import com.example.ticaretUstasi.core.ultities.results.SuccessResult;
import com.example.ticaretUstasi.entity.concretes.Skill;
import com.example.ticaretUstasi.repository.abstracts.SkillDao;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;


@Service
public class SkillManager implements SkillService {

    private SkillDao skillDao;

    public SkillManager(SkillDao skillDao) {
        this.skillDao = skillDao;
    }

    @Override
    public Result add(Skill skill) {
        return new SuccessResult(this.skillDao.save(skill),"skill eklendi");
    }

    @Override
    public Result update(Skill skill) {
        return new SuccessResult(this.skillDao.save(skill),"skill güncellendi  ");
    }

    @Override
    public Result delete(int id) {
        this.skillDao.deleteById(id);
        return new SuccessResult("skill silindi");
    }

    @Override
    public DataResult<List<Skill>> getAll() {
        return new SuccessDataResult<List<Skill>>(skillDao.findAll());
    }

    @Override
    public DataResult<Skill> getById(int id) {
        return new SuccessDataResult<Optional<Skill>>(this.skillDao.findById(id),"skill id seçimine göre getirildi.");
    }
}
