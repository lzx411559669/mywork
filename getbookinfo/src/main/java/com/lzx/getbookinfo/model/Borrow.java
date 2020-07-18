package com.lzx.getbookinfo.model;

import javax.persistence.*;

@Entity
@Table(name = "borrow")
public class Borrow {
    @Id
    private long id;
    private String borrowDate;
    private String returnDate;
    private String remarks;
}
