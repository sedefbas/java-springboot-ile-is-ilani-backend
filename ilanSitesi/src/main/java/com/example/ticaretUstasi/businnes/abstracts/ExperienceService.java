package com.example.ticaretUstasi.businnes.abstracts;

import com.example.ticaretUstasi.core.ultities.results.DataResult;
import com.example.ticaretUstasi.entity.concretes.Experience;
import com.example.ticaretUstasi.entity.concretes.Resume;

import java.util.List;

public interface ExperienceService extends BaseEntityService<Experience> {

    DataResult<List<Experience>> getAllByResumeId(int resumeId);

    DataResult<List<Experience>> getAllByResumeIdSortedByTerminationDate(int resumeId);


}
