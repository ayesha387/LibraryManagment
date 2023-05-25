package com.example.LMS.model;

import java.time.LocalDate;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class IssueBookDto {
    private Long id;
    private LocalDate issueDate;
    private LocalDate returnDate;
    private Long memberId;
    private Long bookShelfId;
}
