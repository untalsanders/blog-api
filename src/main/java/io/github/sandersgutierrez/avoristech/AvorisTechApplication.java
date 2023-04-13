package io.github.sandersgutierrez.avoristech;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.Banner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class AvorisTechApplication implements CommandLineRunner {

    public static final Logger log = LoggerFactory.getLogger(AvorisTechApplication.class);

    public static void main(String[] args) {
        SpringApplication application = new SpringApplication(AvorisTechApplication.class);
        application.setBannerMode(Banner.Mode.OFF);
        application.run(args);
    }

    @Override
    public void run(String... args) {
        log.info("\uD83D\uDE80 Avoris Application is running at http://localhost:9090 \uD83D\uDE80");
    }
}
