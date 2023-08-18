package com.example.ticaretUstasi.businnes.request.JobAd;
import com.example.ticaretUstasi.entity.concretes.*;
import lombok.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class JobAdRequest {
    private String jobTitle;
    private String jobDescription;
    private int numberOfOpenPositions;
    private String salaryMin;
    private String salaryMax;
    private LocalDateTime postingDate;
    private LocalDate closingDate;
    private boolean isActive;
    private int employerId;
    private int jobPositionId;
    private int cityId;
    private int workingTimeId;
    private int workingTypeId;
}
