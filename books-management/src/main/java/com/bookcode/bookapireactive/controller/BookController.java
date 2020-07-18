package com.bookcode.bookapireactive.controller;
import com.bookcode.bookapireactive.Service.BookService;
import com.bookcode.bookapireactive.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
@Controller
public class BookController {
/*    @Resource
    private BookRep bookRep;

    @GetMapping("/book/add.html")
    public String addBookHtml(Model model) {
        Book book = new Book();
        model.addAttribute("book", book);
        return "book/addBook";
    }
    //添加图书
    @PostMapping("/book/save")
    public String saveBook(@ModelAttribute Book book) {
        bookRep.findByIsbn(book.getIsbn()).hasElement().subscribe(founded -> {
            if (founded) {
                return;
            } else {
                bookRep.save(book).subscribe();
            }
        });
        return "redirect:/book/list.html";
    }
    //查询所有图书
    @GetMapping("/book/list.html")
    public String list(Model model) {
        Flux<Book> bookFlux = bookRep.findAll();
        model.addAttribute("books", bookFlux);
        return "book/list";
    }
    //根据图书编号搜索图书
    @GetMapping("/book/search")
    public String result(@RequestParam("isbn") String isbn, Model model) {
        Mono<Book> bookMono = bookRep.findByIsbn(isbn);
        model.addAttribute("result", bookMono);
        return "book/result";
    }
    //根据id删除图示
    @ResponseBody
    @GetMapping("/book/del")
    public String delBook(@RequestParam("id") long bookId) {
        System.out.println(bookId);
        bookRep.deleteById(bookId).subscribe();
        return "true";
    }*/

@Autowired
private BookService bookService;
    @RequestMapping("/book/list.html")
    public String findAll(Model model){
        Flux<Book> bookFlux = bookService.findAll();
        model.addAttribute("books", bookFlux);
        return "book/list";
    }
    @PostMapping("/book/save")
    public String saveBook(@ModelAttribute Book book) {
        bookService.save(book);
        return "redirect:/book/list.html";
    }
    @ResponseBody
    @GetMapping("/book/del")
    public String delBook(@RequestParam("id") long bookId) {
        bookService.delete(bookId);
        return "true";
    }
    //根据图书名称搜索图书
    @RequestMapping("/book/search")
    public String search(@RequestParam( value = "bookName") String bookName, Model model) {
        Mono<Book> book = bookService.findByName(bookName);
        model.addAttribute("results", book);
        return "book/result";
    }
}
