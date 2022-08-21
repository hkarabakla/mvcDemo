package com.example.mvcdemo.repository;

import com.example.mvcdemo.model.Book;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface BookRepository extends PagingAndSortingRepository<Book, Long> {
}
