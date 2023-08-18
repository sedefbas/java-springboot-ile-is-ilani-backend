package com.example.ticaretUstasi.businnes.abstracts;
import com.example.ticaretUstasi.core.ultities.results.DataResult;
import com.example.ticaretUstasi.entity.concretes.Education;

import java.util.List;

public interface EducationService extends BaseEntityService<Education>{

    DataResult<List<Education>> getAllByResumeId(int resumeId);

    DataResult<List<Education>> getAllByResumeIdSortedByGraduationDate(int resumeId);
}
