package com.example.ticaretUstasi.businnes.abstracts;

import com.example.ticaretUstasi.businnes.request.favorite.FavoriteAddRequest;
import com.example.ticaretUstasi.core.ultities.results.DataResult;
import com.example.ticaretUstasi.core.ultities.results.Result;
import com.example.ticaretUstasi.entity.concretes.FavoriteJobAd;

import java.util.List;

public interface FavoriteService {
    Result add(FavoriteAddRequest favoriteAddRequest);
    DataResult<List<FavoriteJobAd>> getbyCandicateId(int id);

    Result getByCandidateIdAndJobPostingId(int candidateId, int jobAdId);

}
