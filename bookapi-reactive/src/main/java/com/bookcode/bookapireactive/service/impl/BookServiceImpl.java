package com.bookcode.bookapireactive.service.impl;

import com.alibaba.fastjson.JSON;
import org.apache.commons.io.IOUtils;
import com.bookcode.bookapireactive.service.BookService;
import com.bookcode.bookapireactive.model.Book;
import com.bookcode.bookapireactive.repository.BookRepository;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

@Service
public class BookServiceImpl implements BookService {
    @Autowired
    private BookRepository bookRepository;
    @Autowired
    ResourceLoader loader;
    int count = 0;
    /**
     * 根据id批量查找
     *
     * @param iterable
     * @return
     */
    @Override
    public Flux<Book> findAll(Iterable<Long> iterable) {
        return bookRepository.findAllById(iterable);
    }

    /**
     * id单个查找
     *
     * @param id
     * @return
     */
    @Override
    public Mono<Book> findById(long id) {
        return bookRepository.findById(id);
    }

    /**
     * 分页
     *
     * @param bookFlux
     * @param page
     * @return
     */
    public Flux<Book> page(Flux<Book> bookFlux, int page, int size) {
        page = page <= 0 ? 1 : page;
        size = size <= 0 ? 9 : size;
        return bookFlux.take(page * size).skip((page - 1) * size);
    }

    /**
     * 获取所有图书分类
     */
    public Flux<String> getCatalogs() {
       List<String> catalogs = new ArrayList<>();
       List<?> fenleis = new ArrayList<>();
       String [] strings = new String[20];
       Flux<Book> bookFlux =  bookRepository.findAll();
       Book book=  bookFlux.blockFirst();
       System.out.println(book.getCatalog());
       /*flux.forEach(book -> {
           System.out.println(book.getCatalog());
       });*/
      /*   bookRepository.findAll().subscribe(book -> {

            Arrays.asList(book.getCatalog().split(" ")).forEach(s -> {
                if (!catalogs.contains(s)){
                    catalogs.add(s);
                    strings[count] = s;
                    count++;
                    System.out.println(s);
                    System.out.println(strings[count-1]);
                }
            });
        });*/
       /* for (String s:strings
             ) {
            System.out.println("wai"+s);
        }
        System.out.println("wai"+count);*/
        return Flux.just("a","b","c");
        // return Flux.fromIterable(catalogs);
    }

    /**
     * 解析json数据
     * @param jsonContent
     */
    public void saveAllFromJson(String jsonContent){
        List<Book> list = JSON.parseArray(jsonContent,Book.class);
        Flux<Book> bookFlux = Flux.fromIterable(list);
        bookRepository.saveAll(bookFlux).subscribe();
    }

    /**
     * 读取json文件内容
     * @param name
     * @return
     */
    @Override
    public String getContentFromFile(String name) {
        try {
            InputStream in =loader.getResource(name).getInputStream();
            return IOUtils.toString(in,"UTF-8");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 根据书名模糊搜索
     *
     * @param title
     * @return
     */
    @Override
    public Flux<Book> searchByTitle(String title) {
        return bookRepository.findByTitleLike(title);
    }

    /**
     * 分类
     * @param catalog
     * @return
     */
    public Flux<Book> searchByCatalog(String catalog){
        return bookRepository.findByCatalogLike(catalog);
    }
    /**
     * 筛选热门书籍
     */
    @Override
    public Flux<Book> getHotBooks() {
        //正则表达式匹配数字
        String regEx = "[^0-9]";
        Pattern pattern = Pattern.compile(regEx);
        return bookRepository.findAll().filter(book -> {
            Matcher matcher = pattern.matcher(book.getReading());
            if (matcher.replaceAll("").trim() == null) {
                return false;
            }
            //如果阅读数大于10000人则判定为热门书籍
            if (Integer.parseInt(matcher.replaceAll("").trim()) > 10000) {
                return true;
            }
            return false;
        });
    }
    /**
     * 添加
     */
    public void add(Book book){
        bookRepository.findById(book.getId()).hasElement().subscribe(founded->{
            if (!founded){
                bookRepository.save(book).subscribe();
            }
        });
    }
    /**
     * 更新
     * @param book
     */
    public void update(Book book){
        bookRepository.findById(book.getId()).hasElement().subscribe(founded->{
            if (founded){
                bookRepository.save(book).subscribe();
            }
        });
    }

    public Mono<Long> getCount(){
        //Flux flux = Flux.just("1","2","2");
      return bookRepository.findAll().count();
    }

}
