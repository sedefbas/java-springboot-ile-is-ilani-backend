package com.example.ticaretUstasi.businnes.abstracts;

import com.example.ticaretUstasi.core.ultities.results.DataResult;
import com.example.ticaretUstasi.core.ultities.results.Result;

import java.util.List;

public interface BaseEntityService<T> {
    Result add(T entity);

    Result update(T entity);

    Result delete(int id);

    DataResult<List<T>> getAll();

    DataResult<T> getById(int id);

}
