package com.example.ticaretUstasi.businnes.response.JobAp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class GetAllByIsActiveResponse {
    private int id;
    private String jobTitle;
    private String jobDescription;
    private int numberOfOpenPositions;
    private String salaryMin;
    private String salaryMax;
    private LocalDateTime postingDate;
    private LocalDate closingDate;
    private boolean isActive;
    private String companyName;
    private String webAddress;
    private String phoneNumber;
    private String jobPositionTitle;
    private String city;
    private String workingTime;
    private String workingType;
}
