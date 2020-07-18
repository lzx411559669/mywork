package com.example.cloudbusstreamkafka;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
public class GreetingsController {
    private final GreetingsService greetingsService;
    public GreetingsController(GreetingsService greetingsService) {
        this.greetingsService = greetingsService;
    }
    @GetMapping("/greetings")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void greetings(@RequestParam("message") String message) {
        Greetings greetings = Greetings.builder()
                .message(message)
                .timestamp(System.currentTimeMillis())
                .build();
        greetingsService.sendGreeting(greetings);
    }
    @Autowired
    private SendMessage sendMessage;
    @RequestMapping(value = "/send/{msg}",method = RequestMethod.GET)
    public void send(@PathVariable("msg") String msg){
        sendMessage.sendMessage(msg);
    }
}