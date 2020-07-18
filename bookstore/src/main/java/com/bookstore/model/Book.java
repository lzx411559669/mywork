package com.bookstore.model;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class Book {
    // 主键
    private long id;
    // 图书的名称
    @NotBlank(message = "图书名不为空")
    private String name;
    // 图书的作者
    private String author;
    // 图书的描述
    private String desc;
    // 图书的编号
    @NotBlank(message = "编号不为空")
    private String isbn;
    // 图书的价格
    private double price;
    // 图书的封面图片
    private String pictureUrl;
    //出版日期
    private String publishDate;

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

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getPictureUrl() {
        return pictureUrl;
    }

    public void setPictureUrl(String pictureUrl) {
        this.pictureUrl = pictureUrl;
    }

    public String getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(String publishDate) {
        this.publishDate = publishDate;
    }
}
