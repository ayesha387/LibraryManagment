package com.example.LMS.model;

import java.util.List;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class ShelfDto {
    private Long id;
    private String name;
    private List<Long> bookShelfIds;
}
