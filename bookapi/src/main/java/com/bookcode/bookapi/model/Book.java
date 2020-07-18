package com.bookcode.bookapi.model;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name = "book")
public class Book {
    @Id
    private long id;
    private String name;
    private String author;
    //图书编号
    private String isbn;
    private String type;
    private String publishDate;
    private double price;
    //封面地址
    private String imgurl;
    public Book() {
    }
    public Book(long id, String name, String author, String isbn, String type, String publishDate, double price, String imgurl) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.isbn = isbn;
        this.type = type;
        this.publishDate = publishDate;
        this.price = price;
        this.imgurl = imgurl;
    }
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getAuthor() {
        return author;
    }
    public void setAuthor(String author) {
        this.author = author;
    }
    public String getIsbn() {
        return isbn;
    }
    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }
    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }
    public String getPublishDate() {
        return publishDate;
    }
    public void setPublishDate(String publishDate) {
        this.publishDate = publishDate;
    }
    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        this.price = price;
    }
    public String getImgurl() {
        return imgurl;
    }
    public void setImgurl(String imgurl) {
        this.imgurl = imgurl;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", isbn='" + isbn + '\'' +
                ", type='" + type + '\'' +
                ", publishDate='" + publishDate + '\'' +
                ", price=" + price +
                ", imgurl='" + imgurl + '\'' +
                '}';
    }
}
