package su.petrovich.JavaLearning.ATM.Client;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import java.util.Arrays;

@SpringBootApplication
@Slf4j
public class Application {

    public static void main(String[] args) { SpringApplication.run(Application.class, args); }

    @Bean
     public static CommandLineRunner logBeans() {
        return (args) -> log.debug("────────────");
    }

}
