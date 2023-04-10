package io.github.sandersgutierrez.avoristech;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AvorisTechApplication implements CommandLineRunner {

    public static final Logger log = LoggerFactory.getLogger(AvorisTechApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(AvorisTechApplication.class, args);
    }

    @Override
    public void run(String... args) {
        log.info("Initializing Avoris Application");
    }
}
