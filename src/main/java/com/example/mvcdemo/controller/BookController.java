package com.example.mvcdemo.controller;

import com.example.mvcdemo.controller.dto.BookCreateDto;
import com.example.mvcdemo.controller.dto.BookDto;
import com.example.mvcdemo.model.Book;
import com.example.mvcdemo.service.BookService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/")
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @PostMapping("book")
    public BookDto create(@RequestBody BookCreateDto dto) {
        Book book = bookService.saveBook(dto.toBook());
        return BookDto.builder()
                .id(book.getId())
                .authors(book.getAuthors())
                .name(book.getName())
                .pageCount(book.getPageCount())
                .build();
    }

    @GetMapping("books")
    public Page<BookDto> listBooks(Pageable page) {
        return bookService.getPagesOfBooks(page)
                .map(book -> BookDto.builder()
                        .id(book.getId())
                        .authors(book.getAuthors())
                        .name(book.getName())
                        .pageCount(book.getPageCount())
                        .build());
    }
}
