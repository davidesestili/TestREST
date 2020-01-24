package test;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldRestController {
 
    @RequestMapping("/")
    public String welcome() {//Welcome page, non-rest
        return "Welcome to RestTemplate Example.";
    }
 
    @RequestMapping("/hello/{name}/{surName}")
    public Message message(@PathVariable String name, @PathVariable String surName) {//REST Endpoint.
 
        Message msg = new Message(name, surName, "Ciao " + name + " " + surName);
        return msg;
    }
}
