package com.bookcode.bookapiex.controller;

import com.bookcode.bookapiex.model.Book;
import com.bookcode.bookapiex.model.Borrow;
import com.bookcode.bookapiex.model.User;
import com.bookcode.bookapiex.repository.BookRepository;
import com.bookcode.bookapiex.repository.BorrowRepository;
import com.bookcode.bookapiex.repository.UserRepository;
import com.bookcode.bookapiex.service.BookServive;
import com.bookcode.bookapiex.service.BorrowService;
import com.bookcode.bookapiex.service.StockService;
import com.bookcode.bookapiex.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Controller
public class UserController {
    @Autowired
    private UserService userService;
    private BorrowService borrowService;
    private BookServive bookServive;
    private BorrowRepository borrowRepository;
    private StockService stockService;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private BookRepository bookRepository;
    //登录用户
    private static User user = null;

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
    /**
     * 登录
     */
    @RequestMapping("/userlogin")
    public String login(@RequestParam("usernumber") String userNumber, @RequestParam("password") String password, Model model) {
        if(userNumber ==null || password==null){
            return null;
        }
         user = userService.login(userNumber, password);
        String result = "/user/login";
        if (user != null && user.getRole().equals("管理员")) {
            return result = "redirect:/getbooks";
        } else if (user != null && !user.getRole().equals("管理员")) {
            return result = "redirect:/getmybook";
        }
        return result;
    }

    /**
     * 注册
     * @param user
     * @return
     */
    @RequestMapping("/register")
    public String register(User user){
        userService.register(user);
        return "/user/login";
    }
    @ResponseBody
    @RequestMapping("/updateuser")
    public String update(String password,String department,String name){
        if (password == null && department == null && name == null){
            return null;
        }
        if (password != null){
            user.setPassword(password);
        }
        if (department != null){
            user.setDepartment(department);
        }
        if (name != null){
            user.setName(name);
        }
        userService.update(user);
        return "修改成功";
    }
    @RequestMapping("/deleteuser")
     public String delete(@RequestParam("id") long id){
        userRepository.deleteById(id);
        return "true";
     }

    /**
     * 批量删除
     * @param userNums
     * @return
     */
    public String deleteall(List<Long> userNums){
        userService.deleteAllByUserNum(userNums);
        return "删除成功";
    }
    /**
     * 获取读者信息
     * @return
     */
    @RequestMapping("/getuser")
    public String getUserList(Model model) {
        List<User> users = userRepository.findAll().stream().filter(user1 -> !user1.getRole().equals("管理员")).collect(Collectors.toList());
        Map<String,List<Book>> map = users.stream().collect(Collectors.toMap(user1->user1.getName(),user1 ->userService.getMyBook(user1)));
        model.addAttribute("usermap",map);
        return "user/alluser";
    }

    /**
     * 我的借书记录
     * @return
     */
    @RequestMapping("/getmybook")
    public String getMyBook(Model model){
        List<Book> myBooks = userService.getMyBook(user);
        model.addAttribute("mybooks",myBooks);
        return "user/list";
    }
   // Borrow borrow = new Borrow(3,"2020-4-28","2020-5-58","测试");

    /**
     * 借书
     * @return
     */
    @RequestMapping("/borrowbook")
    public String borrowBook(@RequestParam("bookid") long bookId,@RequestParam("returndate")String retrunDate){
        Borrow borrow = new Borrow();
        LocalDate date = LocalDate.now();
        borrow.setBorrowDate(date.toString());
        borrow.setReturnDate(retrunDate);
        System.out.println("bookId:"+borrow.getId());
        Book book = bookRepository.findByid(bookId);
        userService.borrowBook(user,borrow,book);
        return "redirect:/canborrow";
    }
    /**
     * 还书
     * @param bookId
     * @return
     */
    @ResponseBody
    @RequestMapping("/returnbook")
    public String returnBook(@RequestParam("id") long bookId){
        userService.returnBook(bookId);
        return "true";
    }

    /**
     * 个人信息
     * @param model
     * @return
     */
    @RequestMapping("/getuserinfo")
    public String userInfo(Model model){
        model.addAttribute("userinfo",user);
        return "user/userinfo";
    }

    /**
     * 所有用户信息
     * @param model
     * @return
     */
    @RequestMapping("/getalluserinfo")
    public String allUserInfo(Model model){
        model.addAttribute("users",userRepository.findAll());
        return "user/alluserinfo";
    }
    @RequestMapping("/info")
    public String statisticalInfo(Model model){
        Map<String,String> infoMap = new HashMap<>();
        infoMap.put("图书总量",String.valueOf(bookRepository.findAll().size()));
        infoMap.put("活跃用户",String.valueOf(userRepository.findAll().stream().filter(user1 -> !user1.getRole().equals("管理员")).collect(Collectors.toList()).size()));
        model.addAttribute("infoMap",infoMap);
        return "book/info";
    }
}
