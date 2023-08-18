package com.example.ticaretUstasi.businnes.abstracts;




import com.example.ticaretUstasi.core.ultities.results.DataResult;
import com.example.ticaretUstasi.core.ultities.results.Result;
import com.example.ticaretUstasi.entity.concretes.Candidate;

import java.util.List;

public interface CandicateService {
   DataResult<List<Candidate>> getAll();
   Result add(Candidate candidate);
   Result delete(int id);
   Result update(Candidate candidate);
   Result getById(int id);

}
