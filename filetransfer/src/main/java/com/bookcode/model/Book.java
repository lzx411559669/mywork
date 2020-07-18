package com.bookcode.model;
import java.time.LocalDateTime;
public class Book {

    private String id;
    private String name;
    private String type;
    private LocalDateTime publishDate;
    private double price;

    public Book() {

    }

    public Book(String id, String name, String type, LocalDateTime publishDate, double price) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.publishDate = publishDate;
        this.price = price;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public LocalDateTime getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(LocalDateTime publishDate) {
        this.publishDate = publishDate;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", publishDate=" + publishDate +
                ", price=" + price +
                '}';
    }
}
