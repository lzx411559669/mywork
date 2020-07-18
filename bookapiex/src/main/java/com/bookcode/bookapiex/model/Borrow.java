package com.bookcode.bookapiex.model;

import javax.persistence.*;

@Entity
@Table(name = "borrow")
public class Borrow {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String borrowDate;
    private String returnDate;
    private String remarks;
    public Borrow() {
    }

    public Borrow(long id, String borrowDate, String returnDate, String remarks) {
        this.id = id;
        this.borrowDate = borrowDate;
        this.returnDate = returnDate;
        this.remarks = remarks;

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getBorrowDate() {
        return borrowDate;
    }

    public void setBorrowDate(String borrowDate) {
        this.borrowDate = borrowDate;
    }

    public String getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(String returnDate) {
        this.returnDate = returnDate;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

}
