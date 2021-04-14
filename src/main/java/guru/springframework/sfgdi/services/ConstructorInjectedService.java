package guru.springframework.sfgdi.services;

import org.springframework.stereotype.Service;

@Service
public class ConstructorInjectedService implements GreetingService{

    @Override
    public String sayGreeting() {
        return "hello world - constructor";
    }
}
