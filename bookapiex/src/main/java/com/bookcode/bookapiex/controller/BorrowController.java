package com.bookcode.bookapiex.controller;

import com.bookcode.bookapiex.model.Book;
import com.bookcode.bookapiex.model.Borrow;
import com.bookcode.bookapiex.repository.BookRepository;
import com.bookcode.bookapiex.repository.BorrowRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class BorrowController {
    @Autowired
    BookRepository bookRepository;
    @Autowired
    private BorrowRepository borrowRepository;
    @ResponseBody
    @RequestMapping("getborrow")
    public List<Borrow> getBorrows(){
     return    borrowRepository.findAll();
    }
    @ResponseBody
    @RequestMapping("/delete")
    public String deleteById(@RequestParam("bookid") Long bookId){
        /*Book book = bookRepository.findByid(bookId);
        Borrow borrow = book.getBorrowList().get(0);
        System.out.println("借阅id"+borrow.getId());*/
        borrowRepository.deleteById(bookId);
         return "YES";
    }

}
