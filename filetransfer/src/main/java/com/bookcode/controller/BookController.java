package com.bookcode.controller;

import com.bookcode.model.Book;
import com.bookcode.responsitory.BookRepository;
import com.bookcode.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.Map;

@RestController
public class BookController {
  /*  @RequestMapping(value = "/uploadhtml")
    public  String upload (){
        return "upload";

    }
    @RequestMapping("/downhtml")
    public String download(){
        return "download";
    }
    @ResponseBody
    @PostMapping(value = "/upload", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public Mono<String> requestBodyFlux(@RequestPart("file") FilePart filePart) throws IOException {
        System.out.println(filePart.filename());
        Path tempFile = Files.createTempFile("test", filePart.filename());

        //NOTE 方法1
      *//*  AsynchronousFileChannel channel =
                AsynchronousFileChannel.open(tempFile, StandardOpenOption.WRITE);
        DataBufferUtils.write(filePart.content(), channel, 0)
                .doOnComplete(() -> {
                    System.out.println("finish");
                })
                .subscribe();*//*

        //NOTE 方法二
        filePart.transferTo(tempFile.toFile());

        System.out.println(tempFile.toString());
        return Mono.just("文件："+filePart.filename()+" 上传成功");
    }
    @ResponseBody
    @GetMapping("/download")
    public Mono<Void> downloadByWriteWith(ServerHttpResponse response) throws IOException {
        ZeroCopyHttpOutputMessage zeroCopyResponse = (ZeroCopyHttpOutputMessage) response;
        response.getHeaders().set(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename = songlists.json");
        response.getHeaders().setContentType(MediaType.APPLICATION_JSON);

        Resource resource = new ClassPathResource("data/songlists.json");
        File file = resource.getFile();
        return zeroCopyResponse.writeWith(file, 0, file.length());
    }*/
    @Autowired
    private BookService bookService;
    @Autowired
    private BookRepository bookRepository;

    @GetMapping("/get/{id}")
    public Mono<Book> getBookById(@PathVariable String id){
        return bookRepository.getBookById(id);
    }
    @PostMapping("/add")
    public Mono<ResponseEntity<String>> add(@RequestBody Book book){
        bookRepository.add(book);
        return Mono.just(new ResponseEntity<>("add Successfully!", HttpStatus.CREATED));
    }
    @PutMapping("/update")
    public Mono<ResponseEntity<Book>> update(@RequestParam("id") String id, @RequestBody Book book) {
        bookRepository.update(id,book);
        return Mono.just(new ResponseEntity<>(book, HttpStatus.CREATED));
    }
    @DeleteMapping("/delete/{id}")
    public Mono<ResponseEntity<String>> deleteMethod(@PathVariable String id) {
        bookRepository.delete(id);
        return Mono.just(new ResponseEntity<>("Delete Successfully!", HttpStatus.ACCEPTED));
    }
    @GetMapping("/booklists")
    public Flux<Book> getAll(){
        return bookRepository.getBooks();
    }
    //业务逻辑处理
    @GetMapping("/totalprice")
    public double getTotal(){
       return bookService.totalPrice(bookRepository.getBooks());
    }
    @GetMapping("/getbytype/{type}")
    public Flux<Book> getByType(@PathVariable String type){
        return bookService.sortByType(bookRepository.getBooks(),type);
    }
    @GetMapping("/sortbyprice")
    public Mono<List<Book>> sort(){
        return bookService.sortByPrice(bookRepository.getBooks());
    }
    @GetMapping("/sortbytime")
    public Mono<List<Book>> sortByTime(){
        return bookService.sortByTime(bookRepository.getBooks());
    }
    @GetMapping("/allkinds")
    public String getkinds(){
        StringBuilder strResult = new StringBuilder();
        bookService.type(bookRepository.getBooks()).subscribe(t->{
            strResult.append(t).append(" | ");
        });
       return strResult.toString();
    }
    @GetMapping("/grouping")
    public void mapMono(){
        Map<String,Flux<Book>> map= bookService.toMap(bookRepository.getBooks());
        for (String type : map.keySet()) {
            System.out.println("type= "+ type );
            map.get(type).subscribe(System.out::println);
        }
    }
}
