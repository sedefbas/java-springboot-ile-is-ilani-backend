package com.example.ticaretUstasi.businnes.concretes;

import com.example.ticaretUstasi.businnes.abstracts.FavoriteService;
import com.example.ticaretUstasi.businnes.request.favorite.FavoriteAddRequest;
import com.example.ticaretUstasi.core.ultities.results.DataResult;
import com.example.ticaretUstasi.core.ultities.results.Result;
import com.example.ticaretUstasi.core.ultities.results.SuccessDataResult;
import com.example.ticaretUstasi.core.ultities.results.SuccessResult;
import com.example.ticaretUstasi.entity.concretes.Candidate;
import com.example.ticaretUstasi.entity.concretes.FavoriteJobAd;
import com.example.ticaretUstasi.entity.concretes.JobAd;
import com.example.ticaretUstasi.repository.abstracts.FavoriteDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FavoriteManager implements FavoriteService {
    private FavoriteDao favoriteDao;

    @Autowired
    public FavoriteManager(FavoriteDao favoriteDao) {
        this.favoriteDao = favoriteDao;
    }

    @Override
    public Result add(FavoriteAddRequest favoriteAddRequest) {
      FavoriteJobAd favoriteJobAd = new FavoriteJobAd();
      favoriteJobAd.setCandidate(new Candidate());
      favoriteJobAd.setJobAd(new JobAd());
      favoriteJobAd.setDateOfAddToFavorites(favoriteAddRequest.getDateOfAddToFavorites());
      favoriteJobAd.getCandidate().setId(favoriteAddRequest.getCandidateId());
      favoriteJobAd.getJobAd().setId(favoriteAddRequest.getJobAdId());
        this.favoriteDao.save(favoriteJobAd);
        return  new SuccessResult(favoriteJobAd,"favorilere başarıyla eklendi."); }

    @Override
    public DataResult<List<FavoriteJobAd>> getbyCandicateId(int id) {
        return  new SuccessDataResult<List<FavoriteJobAd>>(this.favoriteDao.getByCandidate_Id(id),"candicate_id degerine göre favoriler listelendi.");
    }

    @Override
    public Result getByCandidateIdAndJobPostingId(int candidateId, int jobAdId) {
        return new SuccessResult(this.favoriteDao.findByCandidate_IdAndJobAdId(candidateId,jobAdId),"başarıyla favori iş ilanı getirildi");
    }

}

