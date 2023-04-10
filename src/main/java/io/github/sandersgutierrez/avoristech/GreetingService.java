package io.github.sandersgutierrez.avoristech;

import org.springframework.stereotype.Service;

import java.util.concurrent.atomic.AtomicLong;

@Service
public class GreetingService {
    public static final String template = "Hello %s!";

    private static final AtomicLong counter = new AtomicLong();

    public Greeting greet(String name) {
        return new Greeting(counter.incrementAndGet(), String.format(template, name));
    }
}
