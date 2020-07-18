package com.bookcode.bookapiex.repository;

import com.bookcode.bookapiex.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
    @Override
    List<Book> findAllById(Iterable<Long> iterable);

    Book findByid(Long id);

    List<Book> findByType(String type);

    List<Book> findByPublishDate(String time);

    @Query(nativeQuery = true,value = "select * from  Book b where b.name like concat('%',:name,'%') ")
    List<Book> findByNameLike(@Param("name") String name);
    @Override
    <S extends Book> List<S> saveAll(Iterable<S> iterable);
    List<Book> findByAuthor(String author);
    List<Book> findByPress(String press);
}
