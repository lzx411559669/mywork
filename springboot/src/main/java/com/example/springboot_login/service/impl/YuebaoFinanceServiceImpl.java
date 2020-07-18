package com.example.springboot_login.service.impl;

import com.example.springboot_login.model.FinanceInfo;
import com.example.springboot_login.service.FinanceService;

import java.util.Date;

public class YuebaoFinanceServiceImpl implements FinanceService {

    @Override
    public FinanceInfo invest(double amount, int days) {
        FinanceInfo financeInfo=new FinanceInfo();
        double income=amount*0.292/365*days;
        financeInfo.setIncome(income);
        financeInfo.setStartTime(new Date());
        financeInfo.setAmount(amount);
        financeInfo.setDays(days);
        return financeInfo;
    }
}
