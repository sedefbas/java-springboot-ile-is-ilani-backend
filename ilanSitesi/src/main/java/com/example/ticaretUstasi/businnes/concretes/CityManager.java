package com.example.ticaretUstasi.businnes.concretes;

import com.example.ticaretUstasi.businnes.abstracts.CityService;
import com.example.ticaretUstasi.core.ultities.results.DataResult;
import com.example.ticaretUstasi.core.ultities.results.Result;
import com.example.ticaretUstasi.core.ultities.results.SuccessResult;
import com.example.ticaretUstasi.entity.concretes.City;
import com.example.ticaretUstasi.repository.abstracts.CityDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CityManager implements CityService {

    private CityDao cityDao;

    @Autowired
    public CityManager(CityDao cityDao) {
        this.cityDao = cityDao;
    }

    @Override
    public Result add(City city) {
        return new SuccessResult(this.cityDao.save(city),"şehir eklendi");
    }

    @Override
    public Result update(City city) {
        return new SuccessResult(this.cityDao.save(city),"şehir eklendi");
    }


    @Override
    public Result delete(int id) {
        return new SuccessResult(this.cityDao.findById(id),"şehir silindi");
    }

    @Override
    public DataResult<List<City>> getAll() {
        return null;
    }

    @Override
    public DataResult<City> getById(int id) {
        return null;
    }
}
