package com.bookcode.bookapiex.service.impl;

import com.bookcode.bookapiex.model.Borrow;
import com.bookcode.bookapiex.repository.BorrowRepository;
import com.bookcode.bookapiex.service.BorrowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BorrowServiceImpl implements BorrowService {
    @Autowired
    private BorrowRepository borrowRepository;

    /**
     * 更新
     * @param borrow
     */
    public void update(Borrow borrow){
        borrowRepository.save(borrow);
    }
    /**
     * 返回所有借阅表
     * @return
     */
    @Override
    public List<Borrow> findAll() {
        return borrowRepository.findAll();
    }
    /**
     * 删除借阅信息
     */
    public void delete(Long borrowId){
        borrowRepository.deleteById(borrowId);
    }
}
