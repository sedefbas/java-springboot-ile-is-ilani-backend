package com.example.ticaretUstasi.repository.abstracts;

import com.example.ticaretUstasi.entity.concretes.CompanyStaff;
import com.example.ticaretUstasi.entity.concretes.WorkTime;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyStaffDao extends JpaRepository<CompanyStaff,Integer> {
}
