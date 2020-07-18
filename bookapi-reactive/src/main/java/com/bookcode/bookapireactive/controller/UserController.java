package com.bookcode.bookapireactive.controller;

import com.bookcode.bookapireactive.model.Borrow;
import com.bookcode.bookapireactive.repository.BookRepository;
import com.bookcode.bookapireactive.repository.BorrowRepository;
import com.bookcode.bookapireactive.repository.UserRepository;
import com.bookcode.bookapireactive.service.BookService;
import com.bookcode.bookapireactive.service.BorrowService;
import com.bookcode.bookapireactive.service.UserService;
import com.bookcode.bookapireactive.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Controller
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private BookService bookService;
    @Autowired
    private BorrowService borrowService;
    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private BorrowRepository borrowRepository;
    //登录用户
    private  Mono<User> userMono = null;
    public  User user;
    String flag;
    /**
     * 跳转登陆页面
     */
    @RequestMapping(value = "/login.html")
    public String loginHtml() {
        return "/user/login";
    }

    @RequestMapping(value = "user/add.html")
    public String registerHtml() {
        return "/user/add";
    }

    @ResponseBody
    @RequestMapping("/user")
    public Flux<User> userFlux(@RequestParam("page") int page) {
        page = page < 0 ? 1 : page;
        //size = size < 0 ? 5 : size;
        return page(userService.userFlux(), page, 5);
    }

    /**
     * 登录
     *
     * @param userNumber
     * @param password
     * @return
     */
    @GetMapping("/login")
    public String login(@RequestParam("usernumber") String userNumber, @RequestParam("password") String password,@RequestParam(value = "role",defaultValue = "other")String role, Model model) {

        if (userNumber == null || password == null) {
            return "user/login";
        }
       userMono = userService.login(userNumber, password);
       if (userMono==null){
           return "user/login";
       }
        // userMono.filter(user1 -> user1.getRole().equals("普通用户")).hasElement().subscribe(System.out::println);
        userMono.subscribe(user1 -> {
            user = user1;
        });
        if (role.equals("管理员")){
            return "redirect:/bookmanagement";
        }else {
            return "redirect:/booklist";
        }
    }
    /**
     * 注册
     *
     * @param user
     * @return
     */
    @RequestMapping("/register")
    public String register(User user) {
        userService.save(user);
        return "/user/login";
    }

    /**
     * 获取借阅书籍
     *
     * @param page
     * @param model
     * @return
     */
    @RequestMapping("/borrowlist")
    public String myBookList(@RequestParam(value = "page", defaultValue = "1") int page, Model model) {
        model.addAttribute("booklist", bookService.page(bookRepository.findAllById(borrowRepository.getBookId(user.getId())), page, 9));
        //model.addAttribute("borrow",bookRepository.findById())
        model.addAttribute("page", page);
        model.addAttribute("user", user);
        return "book/booklist";
    }

    /**
     * 借书
     *
     * @param bookId
     * @return
     */
    @ResponseBody
    @RequestMapping("/borrow")
    public String borrow(@RequestParam("bookid") long bookId) {
        System.out.println("bookId:" + bookId);
        //获取当前日期
        LocalDate now = LocalDate.now();
        //格式化器
        DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy年MM月dd日");
        Borrow borrow = new Borrow();
        borrow.setBookId(bookId);
        borrow.setUserId(user.getId());
        borrow.setBorrowDate(df.format(now));
        //默认最大借阅期限为30天
        borrow.setReturnDate(df.format(now.plusDays(30)));
        //1表示未还
        borrow.setRemarks("1");
        borrowService.insertBorrowBook(borrow);
        return "true";
    }

    /**
     * 还书
     *
     * @param bookId
     * @return
     */
    @ResponseBody
    @RequestMapping("/return")
    public String returnBook(@RequestParam("bookid") long bookId) {
        System.out.println(bookId);
        borrowService.update(bookId, user.getId());
        return "true";
    }

    /**
     * 个人信息
     *
     * @param model
     * @return
     */
    @GetMapping("/userinfo")
    public String userInfo(@RequestParam("role")String role, Model model) {
        model.addAttribute("userinfo", userService.findById(user.getId()));
        model.addAttribute("role",role);
        return "user/userinfo";
    }

    /**
     * 修改个人信息
     * @param newUser
     * @param model
     * @return
     */
    @RequestMapping("/modify")
    public String modify(@ModelAttribute User newUser,Model model) {
        //不更新以下字段
        newUser.setId(user.getId());
        newUser.setRole(user.getRole());
        newUser.setUserNumber(user.getUserNumber());
        userService.update(newUser);
        model.addAttribute("userinfo",newUser);
        if (user.getRole().equals("管理员")){
            model.addAttribute("role","management");
        }else {
            model.addAttribute("role","usercenter");
        }
        return "user/userinfo";
    }
    @RequestMapping("/modifyall")
    public String modifyAll(@ModelAttribute User newUser,Model model){
       userService.update(newUser);
        return "redirect:/userlist";
    }
    /**
     * 用户列表
     * @param page
     * @param model
     * @return
     */
    @RequestMapping("/userlist")
    public String getUserList(@RequestParam(value = "page",defaultValue = "1")int page, Model model){
        model.addAttribute("users",userService.userFlux());
        return "user/userlist";
    }
    @ResponseBody
    @RequestMapping("/deleteuser")
    public String delete(@RequestParam("userid")long userId){
        userService.delete(userId);
        return "true";
    }
    @RequestMapping("/addbook")
    public String addBook(){
        return "book/addbook";
    }
    /**
     * 分页
     *
     * @param flux
     * @param page
     * @param size
     * @return
     */
    public Flux page(Flux flux, int page, int size) {
        return flux.take(page * size).skip((page - 1) * size);
    }


}
