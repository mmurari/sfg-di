package guru.springframework.sfgdi.controller;

import guru.springframework.sfgdi.services.GreetingService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

@Controller
public class I18nController {
    private final GreetingService service;

    public I18nController(@Qualifier("i18nService") GreetingService service) {
        this.service = service;
    }

    public String sayHello(){
        return service.sayGreeting();
    }
}
