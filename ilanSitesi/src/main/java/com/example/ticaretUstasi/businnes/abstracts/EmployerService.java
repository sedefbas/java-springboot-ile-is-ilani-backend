package com.example.ticaretUstasi.businnes.abstracts;

import com.example.ticaretUstasi.core.ultities.results.DataResult;
import com.example.ticaretUstasi.entity.concretes.Employer;

import java.util.List;

public interface EmployerService {
    DataResult<List<Employer>> getAll();
}
