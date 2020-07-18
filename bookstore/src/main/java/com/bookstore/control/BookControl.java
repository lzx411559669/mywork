package com.bookstore.control;

import com.bookstore.model.Book;
import com.bookstore.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.Valid;
import java.util.List;

@Controller
public class BookControl {
    @Autowired
    private BookService bookService;

    @GetMapping("/book/add.html")
    public String addBookHtml(Model model) {
        Book book = new Book();
        model.addAttribute("book",book);
        return "book/addBook";
    }

    @PostMapping("/book/save")
    public String saveBook(@Valid Book book , BindingResult errors) {
       List<Book> books = bookService.getBooks();
        if ( books.contains(book)){
            return "book/saveBookError";
        }else if (errors.hasErrors()){
            return "book/addBook";
        }
       bookService.saveBook(book);
        return "redirect:/book/list.html";
    }
    @GetMapping("/book/list.html")
    public String list(Model model) {
        model.addAttribute("books", bookService.getBooks());
        return "book/list";
    }
    @ResponseBody
    @GetMapping("/book/del")
    public String delBook(@RequestParam("id") long  bookId) {
        bookService.delBook(bookId);
        return "true";
    }
}
