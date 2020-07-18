package com.example.springboot_login.controller;

import com.example.springboot_login.model.*;
import com.example.springboot_login.service.FinanceService;
import com.example.springboot_login.service.RecordService;
import com.example.springboot_login.service.impl.JdFinanceServiceImpl;
import com.example.springboot_login.service.impl.RecordServiceImpl;
import com.example.springboot_login.service.impl.YuebaoFinanceServiceImpl;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class AccountingController {
    private static RecordService recordService = new RecordServiceImpl();
    private static final List<PayInfo> payInfos = new ArrayList<>();
    private static final List<AccountingRecord> records = new ArrayList<>();
    @GetMapping(value = "/hello")
    public String hello(){
        return  "hello world";
    }


    // private static final List<AccountingRecord> filterd =new ArrayList<>();
    @RequestMapping(path = "/accounting")
    public Accounting accounting(Accounting accounting) {
        int result = accounting.getCash() + accounting.getIncome() - accounting.getCharges() - accounting.getEat()
                - accounting.getKtv() - accounting.getRent() - accounting.getTreat();
        accounting.setBalance(result);
        return accounting;
    }

    @RequestMapping(path = "/record")
    public String record(AccountingRecord record) {
        if (record.getAmount() == 0) {
            return "";
        }
        Date time = new Date();
        record.setTime(time);
        //调用方法
        recordService.record(record);
        return "记录成功";

    }

    @RequestMapping(path = "/query")
    public List<AccountingRecord> query() {
        return recordService.query();
    }

    @RequestMapping(path = "/search")
    public String search(@RequestParam("amount") int amount) {
        List<AccountingRecord> filterd = records.stream().filter(record -> record.getAmount() > amount).collect(Collectors.toList());
        StringBuffer sb = new StringBuffer();

           /* List<AccountingRecord> filterd =new ArrayList<>();

            for (AccountingRecord i:records) {
                if(i.getAmount()>amount)
                     filterd.add(i);
            }*/
        for (AccountingRecord item : filterd) {
            sb.append("金额：" + item.getAmount() + "<br/>" + item.getType() + "<br/>" + item.getCategory() + "<br/>" + item.getTime() + "<br/>");
        }
        String result = sb.toString();
        return result;
    }

    @PostConstruct
    public void init() {
        //初始化白条数据
        PayInfo baitiao = new PayInfo();
        baitiao.setPayType(PayType.baitiao);
        baitiao.setBillingDate(10);
        baitiao.setDueDate(20);
        payInfos.add(baitiao);
        //初始化花呗数据
        PayInfo huabei = new PayInfo();
        huabei.setPayType(PayType.huabei);
        huabei.setBillingDate(20);
        huabei.setDueDate(10);
        payInfos.add(huabei);
        //初始化信用卡数据
        CreditCard creditCard = new CreditCard();
        creditCard.setPayType(PayType.creditCard);
        creditCard.setBillingDate(5);
        creditCard.setDueDate(25);
        creditCard.setName("招商银行信用卡");
        creditCard.setCardNumber("111111111111");
        payInfos.add(creditCard);
    }

    @RequestMapping(path = "/pay")
    public PayInfo pay(@RequestParam("amount") double amount, @RequestParam("payType") PayType payType, @RequestParam("stagesCount") int stagesCount) {
        List<PayInfo> payInfoList = payInfos.stream().filter(payinfos -> payinfos.getPayType().equals(payType)).collect(Collectors.toList());
        if (payType.equals(PayType.creditCard)) {
            CreditCard creditCard = (CreditCard) payInfoList.get(0);
            //返回数据
            CreditCard result = new CreditCard();
            result.setBillingDate(creditCard.getBillingDate());
            result.setDueDate(creditCard.getDueDate());
            result.setPayType(payType);
            result.setAmont(amount);
            result.setStagesCount(stagesCount);
            result.setName(creditCard.getName());
            result.setCardNumber(creditCard.getCardNumber());
            return result;
        } else {
            PayInfo payinfo = payInfoList.get(0);
            //返回数据
            PayInfo result = new PayInfo();
            result.setBillingDate(payinfo.getBillingDate());
            result.setDueDate(payinfo.getDueDate());
            result.setPayType(payType);
            result.setAmont(amount);
            result.setStagesCount(stagesCount);
            return result;
        }

    }

    @RequestMapping(path = "/finance")
    public FinanceInfo finance(@RequestParam("type") FincaceType type, @RequestParam("amount") double amount, @RequestParam("days") int days) {
        FinanceService financeService = null;
        //根据不同的类型，实例化不同的服务实现者
        if (FincaceType.yuebao.equals(type)) {
            financeService = new YuebaoFinanceServiceImpl();

        } else if (FincaceType.jd.equals(type)) {
            financeService = new JdFinanceServiceImpl();
        } else {
            return null;
        }
        return financeService.invest(amount, days);
    }

}
