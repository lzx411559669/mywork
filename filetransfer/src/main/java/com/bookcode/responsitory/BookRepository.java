package com.bookcode.responsitory;
import com.bookcode.model.Book;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import javax.annotation.PostConstruct;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
@Repository
public class BookRepository {
    //list集合用于存放图书类
    private static List<Book> bookList = new ArrayList<>();
    private static List<Book> bookList1 = new ArrayList<>();

    //初始化数据
    @PostConstruct
    public void init() {
        Book book = new Book("1", "Spring 入门", "programming", LocalDateTime.now(),23.0);
        bookList.add(book);
        book = new Book("2", "JAVA 入门", "programming", LocalDateTime.now().plusYears(1),22.0);
        bookList.add(book);
        book = new Book("3", "Vue 入门", "programming", LocalDateTime.now().plusYears(2),21.0);
        bookList.add(book);
        book = new Book("4", "平凡的世界", "literature", LocalDateTime.now().plusYears(3),16.0);
        bookList.add(book);
        book = new Book("5", "活着", "literature", LocalDateTime.now().plusDays(10),15.0);
        bookList.add(book);
        book = new Book("6", "霸道总裁", "novel", LocalDateTime.now().plusDays(20),15.0);
        bookList.add(book);
        bookList.add(book);
        book = new Book("7", "语文", "textbook", LocalDateTime.now().plusDays(10),15.0);
        bookList1.add(book);
        book = new Book("8", "数学", "textbook", LocalDateTime.now().plusDays(20),15.0);
        bookList1.add(book);

    }


    //根据Id获取单个图书信息
    public Mono<Book> getBookById(String id) {
        return Mono.justOrEmpty(bookList.stream().filter(book -> {
            return book.getId().equals(id);
        }).findFirst().orElse(null));
    }
    //获取图书列表
    public Flux<Book> getBooks() {
        Flux<Book> flux1 = Flux.fromIterable(bookList);
        Flux<Book> flux2 = Flux.fromIterable(bookList1);
        return Flux.merge(flux1,flux2);
    }
    //添加图书
    public void add(Book book){
        bookList.add(book);
    }
    //修改图书
    public void update(String id,Book book){
      for (Book each:bookList){
          if (each.getId().equals(id)){
              bookList.remove(each);
              bookList.add(book);
          }
      }
    }
    //删除图书
    public void delete(String id){
       for(Book book:bookList){
           if (book.getId().equals(id)){
               bookList.remove(book);
           }
       }
    }
}
