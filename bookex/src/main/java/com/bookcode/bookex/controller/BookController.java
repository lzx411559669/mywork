package com.bookcode.bookex.controller;
import com.bookcode.bookex.model.Book;
import com.bookcode.bookex.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Controller
public class BookController {

@Autowired
private BookService bookService;
    @RequestMapping("/list.html")
    public String findAll(Model model){
        Flux<Book> bookFlux = bookService.findAll();
        model.addAttribute("books", bookFlux);
        return "/list";
    }
    @PostMapping("/save")
    public String saveBook(Book book) {
        bookService.save(book);
        return "redirect:/book/list.html";
    }
    @ResponseBody
    @GetMapping("/del")
    public String delBook(@RequestParam("id") long bookId) {
      bookService.delete(bookId);
        return "true";
    }
    //根据图书名称搜索图书
    @RequestMapping("/search")
    public String search(@RequestParam( value = "bookName") String bookName, Model model) {
        Mono<Book> book = bookService.findByName(bookName);
        model.addAttribute("results", book);
        return "/result";
    }
}
