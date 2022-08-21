package com.example.mvcdemo.controller.dto;

import com.example.mvcdemo.model.Book;
import lombok.Setter;

@Setter
public class BookCreateDto {

    private String name;
    private int pageCount;
    private String authors;

    public Book toBook() {
        return Book.builder()
                .authors(this.authors)
                .pageCount(this.pageCount)
                .name(this.name)
                .build();
    }
}
