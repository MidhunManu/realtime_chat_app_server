package com.company.xyz.MessageTest;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.util.HtmlUtils;

@CrossOrigin(origins = "http://localhost:3000")
@Controller
public class GreetingController {
    @MessageMapping("/hello")
    @SendTo("topic/greetings")

    public Greeting greeting(HelloMessage helloMessage) throws InterruptedException{
        Thread.sleep(1000);
        return new Greeting("Hello" + HtmlUtils.htmlEscape(helloMessage.getName()) + "!");
    }
}
