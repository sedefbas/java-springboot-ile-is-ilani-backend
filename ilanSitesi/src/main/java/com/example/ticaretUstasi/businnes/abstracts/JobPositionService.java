package com.example.ticaretUstasi.businnes.abstracts;
import com.example.ticaretUstasi.entity.concretes.JobPosition;
import com.example.ticaretUstasi.core.ultities.results.DataResult;
import java.util.List;

public interface JobPositionService {
    DataResult<List<JobPosition>> getAll();
}
