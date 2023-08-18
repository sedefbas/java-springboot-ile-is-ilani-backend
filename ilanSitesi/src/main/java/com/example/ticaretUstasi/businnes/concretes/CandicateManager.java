package com.example.ticaretUstasi.businnes.concretes;

import com.example.ticaretUstasi.businnes.abstracts.CandicateService;
import com.example.ticaretUstasi.core.entity.User;
import com.example.ticaretUstasi.core.ultities.results.*;
import com.example.ticaretUstasi.entity.concretes.Candidate;
import com.example.ticaretUstasi.core.repository.UserDao;
import com.example.ticaretUstasi.repository.abstracts.CandidateDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CandicateManager implements CandicateService {

    private CandidateDao candidateDao;
    private UserDao userDao;

    @Autowired
    public CandicateManager(CandidateDao candidateDao, UserDao userDao) {
        this.candidateDao = candidateDao;
        this.userDao = userDao;
    }


    @Override
    public DataResult<List<Candidate>> getAll() {
        return new SuccessDataResult<List<Candidate>>(this.candidateDao.findAll(),"listeleme başarıyla gerçekleşti.");
    }

    @Override
    public Result add(Candidate candidate) {
        if (isEmailOrTcNoEmpty(candidate.getEmail(), candidate.getIdentityNumber())) {
            return new ErrorResult("Email veya TC no boş olamaz.");
        }

        if (isEmailOrTcNoExists(candidate.getEmail(), candidate.getIdentityNumber())) {
            return new ErrorResult("Bu email veya TC no zaten kayıtlı.");
        }
        this.candidateDao.save(candidate);

        return new SuccessResult("Aday başarıyla eklendi.");
    }




    @Override
    public Result delete(int id) {
        Optional<Candidate> candidateOptional = candidateDao.findById(id);
        if (candidateOptional.isPresent()) {
            Candidate candidate = candidateOptional.get();
            if (candidate instanceof User) {
                candidateDao.deleteById(id);
                return new SuccessResult("Aday başarıyla silindi.");
            } else {
                return new ErrorResult("Bu id, Candidate tablosuna ait değil.");
            }
        }
        return new ErrorResult("Bu id, Candidate tablosuna ait değil.");
    }





    @Override
    public Result update(Candidate candidate) {
        Optional<Candidate> c = candidateDao.findById(candidate.getId());

        if (c.isPresent()) {
            Candidate existingCandidate = c.get();

            candidate.setEmail(candidate.getEmail() == null || candidate.getEmail().isEmpty()
                    ? existingCandidate.getEmail()
                    : candidate.getEmail());
            candidate.setPassword(candidate.getPassword() == null || candidate.getPassword().isEmpty()
                    ? existingCandidate.getPassword()
                    : candidate.getPassword());
            candidate.setFirstName(candidate.getFirstName() == null || candidate.getFirstName().isEmpty()
                    ? existingCandidate.getFirstName()
                    : candidate.getFirstName());
            candidate.setLastName(candidate.getLastName() == null || candidate.getLastName().isEmpty()
                    ? existingCandidate.getLastName()
                    : candidate.getLastName());
            candidate.setIdentityNumber(candidate.getIdentityNumber() == null || candidate.getIdentityNumber().isEmpty()
                    ? existingCandidate.getIdentityNumber()
                    : candidate.getIdentityNumber());
            candidate.setDateOfBirth(candidate.getDateOfBirth() == null
                    ? existingCandidate.getDateOfBirth()
                    : candidate.getDateOfBirth());

            this.candidateDao.save(candidate);
            return new SuccessResult("Aday başarıyla güncellendi.");
        } else {
            return new ErrorResult("Belirtilen ID'ye sahip aday bulunamadı.");
        }
    }

    @Override
    public Result getById(int id) {
        return new SuccessDataResult<>(this.candidateDao.findById(id), "ID baz alınarak aday getirildi.");
    }





    private boolean isEmailOrTcNoEmpty(String email, String tcNo) {
        return email == null || email.isEmpty() || tcNo == null || tcNo.isEmpty();
    }

    private boolean isEmailOrTcNoExists(String email, String tcNo) {
        boolean emailExists = userDao.existsByEmail(email);
        boolean tcNoExists = candidateDao.existsByIdentityNumber(tcNo);

        return emailExists || tcNoExists;
    }


}