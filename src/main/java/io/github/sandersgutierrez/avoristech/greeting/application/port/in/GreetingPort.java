package io.github.sandersgutierrez.avoristech.greeting.application.port.in;

import io.github.sandersgutierrez.avoristech.greeting.domain.Greeting;

public interface GreetingPort {
    Greeting greet(String name);
}
