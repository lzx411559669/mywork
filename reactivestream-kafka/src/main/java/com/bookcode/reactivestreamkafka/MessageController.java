package com.bookcode.reactivestreamkafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MessageController {
    @Autowired
    private SendMessage sendMessage;
    @RequestMapping(value = "/send/{msg}",method = RequestMethod.GET)
    public void send(@PathVariable("msg") String msg){
        sendMessage.sendMessage(msg);
    }
}
