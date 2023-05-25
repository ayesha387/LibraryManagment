package com.example.LMS.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
@Entity
@Table(name = "member")
@Data
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "phone_no")
    private Long phoneNo;
    @Column(name = "email")
    private String email;
    @Column(name = "address")
    private String address;
    @Column(name = "join_Date")
    private LocalDate joinDate;

    @OneToMany(mappedBy = "member")
    private List<IssueBook> issueBookList;
}