package com.bookcode.bookapi.controller;
import com.bookcode.bookapi.model.Book;
import com.bookcode.bookapi.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@Controller
public class BookController {
    @Autowired
    private BookService bookService;
/*    @RequestMapping("/book/list.html")
    public String findAll(Model model){
        List<Book> books = bookService.findAll();
        model.addAttribute("books" ,books);
        return "book/list";
    }*/
    @PostMapping("/book/save")
    public String saveBook(@ModelAttribute Book book) {
        bookService.save(book);
        return "redirect:/book/list.html";
    }
    @GetMapping("/book/del")
    public String delBook(@RequestParam("id") long bookId) {
      bookService.delete(bookId);
        return "true";
    }
    //根据图书名称搜索图书
    @ResponseBody
    @RequestMapping("/book/search")
    public List<Book> search(@RequestParam( value = "bookName") String bookName, Model model) {
        List<Book> books = bookService.findByName(bookName);
        model.addAttribute("results", books);
        return books;
    }
    /**
     * 分页
     */
    @GetMapping("/book/list.html")
    public String findByPage(@RequestParam(value = "page",defaultValue = "0") int pageNum,Model model){
        pageNum = pageNum < 0 ? 0:pageNum;
        PageRequest pageRequest = PageRequest.of( pageNum,10);
        Page<Book> bookPage = bookService.page(pageRequest);
        model.addAttribute("pages" ,bookPage);
        return "book/list";
    }
}
