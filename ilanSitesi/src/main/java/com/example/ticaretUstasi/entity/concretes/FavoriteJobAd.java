package com.example.ticaretUstasi.entity.concretes;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;



@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
@Table(name = "favorite_job_ad")
public class FavoriteJobAd {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "date_of_add_to_favorites")
    private LocalDateTime dateOfAddToFavorites;

    @ManyToOne()
    @JoinColumn(name = "job_posting_id")
    private JobAd jobAd;

    @ManyToOne()
    @JoinColumn(name = "candidate_id")
    private Candidate candidate;
}
