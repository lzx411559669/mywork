package com.example.springboot_login.service;


import com.example.springboot_login.model.AccountingRecord;

import java.util.List;

public interface RecordService {
    /**
     * 记录 数据
     */
    public void  record(AccountingRecord record);
    /**
     * 查询数据
     */
    public List<AccountingRecord> query();
}
