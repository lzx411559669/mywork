package com.bookcode.bookapireactive.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.util.List;

@Table("book")
public class Book {
    @Id
    private long id;
    private String title;
    private String catalog;
    private String tags;
    private String sub1;
    private String sub2;
    private String img;
    private String reading;
    private String online;
    private String bytime;
/*    private Borrow borrow;
    private Stock stock;
    private List<User> userList;*/

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCatalog() {
        return catalog;
    }

    public void setCatalog(String catalog) {
        this.catalog = catalog;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    public String getSub1() {
        return sub1;
    }

    public void setSub1(String sub1) {
        this.sub1 = sub1;
    }

    public String getSub2() {
        return sub2;
    }

    public void setSub2(String sub2) {
        this.sub2 = sub2;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getReading() {
        return reading;
    }

    public void setReading(String reading) {
        this.reading = reading;
    }

    public String getOnline() {
        return online;
    }

    public void setOnline(String online) {
        this.online = online;
    }

    public String getBytime() {
        return bytime;
    }

    public void setBytime(String bytime) {
        this.bytime = bytime;
    }

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", catalog='" + catalog + '\'' +
                ", tags='" + tags + '\'' +
                ", sub1='" + sub1 + '\'' +
                ", sub2='" + sub2 + '\'' +
                ", img='" + img + '\'' +
                ", reading='" + reading + '\'' +
                ", online='" + online + '\'' +
                ", bytime='" + bytime + '\'' +
                '}';
    }
}
