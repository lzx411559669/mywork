package com.lzx.getbookinfo.repository;

import com.lzx.getbookinfo.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book,Long> {
    boolean existsByTitle(String title);
}
