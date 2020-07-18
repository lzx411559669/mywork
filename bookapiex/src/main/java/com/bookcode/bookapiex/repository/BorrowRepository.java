package com.bookcode.bookapiex.repository;

import com.bookcode.bookapiex.model.Borrow;
import com.bookcode.bookapiex.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface BorrowRepository extends JpaRepository<Borrow,Long> {
    @Override
    List<Borrow> findAll();

}
