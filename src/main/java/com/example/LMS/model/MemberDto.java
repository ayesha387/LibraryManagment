package com.example.LMS.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@Builder
public class MemberDto {
    private Long id;
    private String name;
    private Long phoneNo;
    private String email;
    private String address;
    private LocalDate joinDate;
    private List<Long> issueBookIds;
}
