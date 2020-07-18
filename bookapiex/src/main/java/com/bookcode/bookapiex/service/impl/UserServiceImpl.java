package com.bookcode.bookapiex.service.impl;

import com.bookcode.bookapiex.model.Book;
import com.bookcode.bookapiex.model.Borrow;
import com.bookcode.bookapiex.model.User;
import com.bookcode.bookapiex.repository.BookRepository;
import com.bookcode.bookapiex.repository.BorrowRepository;
import com.bookcode.bookapiex.repository.UserRepository;
import com.bookcode.bookapiex.service.BookServive;
import com.bookcode.bookapiex.service.BorrowService;
import com.bookcode.bookapiex.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private BookServive bookServive;
    @Autowired
    private BorrowRepository borrowRepository;
    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private BorrowService borrowService;

    /**
     * 登录
     * @param userNumber
     * @param password
     * @return
     */

    @Override
    public User login(String userNumber, String password) {
        return userRepository.login(userNumber, password);
    }

    /**
     * 注册
     * @param user
     */
    public void register(User user){
        userRepository.save(user);
    }

    /**
     * 更新个人信息
     * @param user
     */
    public void update(User user){
        userRepository.save(user);
    }

    /**
     * 批量删除用户
     * @param userNums
     */
    public void deleteAllByUserNum(List<Long> userNums){
        userNums.forEach(number->{
            userRepository.deleteByUserNumber(number);
        });
    }

    /**
     * 获取个人借阅的所有书名
     * @param user
     * @return
     */
    @Override
    public List<Book> getMyBook(User user) {
        System.out.println(user.getName());
        List<Borrow> borrowList = user.getBorrowList();
        List<Book> books = bookServive.findAll();
        List<Book> bookList = null;
        bookList = books.stream().filter(book -> {
            for (Borrow each : borrowList
            ) {
                if (book.getBorrowList().size()!=0){
                    if (book.getBorrowList().get(0).getId()==each.getId()) {
                        return true;
                    }
                }
            }
            return false;
        }).collect(Collectors.toList());
        return bookList;
    }

    /**
     * 借书
     * @param user
     * @param borrow
     * @param book
     */
    public void borrowBook(User user, Borrow borrow, Book book) {
        //添加借阅记录
        borrowRepository.save(borrow);
        //更新图书实体
        book.getBorrowList().add(borrow);
        bookRepository.save(book);
        //更新用户实体
        user.getBorrowList().add(borrow);
        userRepository.save(user);
    }

    /**
     * 还书
     * @param bookId
     */
    public void returnBook(Long bookId){
    Book book = bookRepository.findByid(bookId);
    Borrow borrow = book.getBorrowList().get(0);
    System.out.println("borrow id="+borrow.getId());
    borrowService.delete(borrow.getId());
    }
}
