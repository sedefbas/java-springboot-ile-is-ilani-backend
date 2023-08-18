package com.example.ticaretUstasi.repository.abstracts;

import com.example.ticaretUstasi.entity.concretes.WorkTime;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WorkTimeDao extends JpaRepository<WorkTime,Integer> {
}
