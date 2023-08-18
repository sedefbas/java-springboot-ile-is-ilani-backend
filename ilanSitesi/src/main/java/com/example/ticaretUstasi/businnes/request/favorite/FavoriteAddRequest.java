package com.example.ticaretUstasi.businnes.request.favorite;
import com.example.ticaretUstasi.entity.concretes.Candidate;
import com.example.ticaretUstasi.entity.concretes.JobAd;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class FavoriteAddRequest {

    private LocalDateTime dateOfAddToFavorites;
    private int jobAdId;
    private int candidateId;
}
