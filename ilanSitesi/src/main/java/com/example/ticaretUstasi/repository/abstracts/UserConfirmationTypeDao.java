package com.example.ticaretUstasi.repository.abstracts;

import com.example.ticaretUstasi.entity.concretes.UserConfirmationType;
import com.example.ticaretUstasi.entity.concretes.WorkTime;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserConfirmationTypeDao extends JpaRepository<UserConfirmationType,Integer> {
}
