package com.example.mvcdemo.controller.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class BookDto {

    private long id;
    private String name;
    private int pageCount;
    private String authors;
}
