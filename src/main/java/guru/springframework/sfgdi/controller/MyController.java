package guru.springframework.sfgdi.controller;

import guru.springframework.sfgdi.services.GreetingService;
import org.springframework.stereotype.Controller;

@Controller
public class MyController {
    private final GreetingService service;

    public MyController(GreetingService service) {
        this.service = service;
    }

    public String sayHello() {
        System.out.println(service.sayGreeting());
        return "Hi";
    }
}
