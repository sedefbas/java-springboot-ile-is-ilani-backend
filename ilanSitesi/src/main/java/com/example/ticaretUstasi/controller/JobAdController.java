package com.example.ticaretUstasi.controller;
import com.example.ticaretUstasi.businnes.abstracts.JobAdService;
import com.example.ticaretUstasi.businnes.request.JobAd.JobAdRequest;
import com.example.ticaretUstasi.businnes.response.JobAp.GetAllActiveOrderByPostingDateDescResponse;
import com.example.ticaretUstasi.businnes.response.JobAp.GetAllByEmployerIdAndIsActiveResponse;
import com.example.ticaretUstasi.businnes.response.JobAp.GetAllByIsActiveResponse;
import com.example.ticaretUstasi.businnes.response.JobAp.GetAllJobAdResponse;
import com.example.ticaretUstasi.core.ultities.results.DataResult;
import com.example.ticaretUstasi.core.ultities.results.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/jobAd")
@CrossOrigin
public class JobAdController {
    private JobAdService jobAdService;
   @Autowired
    public JobAdController(JobAdService jobAdService) {
        this.jobAdService = jobAdService;
    }

    @GetMapping("/getAllByIsActive")
  public  DataResult<List<GetAllByIsActiveResponse>> getAllByIsActive(boolean active) {
        return this.jobAdService.getAllByIsActive(active);
    }
    @GetMapping("/getAllByEmployerIdAndIsActive")
   public DataResult<List<GetAllByEmployerIdAndIsActiveResponse>> getAllByEmployerIdAndIsActive(int employerId, boolean active) {
        return this.jobAdService.getAllByEmployerIdAndIsActive(employerId,active);
    }

    @GetMapping("/getAllActiveOrderByPostingDateDesc")
    public DataResult<List<GetAllActiveOrderByPostingDateDescResponse>> getAllActiveOrderByPostingDateDesc(boolean active) {
        return this.jobAdService.getAllActiveOrderByPostingDateDesc(active);
    }
    @PutMapping("/changeActive")
   public Result changeActive(int id, boolean active){
       return this.jobAdService.changeActive(id,active);
   }

   @PostMapping("/add")
   public Result add(@RequestBody JobAdRequest jobAdRequest){
       return this.jobAdService.add(jobAdRequest);
   }
  @GetMapping("getAll")
    public DataResult<List<GetAllJobAdResponse>> getAll() {
        return jobAdService.getAll();
    }
}
