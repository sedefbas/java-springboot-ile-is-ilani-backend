package com.example.ticaretUstasi.businnes.concretes;

import com.example.ticaretUstasi.businnes.abstracts.LinkService;
import com.example.ticaretUstasi.businnes.request.link.LinkAdd;
import com.example.ticaretUstasi.core.ultities.results.DataResult;
import com.example.ticaretUstasi.core.ultities.results.Result;
import com.example.ticaretUstasi.core.ultities.results.SuccessDataResult;
import com.example.ticaretUstasi.core.ultities.results.SuccessResult;
import com.example.ticaretUstasi.entity.concretes.*;
import com.example.ticaretUstasi.repository.abstracts.LinkDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LinkManager implements LinkService {
    private LinkDao linkDao;

    @Autowired
    public LinkManager(LinkDao linkDao) {
        this.linkDao = linkDao;
    }

    @Override
    public Result add(LinkAdd linkAdd) {
        Link link = new Link();
        link.setLinkName(linkAdd.getLinkName());
        link.setUrl(linkAdd.getUrl());
        linkDao.save(link);
        return new SuccessResult("Link eklendi.");
    }

    @Override
    public Result update(LinkAdd linkAdd) {
        Link link = new Link();
        link.setId(linkAdd.getId());
        link.setLinkName(linkAdd.getLinkName());
        link.setUrl(linkAdd.getUrl());
        linkDao.save(link);
        return new SuccessResult("Link eklendi.");
    }

    @Override
    public Result delete(int id) {

        linkDao.deleteById(id);
        return new SuccessResult("Link silindi.");
    }

    @Override
    public DataResult<List<LinkAdd>> getAll() {
        return new SuccessDataResult<List<Link>>(this.linkDao.findAll(),"linkler getirildi");
    }

    @Override
    public DataResult<LinkAdd> getById(int id) {
        return new SuccessDataResult<Optional<Link>>(linkDao.findById(id),"");
    }
}
