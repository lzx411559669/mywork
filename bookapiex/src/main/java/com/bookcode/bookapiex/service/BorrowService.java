package com.bookcode.bookapiex.service;

import com.bookcode.bookapiex.model.Borrow;

import java.util.List;

public interface BorrowService {
    List<Borrow> findAll();
    public void delete(Long borrowId);
    public void update(Borrow borrow);
}
