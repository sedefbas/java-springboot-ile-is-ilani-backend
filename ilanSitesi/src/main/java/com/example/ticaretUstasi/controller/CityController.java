package com.example.ticaretUstasi.controller;
import com.example.ticaretUstasi.businnes.abstracts.CityService;
import com.example.ticaretUstasi.core.ultities.results.DataResult;
import com.example.ticaretUstasi.core.ultities.results.Result;
import com.example.ticaretUstasi.entity.concretes.City;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/cities")
@CrossOrigin
public class CityController {

    private CityService cityService;

    @Autowired
    public CityController(CityService cityService) {
        this.cityService = cityService;
    }

    @PostMapping("/add")
    public Result add(@RequestBody City city) {
        return cityService.add(city);
    }

    @PutMapping("/update")
    public Result update(@RequestBody City city) {
        return cityService.update(city);
    }

    @GetMapping("/getAll")
    public DataResult<List<City>> getAll() {
        return cityService.getAll();
    }

    @GetMapping("/getById")
    public DataResult<City> getById(@RequestParam int id) {
        return cityService.getById(id);
    }

}
