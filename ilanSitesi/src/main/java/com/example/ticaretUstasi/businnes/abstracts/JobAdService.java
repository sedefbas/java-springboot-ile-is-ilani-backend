package com.example.ticaretUstasi.businnes.abstracts;
import com.example.ticaretUstasi.businnes.request.JobAd.JobAdRequest;
import com.example.ticaretUstasi.businnes.response.JobAp.GetAllActiveOrderByPostingDateDescResponse;
import com.example.ticaretUstasi.businnes.response.JobAp.GetAllByEmployerIdAndIsActiveResponse;
import com.example.ticaretUstasi.businnes.response.JobAp.GetAllByIsActiveResponse;
import com.example.ticaretUstasi.businnes.response.JobAp.GetAllJobAdResponse;
import com.example.ticaretUstasi.core.ultities.results.DataResult;
import com.example.ticaretUstasi.core.ultities.results.Result;

import java.util.List;

public interface JobAdService {
    DataResult<List<GetAllJobAdResponse>> getAll();
    DataResult<List<GetAllByIsActiveResponse>> getAllByIsActive(boolean active);
    DataResult<List<GetAllActiveOrderByPostingDateDescResponse>> getAllActiveOrderByPostingDateDesc(boolean active);
    DataResult<List<GetAllByEmployerIdAndIsActiveResponse>>  getAllByEmployerIdAndIsActive(int employerId, boolean active);

    Result changeActive(int id, boolean newActive);
    Result add(JobAdRequest JobAdRequest);
}
