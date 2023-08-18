package com.example.ticaretUstasi.businnes.concretes;

import com.example.ticaretUstasi.businnes.abstracts.SkillFeatureService;

import com.example.ticaretUstasi.businnes.request.skill.SkillfeatureAdd;
import com.example.ticaretUstasi.core.ultities.results.DataResult;
import com.example.ticaretUstasi.core.ultities.results.Result;

import com.example.ticaretUstasi.core.ultities.results.SuccessDataResult;
import com.example.ticaretUstasi.core.ultities.results.SuccessResult;

import com.example.ticaretUstasi.entity.concretes.Skill;
import com.example.ticaretUstasi.entity.concretes.SkillFeature;
import com.example.ticaretUstasi.repository.abstracts.SkillFeatureDao;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class SkillFeatureManager implements SkillFeatureService {
    private SkillFeatureDao skillFeatureDao;

    public SkillFeatureManager(SkillFeatureDao skillFeatureDao) {
        this.skillFeatureDao = skillFeatureDao;
    }

    @Override
    public Result add(SkillfeatureAdd skillfeatureAdd) {
        SkillFeature skillFeature = new SkillFeature();
        skillFeature.setSkill(new Skill());
        skillFeature.getSkill().setSkillName(skillfeatureAdd.getSkillName());
        skillFeature.setSkillFeature(skillfeatureAdd.getSkillFeature());
        skillFeatureDao.save(skillFeature);
        return new SuccessResult("Link eklendi.");
    }

    @Override
    public Result update(SkillfeatureAdd skillfatureAdd) {
        SkillFeature skillFeature = new SkillFeature();
        skillFeature.setSkill(new Skill());
        skillFeature.setId(skillfatureAdd.getId());
        skillFeature.getSkill().setSkillName(skillfatureAdd.getSkillName());
        skillFeature.setSkillFeature(skillfatureAdd.getSkillFeature());
        skillFeatureDao.save(skillFeature);
        return new SuccessResult("skill eklendi.");
    }

    @Override
    public Result delete(int id) {
        skillFeatureDao.deleteById(id);
        return new SuccessResult("skill feature silindi.");
    }

    @Override
    public DataResult<List<SkillfeatureAdd>> getAll() {
        return new SuccessDataResult<List<SkillFeature>>(this.skillFeatureDao.findAll(),"skills getirildi");
    }

    @Override
    public DataResult<SkillfeatureAdd> getById(int id) {
        return new SuccessDataResult<Optional<SkillFeature>>(this.skillFeatureDao.findById(id),"skills getirildi");
    }
}
