package com.example.springboot_login.service;

import com.example.springboot_login.model.FinanceInfo;

public  interface FinanceService {
    public FinanceInfo invest(double amount, int days);
}
