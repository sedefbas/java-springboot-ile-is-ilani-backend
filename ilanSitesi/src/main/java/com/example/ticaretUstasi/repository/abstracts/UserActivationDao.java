package com.example.ticaretUstasi.repository.abstracts;

import com.example.ticaretUstasi.entity.concretes.UserActivation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserActivationDao extends JpaRepository<UserActivation,Integer> {
    List<UserActivation> getByIsActivated(boolean isActivated);

    UserActivation getByCode(String code);

    UserActivation getByUser_Id(int userId);
}
