package com.bookcode.bookapiex.controller;

import com.bookcode.bookapiex.model.Book;
import com.bookcode.bookapiex.repository.BookRepository;
import com.bookcode.bookapiex.service.BookServive;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import java.util.List;
import java.util.stream.Collectors;

@Controller
public class BookController {
    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private BookServive bookServive;
    @ResponseBody
    @RequestMapping("/booklist")
    public List<Book> getBookList(){
        return bookServive.findAll();
    }

    @RequestMapping("/canborrow")
    public String getCanBorrowBooks(Model model){
        model.addAttribute("borrowbooks",bookServive.canBorrow());
        return "book/borrowbook";
    }

    @RequestMapping("/newbooks")
    public String newBooks(@RequestParam("days") int days,Model model){
        model.addAttribute("newbooks" ,bookServive.getNewBook(days));
        return "book/newbooks";
    }
    @RequestMapping("/addbook")
    public String save(Book book,@RequestParam("stockid") long stockId){
        bookServive.Save(book,stockId);
        return "redirect:/getbooks";
    }
    @ResponseBody
    @RequestMapping("/saveAll")
    public String saveAll(@RequestBody List<Book> bookList,@RequestParam("stockid")long stockId){
        bookServive.SaveAll(bookList,stockId);
        return "Save success";
    }
    @RequestMapping("/getbyname")
    public String getByNameLike(@RequestParam("bookname")String bookName,Model model){
        model.addAttribute("result",bookServive.findByBookName(bookName));
        return "book/result";
    }
    @RequestMapping("/getbytype")
    public String getByType(@RequestParam("type") String type,Model model){
       List<Book> books = bookServive.canBorrow().stream().filter(book -> book.getType().equals(type)).collect(Collectors.toList());
        model.addAttribute("borrowbooks",bookRepository.findByType(type));
        return "book/borrowbook";
    }
    @RequestMapping("/getbooks")
   public String page(@RequestParam(value = "page",defaultValue = "0")int pageNumber,Model model){
        pageNumber = pageNumber < 0 ? 0:pageNumber;
        PageRequest pageRequest = PageRequest.of(pageNumber,8);
        model.addAttribute("pages",bookServive.bookPage(pageRequest));
        return "book/list";
    }
}
