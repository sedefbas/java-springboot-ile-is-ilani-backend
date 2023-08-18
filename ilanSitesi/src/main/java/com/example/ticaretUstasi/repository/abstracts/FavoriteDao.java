package com.example.ticaretUstasi.repository.abstracts;
import com.example.ticaretUstasi.entity.concretes.FavoriteJobAd;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface FavoriteDao extends JpaRepository<FavoriteJobAd,Integer> {
    List<FavoriteJobAd> getByCandidate_Id(int id);

    List<FavoriteJobAd> findByCandidate_IdAndJobAdId(int candidateId, int jobAdId);


}



