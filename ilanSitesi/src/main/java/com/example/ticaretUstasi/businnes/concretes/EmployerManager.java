package com.example.ticaretUstasi.businnes.concretes;

import com.example.ticaretUstasi.businnes.abstracts.EmployerService;
import com.example.ticaretUstasi.core.ultities.results.DataResult;
import com.example.ticaretUstasi.core.ultities.results.SuccessDataResult;
import com.example.ticaretUstasi.repository.abstracts.EmployerDao;
import com.example.ticaretUstasi.entity.concretes.Employer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class EmployerManager implements EmployerService {

    private EmployerDao employerDao;
    @Autowired
    public EmployerManager(EmployerDao employerDao) {
        this.employerDao = employerDao;
    }

    @Override
    public DataResult<List<Employer>> getAll() {
        return  new SuccessDataResult<List<Employer>>(this.employerDao.findAll(),"employer başarıyla listelendi.");
    }
}
