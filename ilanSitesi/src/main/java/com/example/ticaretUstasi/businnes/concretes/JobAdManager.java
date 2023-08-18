package com.example.ticaretUstasi.businnes.concretes;

import com.example.ticaretUstasi.businnes.response.JobAp.GetAllByEmployerIdAndIsActiveResponse;
import com.example.ticaretUstasi.businnes.response.JobAp.GetAllJobAdResponse;
import com.example.ticaretUstasi.businnes.abstracts.JobAdService;
import com.example.ticaretUstasi.businnes.request.JobAd.JobAdRequest;
import com.example.ticaretUstasi.businnes.response.JobAp.GetAllActiveOrderByPostingDateDescResponse;
import com.example.ticaretUstasi.businnes.response.JobAp.GetAllByIsActiveResponse;
import com.example.ticaretUstasi.core.ultities.results.DataResult;
import com.example.ticaretUstasi.core.ultities.results.Result;
import com.example.ticaretUstasi.core.ultities.results.SuccessDataResult;
import com.example.ticaretUstasi.core.ultities.results.SuccessResult;
import com.example.ticaretUstasi.entity.concretes.*;
import com.example.ticaretUstasi.repository.abstracts.JobAdDao;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class JobAdManager implements JobAdService {
   private JobAdDao jobAdDao;

    public JobAdManager(JobAdDao jobAdDao) {
        this.jobAdDao = jobAdDao;
    }

    @Override
    public DataResult<List<GetAllJobAdResponse>> getAll() {
        List<JobAd> jobAdList = jobAdDao.findAll();
        List<GetAllJobAdResponse> jobAdResponse = new ArrayList<GetAllJobAdResponse>();
        for(JobAd item : jobAdList){
            GetAllJobAdResponse responseItem = new GetAllJobAdResponse();
            responseItem.setId(item.getId());
            responseItem.setJobPositionTitle(item.getJobTitle());
            responseItem.setJobDescription(item.getJobDescription());
            responseItem.setNumberOfOpenPositions(item.getNumberOfOpenPositions());
            responseItem.setSalaryMin(item.getSalaryMin());
            responseItem.setSalaryMax(item.getSalaryMax());
            responseItem.setPostingDate(item.getPostingDate());
            responseItem.setClosingDate(item.getClosingDate());
            responseItem.setActive(item.isActive());
            responseItem.setCompanyName(item.getEmployer().getCompanyName());
            responseItem.setWebAddress(item.getEmployer().getWebAddress());
            responseItem.setPhoneNumber(item.getEmployer().getPhoneNumber());
            responseItem.setJobPositionTitle(item.getJobPosition().getJobTitle());
            responseItem.setCity(item.getCity().getCityName());
            responseItem.setWorkingTime(item.getWorkingTime().getWorkTimeName());
            responseItem.setWorkingType((item.getWorkingType().getWorktypeName()));
            jobAdResponse.add(responseItem);
        }

        return new SuccessDataResult<List<GetAllJobAdResponse>>(jobAdResponse,"iş ilanları listelendi");
    }

    @Override
    public DataResult<List<GetAllByIsActiveResponse>> getAllByIsActive(boolean active) {
        List<JobAd> jobAdList = jobAdDao.findByIsActive(active);
        List<GetAllByIsActiveResponse> jobAdResponse = new ArrayList<GetAllByIsActiveResponse>();
        for(JobAd item : jobAdList){
            GetAllByIsActiveResponse responseItem = new GetAllByIsActiveResponse();
            responseItem.setId(item.getId());
            responseItem.setJobTitle(item.getJobTitle());
            responseItem.setJobDescription(item.getJobDescription());
            responseItem.setNumberOfOpenPositions(item.getNumberOfOpenPositions());
            responseItem.setSalaryMin(item.getSalaryMin());
            responseItem.setSalaryMax(item.getSalaryMax());
            responseItem.setPostingDate(item.getPostingDate());
            responseItem.setClosingDate(item.getClosingDate());
            responseItem.setActive(item.isActive());
            responseItem.setCompanyName(item.getEmployer().getCompanyName());
            responseItem.setWebAddress(item.getEmployer().getWebAddress());
            responseItem.setPhoneNumber(item.getEmployer().getPhoneNumber());
            responseItem.setJobPositionTitle(item.getJobPosition().getJobTitle());
            responseItem.setCity(item.getCity().getCityName());
            responseItem.setWorkingTime(item.getWorkingTime().getWorkTimeName());
            responseItem.setWorkingType((item.getWorkingType().getWorktypeName()));
            jobAdResponse.add(responseItem);
        }

        return new SuccessDataResult<List<GetAllByIsActiveResponse>>(jobAdResponse,"bütün iş ilanları aktifliklerine göre listelendi");

    }

    @Override
    public DataResult<List<GetAllActiveOrderByPostingDateDescResponse>> getAllActiveOrderByPostingDateDesc(boolean active) {
        List<JobAd> jobAdList = jobAdDao.findByIsActiveOrderByPostingDateDesc(active);
        List<GetAllActiveOrderByPostingDateDescResponse> jobAdResponse = new ArrayList<GetAllActiveOrderByPostingDateDescResponse>();
        for(JobAd item : jobAdList){
            GetAllActiveOrderByPostingDateDescResponse responseItem = new GetAllActiveOrderByPostingDateDescResponse();
            responseItem.setId(item.getId());
            responseItem.setJobTitle(item.getJobTitle());
            responseItem.setJobDescription(item.getJobDescription());
            responseItem.setNumberOfOpenPositions(item.getNumberOfOpenPositions());
            responseItem.setSalaryMin(item.getSalaryMin());
            responseItem.setSalaryMax(item.getSalaryMax());
            responseItem.setPostingDate(item.getPostingDate());
            responseItem.setClosingDate(item.getClosingDate());
            responseItem.setActive(item.isActive());
            responseItem.setCompanyName(item.getEmployer().getCompanyName());
            responseItem.setWebAddress(item.getEmployer().getWebAddress());
            responseItem.setPhoneNumber(item.getEmployer().getPhoneNumber());
            responseItem.setJobPositionTitle(item.getJobPosition().getJobTitle());
            responseItem.setCity(item.getCity().getCityName());
            responseItem.setWorkingTime(item.getWorkingTime().getWorkTimeName());
            responseItem.setWorkingType((item.getWorkingType().getWorktypeName()));
            jobAdResponse.add(responseItem);
        }

        return new SuccessDataResult<List<GetAllActiveOrderByPostingDateDescResponse>>(jobAdResponse,"bütün aktif iş ilanları tarihe göre listelendi");
    }

    @Override
    public DataResult<List<GetAllByEmployerIdAndIsActiveResponse>> getAllByEmployerIdAndIsActive(int employerId, boolean active) {
        List<JobAd> jobAdList = jobAdDao.findAllByEmployerIdAndIsActive(employerId,active);
        List<GetAllByEmployerIdAndIsActiveResponse> jobAdResponse = new ArrayList<GetAllByEmployerIdAndIsActiveResponse>();
        for(JobAd item : jobAdList){
            GetAllByEmployerIdAndIsActiveResponse responseItem = new GetAllByEmployerIdAndIsActiveResponse();
            responseItem.setId(item.getId());
            responseItem.setJobTitle(item.getJobTitle());
            responseItem.setJobDescription(item.getJobDescription());
            responseItem.setNumberOfOpenPositions(item.getNumberOfOpenPositions());
            responseItem.setSalaryMin(item.getSalaryMin());
            responseItem.setSalaryMax(item.getSalaryMax());
            responseItem.setPostingDate(item.getPostingDate());
            responseItem.setClosingDate(item.getClosingDate());
            responseItem.setActive(item.isActive());
            responseItem.setCompanyName(item.getEmployer().getCompanyName());
            responseItem.setWebAddress(item.getEmployer().getWebAddress());
            responseItem.setPhoneNumber(item.getEmployer().getPhoneNumber());
            responseItem.setJobPositionTitle(item.getJobPosition().getJobTitle());
            responseItem.setCity(item.getCity().getCityName());
            responseItem.setWorkingTime(item.getWorkingTime().getWorkTimeName());
            responseItem.setWorkingType((item.getWorkingType().getWorktypeName()));
            jobAdResponse.add(responseItem);
        }

        return new SuccessDataResult<List<GetAllByEmployerIdAndIsActiveResponse>>(jobAdResponse,"iş ilanları listelendi");

    }

    @Override
    public Result changeActive(int id, boolean newActive) {
        String message =newActive ? "ilan aktifleştirildi":"ilan pasifleştirildi";
        JobAd jobAd = jobAdDao.findById(id)
          .orElseThrow(() -> new IllegalArgumentException("Invalid job ad ID: " + id));

        jobAd.setActive(newActive);
        jobAdDao.save(jobAd);
        return new SuccessResult(message);
    }

    @Override
    public Result add(JobAdRequest jobAdRequest) {
        JobAd jobAd = new JobAd();
        jobAd.setEmployer(new Employer());
        jobAd.setJobPosition(new JobPosition());
        jobAd.setCity(new City());
        jobAd.setWorkingTime(new WorkTime());
        jobAd.setWorkingType(new WorkType());
        jobAd.setJobTitle(jobAdRequest.getJobTitle());
        jobAd.setJobDescription(jobAdRequest.getJobDescription());
        jobAd.setNumberOfOpenPositions(jobAdRequest.getNumberOfOpenPositions());
        jobAd.setSalaryMin(jobAdRequest.getSalaryMin());
        jobAd.setSalaryMax(jobAdRequest.getSalaryMax());
        jobAd.setPostingDate(jobAdRequest.getPostingDate());
        jobAd.setClosingDate(jobAdRequest.getClosingDate());
        jobAd.setActive(jobAdRequest.isActive());
        jobAd.getEmployer().setId(jobAdRequest.getEmployerId());
        jobAd.getJobPosition().setId(jobAdRequest.getJobPositionId());
        jobAd.getCity().setId(jobAdRequest.getCityId());
        jobAd.getWorkingTime().setId(jobAdRequest.getWorkingTimeId());
        jobAd.getWorkingType().setId(jobAdRequest.getWorkingTypeId());
        this.jobAdDao.save(jobAd);
        return  new SuccessResult(jobAd,"iş ilanı başarıyla eklendi."); }
}
