package io.github.sandersgutierrez.avoristech.greeting.adapter.in.web;

import io.github.sandersgutierrez.avoristech.greeting.application.port.in.GreetingPort;
import io.github.sandersgutierrez.avoristech.greeting.application.service.GreetingService;
import io.github.sandersgutierrez.avoristech.greeting.domain.Greeting;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {

    private final GreetingPort greetingPort;

    @Autowired
    public GreetingController(GreetingPort greetingPort) {
        this.greetingPort = greetingPort;
    }

    @GetMapping("/greeting")
    public @ResponseBody Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
        return greetingPort.greet(name);
    }
}
