package com.example.ticaretUstasi.controller;

import com.example.ticaretUstasi.businnes.abstracts.CompanyStaffService;
import com.example.ticaretUstasi.core.ultities.results.DataResult;
import com.example.ticaretUstasi.core.ultities.results.Result;
import com.example.ticaretUstasi.entity.concretes.CompanyStaff;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/companyStaffs")
@CrossOrigin
public class CompanyStaffController {

    private CompanyStaffService companyStaffService;

    @Autowired
    public CompanyStaffController(CompanyStaffService companyStaffService) {
        this.companyStaffService = companyStaffService;
    }

    @PutMapping("/update")
    public Result update(@RequestBody CompanyStaff companyStaff) {
        return companyStaffService.update(companyStaff);
    }

    @GetMapping("/getAll")
    public DataResult<List<CompanyStaff>> getAll() {
        return companyStaffService.getAll();
    }

    @GetMapping("/getById")
    public DataResult<CompanyStaff> getById(@RequestParam int id) {
        return companyStaffService.getById(id);
    }

}
