package com.example.ticaretUstasi.controller;

import com.example.ticaretUstasi.businnes.abstracts.LinkService;
import com.example.ticaretUstasi.businnes.request.link.LinkAdd;
import com.example.ticaretUstasi.core.ultities.results.DataResult;
import com.example.ticaretUstasi.core.ultities.results.Result;
import com.example.ticaretUstasi.entity.concretes.Link;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api/links")
@CrossOrigin

public class LinkController {

    private LinkService linkService;

    @Autowired
    public LinkController(LinkService linkService) {
        this.linkService = linkService;
    }

    @PostMapping("/add")
    public Result add(@RequestBody LinkAdd link) {
        return linkService.add(link);
    }

    @PutMapping("/update")
    public Result update(@RequestBody LinkAdd link) {
        return linkService.update(link);
    }

    @DeleteMapping("/delete")
    public Result delete(@RequestParam int id) {
        return linkService.delete(id);
    }

    @GetMapping("/getAll")
    public DataResult<List<LinkAdd>> getAll() {
        return linkService.getAll();
    }

    @GetMapping("/getById")
    public DataResult<LinkAdd> getById(@RequestParam int id) {
        return linkService.getById(id);
    }
}
