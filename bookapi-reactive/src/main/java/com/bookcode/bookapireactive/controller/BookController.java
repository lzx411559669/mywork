package com.bookcode.bookapireactive.controller;

import com.bookcode.bookapireactive.service.BookService;
import com.bookcode.bookapireactive.model.Book;
import com.bookcode.bookapireactive.model.Borrow;
import com.bookcode.bookapireactive.repository.BookRepository;
import com.bookcode.bookapireactive.repository.BorrowRepository;
import com.bookcode.bookapireactive.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.codec.multipart.FilePart;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import java.io.File;
import java.io.IOException;


@Controller
public class BookController {
    @Autowired
    private BookService bookService;
    @Autowired
    private BorrowRepository borrowRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private BookRepository bookRepository;

    @RequestMapping(value = "/booklist")
    public String findAll(@RequestParam(value = "page", defaultValue = "1") int page, Model model) {
        model.addAttribute("booklist", bookService.page(bookRepository.findAll(), page, 9));
        model.addAttribute("page", page);
        return "book/booklist";
    }

    @RequestMapping("/bookmanagement")
    public String bookmanagement(@RequestParam(value = "page", defaultValue = "1") int page, Model model) {
        model.addAttribute("booklist", bookService.page(bookRepository.findAll(), page, 9));
        model.addAttribute("page", page);
        return "book/bookmanagement";
    }

    @ResponseBody
    @RequestMapping("/one")
    public Mono<Book> findById(@RequestParam("id") long id) {
        return bookService.findById(id);
    }

    @ResponseBody
    @RequestMapping("borrowall")
    public Flux<Borrow> BorrowfindAll() {
        return borrowRepository.findAll();
    }

    @ResponseBody
    @RequestMapping("/bookid")
    public Flux<Long> bookId() {
        return borrowRepository.getBookId(1L);
    }

    @RequestMapping("/borrowbook")
    public String bookFlux(@RequestParam(value = "page", defaultValue = "1") int page, Model model) {
        model.addAttribute("booklist", bookService.page(bookRepository.findAllById(borrowRepository.getBookId(2L)), page, 9));
        model.addAttribute("page", page);
        return "book/booklist";
    }

    @RequestMapping("/search")
    public String searchByTitle(@RequestParam("title") String title, @RequestParam("role") String role, Model model) {
        model.addAttribute("booklist", bookService.searchByTitle(title));
        //model.addAttribute("title",title);
        if (role.equals("management")) {
            return "book/bookmanagement";
        } else {
            return "book/booklist";
        }
    }

    @RequestMapping("/hotbooks")
    public String hotBooks(@RequestParam(value = "page", defaultValue = "1") int page, Model model) {
        model.addAttribute("booklist", bookService.page(bookService.getHotBooks(), page, 9));
        model.addAttribute("page", page);
        return "book/booklist";
    }

    @RequestMapping("/type")
    public String getByCatalog(@RequestParam("catalog") String catalog, @RequestParam(value = "page", defaultValue = "1") int page, Model model) {
        model.addAttribute("booklist", bookService.page(bookService.searchByCatalog(catalog), page, 9));
        model.addAttribute("page", page);
        model.addAttribute("catalog", catalog);
        return "book/booklist";
    }

    @RequestMapping("/json")
    public String formJson(String jsontext) {
        if (jsontext == null) {
            return "book/addbook";
        }
        bookService.saveAllFromJson(jsontext);
        return "book/addbook";
    }

    @PostMapping(value = "/upload", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public String requestBodyFlux(@RequestPart("file") FilePart filePart) throws IOException {
        File file = new File(filePart.filename());
        filePart.transferTo(file);
        System.out.println(file.toString());
        System.out.println("文件：" + filePart.filename() + " 上传成功");
        String content = bookService.getContentFromFile("file:D:/mywork/bookapi-reactive/" + file.toString());
        bookService.saveAllFromJson(content);
        return "book/addbook";
    }
     @PostMapping("/addBook")
     public String addBook(Book book){
         System.out.println(book.getId());
        System.out.println(book.getTitle());
        bookService.add(book);
     return "book/addbook";
     }

    @RequestMapping("delete")
    public String delete(@RequestParam("bookid") long bookId) {
        bookRepository.deleteById(bookId);
        return "true";
    }

    @PostMapping(value = "/modifybook")
    public String modify(Book book) {
        bookService.update(book);
        return "redirect:/bookmanagement";
    }
 /*   @ResponseBody
    @RequestMapping("/catalog")
    public Flux<String> catalogs(){
        return bookService.getCatalogs();
    }*/
    @ResponseBody
    @GetMapping("/getcount")
    public Mono<Long> getCount (){
       return bookService.getCount();
    }
}
