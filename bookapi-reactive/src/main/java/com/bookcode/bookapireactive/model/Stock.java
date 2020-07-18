package com.bookcode.bookapireactive.model;

import org.junit.Test;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Table("stock")
public class Stock {
    @Id
    private long id;
    private String managementid;
    private String address;
    private String state;
    private String remarks;

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

}
