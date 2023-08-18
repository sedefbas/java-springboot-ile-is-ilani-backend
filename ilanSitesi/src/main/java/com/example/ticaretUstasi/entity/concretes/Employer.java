package com.example.ticaretUstasi.entity.concretes;
import com.example.ticaretUstasi.core.entity.User;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "employers")
@PrimaryKeyJoinColumn(name = "user_id", referencedColumnName = "id")
public class Employer extends User {
    @NotNull
    @Column(name = "company_name")
    private String companyName;
    @NotNull
    @Column(name = "web_address")
    private String webAddress;
    @NotNull
    @Column(name = "phone_number")
    private String phoneNumber;
    @Column(name = "image_url")
    private String image;
}
