package com.example.LMS.model;

import java.util.List;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class BookShelfDto {
    private Long id;
    private List<Long> bookIds;
    private Long shelfId;
    private Long issueBookId;
}