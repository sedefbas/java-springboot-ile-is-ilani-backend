package com.example.ticaretUstasi.businnes.concretes;

import com.example.ticaretUstasi.businnes.abstracts.CompanyStaffService;
import com.example.ticaretUstasi.core.ultities.results.DataResult;
import com.example.ticaretUstasi.core.ultities.results.Result;
import com.example.ticaretUstasi.core.ultities.results.SuccessDataResult;
import com.example.ticaretUstasi.core.ultities.results.SuccessResult;
import com.example.ticaretUstasi.entity.concretes.Candidate;
import com.example.ticaretUstasi.entity.concretes.CompanyStaff;
import com.example.ticaretUstasi.repository.abstracts.CompanyStaffDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CompanyStaffManager implements CompanyStaffService {
    private CompanyStaffDao companyStaffDao;

    @Autowired
    public CompanyStaffManager(CompanyStaffDao companyStaffDao) {
        this.companyStaffDao = companyStaffDao;
    }

    @Override
    public Result add(CompanyStaff companyStaff) {
        return new SuccessResult( this.companyStaffDao.save(companyStaff),"Şirket personeli eklendi.");
    }

    @Override
    public Result update(CompanyStaff companyStaff) {

        Optional<CompanyStaff> c = companyStaffDao.findById(companyStaff.getId());

        if (c.isPresent()) {
            CompanyStaff existingCompanyStaff = c.get();

            companyStaff.setEmail(companyStaff.getEmail() == null || companyStaff.getEmail() == ""
                    ? existingCompanyStaff.getEmail()
                    : companyStaff.getEmail());
            companyStaff.setPassword(companyStaff.getPassword() == null || companyStaff.getPassword() == ""
                    ? existingCompanyStaff.getPassword()
                    : companyStaff.getPassword());
            companyStaff.setFirstName(companyStaff.getFirstName() == null || companyStaff.getFirstName() == ""
                    ? existingCompanyStaff.getFirstName()
                    : companyStaff.getFirstName());
            companyStaff.setLastName(companyStaff.getLastName() == null || companyStaff.getLastName() == ""
                    ? existingCompanyStaff.getLastName()
                    : companyStaff.getLastName());
        }
        return new SuccessResult( companyStaffDao.save(companyStaff),"Şirket personeli güncellendi.");
    }

    @Override
    public Result delete(int id) {

        companyStaffDao.deleteById(id);
        return new SuccessResult("Şirket personeli silindi.");
    }

    @Override
    public DataResult<List<CompanyStaff>> getAll() {
        return new SuccessDataResult<List<CompanyStaff>>(companyStaffDao.findAll(),"hepsi getirildi");
    }

    @Override
    public DataResult<CompanyStaff> getById(int id) {
        return new SuccessDataResult<Optional<CompanyStaff>>(companyStaffDao.findById(id),"id ye göre getirildi");
    }

}
