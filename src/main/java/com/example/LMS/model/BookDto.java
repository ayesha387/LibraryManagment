package com.example.LMS.model;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class BookDto {
    private Long id;
    private String name;
    private String ISBN;
    private String edition;
    private String author;
    private Long bookShelfId;
    private Long categoryId;

}
