package com.example.ticaretUstasi.businnes.abstracts;

import com.example.ticaretUstasi.core.entity.User;
import com.example.ticaretUstasi.core.ultities.results.DataResult;

import java.util.List;

public interface UserService {
    DataResult<List<User>> getAll();

    DataResult<User> getById(int id);

    DataResult<User> getByEmail(String email);
}
