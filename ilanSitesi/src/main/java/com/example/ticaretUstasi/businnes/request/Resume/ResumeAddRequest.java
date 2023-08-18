package com.example.ticaretUstasi.businnes.request.Resume;
import com.example.ticaretUstasi.entity.concretes.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ResumeAddRequest {
    private Integer id;

    private LocalDateTime creationDate;

    private int candidateId;

    private Integer coverLetterId;

    private List<Education> educations;

    private List<Experience> experiences;

    private List<LanguageLevel> languageLevels;

    private List<Link> links;

    private List<SkillFeature> skillFeatures;

}
