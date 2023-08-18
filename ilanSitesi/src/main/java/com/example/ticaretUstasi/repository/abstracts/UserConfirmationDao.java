package com.example.ticaretUstasi.repository.abstracts;

import com.example.ticaretUstasi.entity.concretes.UserConfirmation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserConfirmationDao extends JpaRepository<UserConfirmation,Integer> {
    List<UserConfirmation> getByUser_Id(int userId);

    List<UserConfirmation> getByIsConfirmedAndUserConfirmationType_Id(boolean isConfirmed, int userConfirmationTypeId);
}
