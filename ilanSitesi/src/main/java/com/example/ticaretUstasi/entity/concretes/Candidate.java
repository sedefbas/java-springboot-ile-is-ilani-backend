package com.example.ticaretUstasi.entity.concretes;

import com.example.ticaretUstasi.core.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import java.time.LocalDate;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="candidates")
@EqualsAndHashCode(callSuper = true)
@PrimaryKeyJoinColumn(name = "user_id", referencedColumnName = "id")
public class Candidate extends User {
    @Column(name="first_name")
    private String firstName;
    @Column(name="lastName")
    private String lastName;
    @Column(name = "identity_number",unique = true)
    private  String  identityNumber;
    @Column(name = "date_of_birth")
    private LocalDate dateOfBirth;
    @Column(name = "image_url")
    private String image;

    public int getUserId() {
        return getId();
    }


}
