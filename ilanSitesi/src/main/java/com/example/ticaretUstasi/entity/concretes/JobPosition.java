package com.example.ticaretUstasi.entity.concretes;
import lombok.*;

import javax.persistence.*;


@Table(name = "jobPosition")
@Data
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class JobPosition {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "job_title",unique = true)
    private String jobTitle;
}
