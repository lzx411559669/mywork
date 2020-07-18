package com.bookcode.bookapiex.service.impl;

import com.bookcode.bookapiex.model.Book;
import com.bookcode.bookapiex.model.Borrow;
import com.bookcode.bookapiex.model.Stock;
import com.bookcode.bookapiex.repository.BookRepository;
import com.bookcode.bookapiex.repository.StockRepository;
import com.bookcode.bookapiex.service.BookServive;
import com.bookcode.bookapiex.service.BorrowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookServiceImpl implements BookServive {
    @Autowired
    BorrowService borrowService;
    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private StockRepository stockRepository;

    @Override
    public List<Book> findById(Iterable<Long> booids) {
        return bookRepository.findAllById(booids);
    }

    @Override
    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    /**
     * 分页
     * @param pageable
     * @return
     */
    public Page<Book> bookPage(Pageable pageable){
        return bookRepository.findAll(pageable);
    }

    /**
     * 添加图书
     * @param book
     * @param stcokId
     */
    public void Save(Book book,long stcokId){
        bookRepository.save(book);
        Stock stock = stockRepository.findById(stcokId);
        stock.getBookList().add(book);
        stockRepository.save(stock);
    }

    /**
     * 批量插入
     *
     * @param bookList
     * @param stockId
     */
    public void SaveAll(List<Book> bookList, long stockId) {
        //插入到book表
        bookRepository.saveAll(bookList);
        //更新stock表
        Stock stock = stockRepository.findById(stockId);
        bookList.forEach(book -> stock.getBookList().add(book));
        stockRepository.save(stock);
    }
    /**
     * 可借阅书籍
     *
     * @return
     */
    @Override
    public List<Book> canBorrow() {
        List<Book> canBorrowBooks = bookRepository.findAll().stream().filter(book -> {
            //如果没有借阅信息则表示未借
            if (book.getBorrowList().size() == 0) {
                return true;
            }
            return false;
        }).collect(Collectors.toList());
        return canBorrowBooks;
    }

    /**
     * 按类别查找
     * @param type
     * @return
     */
    @Override
    public List<Book> findByType(String type) {
        return bookRepository.findByType(type);
    }

    /**
     * 按出版社查找
     * @param press
     * @return
     */
    public List<Book> findByPress(String press){
        return bookRepository.findByPress(press);
    }

    /**
     * 按作者查找
     * @param author
     * @return
     */
    public List<Book> findByAuthor(String author){
        return bookRepository.findByAuthor(author);
    }

    /**
     * 根据书名模糊查找
     * @param bookName
     * @return
     */
    public List<Book> findByBookName(String bookName){
        return bookRepository.findByNameLike(bookName);
    }

    /**
     * 查看新书timeDays天以内
     */
    public List<Book> getNewBook(int timeDays) {
        //获取所有图书
        List<Book> bookList = bookRepository.findAll();
        //获取当前时间
        LocalDate localDate = LocalDate.now().minusDays(timeDays);
        //筛选出符合要求的图书
        List<Book> bookList1 = bookList.stream().filter(book -> LocalDate.parse(book.getPublishDate()).isAfter(localDate)).collect(Collectors.toList());
        return bookList1;
    }

    /**
     * 更新returnDate ，remarks
     * @param bookid
     * @param returnDate
     * @param remarks
     */
    public void update(long bookid,String returnDate,String remarks){
       Book book = bookRepository.findByid(bookid);
        Borrow borrow = book.getBorrowList().get(0);
       if (returnDate != null){
           borrow.setReturnDate(returnDate);
       }
        if (remarks != null){
            borrow.setRemarks(remarks);
        }
       borrowService.update(borrow);
    }
}
