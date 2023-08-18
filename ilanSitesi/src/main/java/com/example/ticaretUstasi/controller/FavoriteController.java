package com.example.ticaretUstasi.controller;

import com.example.ticaretUstasi.businnes.abstracts.FavoriteService;
import com.example.ticaretUstasi.businnes.request.favorite.FavoriteAddRequest;
import com.example.ticaretUstasi.core.ultities.results.DataResult;
import com.example.ticaretUstasi.core.ultities.results.Result;
import com.example.ticaretUstasi.entity.concretes.FavoriteJobAd;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/favorite")
@CrossOrigin
public class FavoriteController {
    private FavoriteService favoriteService;
    @Autowired
    public FavoriteController(FavoriteService favoriteService) {
        this.favoriteService = favoriteService;
    }

     @PostMapping("/add")
    public Result add(@RequestBody FavoriteAddRequest favoriteAddRequest){
        return favoriteService.add(favoriteAddRequest);
    }

    @GetMapping("/getDetailFavorite")
    Result getByCandicate_IdAndJobAd_Id(@RequestParam int candicateId,@RequestParam int jobAdId){
        return favoriteService.getByCandidateIdAndJobPostingId(candicateId,jobAdId);
    }

    @GetMapping("/getAll")
    public DataResult<List<FavoriteJobAd>> getbyCandicateId(@RequestParam int id) {
        return favoriteService.getbyCandicateId(id);
    }


}
