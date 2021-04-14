package guru.springframework.sfgdi.controller;

import guru.springframework.sfgdi.services.GreetingService;
import org.springframework.stereotype.Controller;

@Controller
public class ConstructorInjectedController {
    private final GreetingService service;

    public ConstructorInjectedController(GreetingService service) {
        this.service = service;
    }

    public String getGreeting() {
        return service.sayGreeting();
    }
}
