package io.github.sandersgutierrez.avoristech;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@SpringBootApplication
public class AvorisTechApplication implements CommandLineRunner {

    public static final Logger log = LoggerFactory.getLogger(AvorisTechApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(AvorisTechApplication.class, args);
    }

    @Override
    public void run(String... args) {
        LocalDateTime ldt = LocalDateTime.of(1988, 11, 21, 22, 35);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String dtf = ldt.format(formatter);
        log.info("Initializing Avoris Application at " + dtf);
    }
}
