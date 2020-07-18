package com.example.springboot_login.model;

public class PayInfo {
    /**
     * 支付类型
     */
    private PayType payType;
    /**
     * 账单日
     */
    private int billingDate;
    /**
     * 还款日
     */
    private int dueDate;
    /**
     * 金额
     */
    private double amount;
    /**
     * 分期数
     */
    private int stagesCount;

    public PayType getPayType() {
        return payType;
    }

    public void setPayType(PayType payType) {
        this.payType = payType;
    }

    public int getBillingDate() {
        return billingDate;
    }

    public void setBillingDate(int billingDate) {
        this.billingDate = billingDate;
    }

    public int getDueDate() {
        return dueDate;
    }

    public void setDueDate(int dueDate) {
        this.dueDate = dueDate;
    }

    public double getAmont() {
        return amount;
    }

    public void setAmont(double amont) {
        this.amount = amont;
    }

    public int getStagesCount() {
        return stagesCount;
    }

    public void setStagesCount(int stagesCount) {
        this.stagesCount = stagesCount;
    }
}
