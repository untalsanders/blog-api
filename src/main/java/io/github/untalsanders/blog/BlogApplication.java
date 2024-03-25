package io.github.untalsanders.blog;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.Banner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BlogApplication implements CommandLineRunner {

    private static final Logger LOGGER = LoggerFactory.getLogger(io.github.untalsanders.blog.BlogApplication.class);

    public static void main(String[] args) {
        SpringApplication application = new SpringApplication(io.github.untalsanders.blog.BlogApplication.class);
        application.setBannerMode(Banner.Mode.OFF);
        application.run(args);
    }

    @Override
    public void run(String... args) {
        LOGGER.info("\uD83D\uDE80 BlogAPI is running at http://localhost:9090 \uD83D\uDE80");
    }
}
