package com.bookcode.bookapiex.model;
import javax.persistence.*;
import java.util.List;
@Entity
@Table(name = "stock")
public class Stock {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String managementid;
    private String address;
    private String state;
    private String remarks;
    @OneToMany(fetch=FetchType.EAGER)
    @JoinColumn(name = "stock_id", referencedColumnName = "id")
    private List<Book> bookList;

    public Stock() {
    }

    public Stock(long id, String managementid, String address, String state, String remarks) {
        this.id = id;
        this.managementid = managementid;
        this.address = address;
        this.state = state;
        this.remarks = remarks;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getManagementid() {
        return managementid;
    }

    public void setManagementid(String managementid) {
        this.managementid = managementid;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public List<Book> getBookList() {
        return bookList;
    }

    public void setBookList(List<Book> bookList) {
        this.bookList = bookList;
    }
}
