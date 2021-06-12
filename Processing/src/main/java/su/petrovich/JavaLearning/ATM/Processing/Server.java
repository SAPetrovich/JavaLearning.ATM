package su.petrovich.JavaLearning.ATM.Processing;

import su.petrovich.JavaLearning.ATM.Processing.Repository.AccountRepository;
import su.petrovich.JavaLearning.ATM.Processing.Repository.CardRepository;
import su.petrovich.JavaLearning.ATM.Processing.Repository.ClientRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@Slf4j
public class Server {
    public static void main(String[] args) {
        SpringApplication.run(Server.class,args);
    }

    @Bean
    public CommandLineRunner logClients(ClientRepository repository) {
        return (args) -> {
            log.info("┌───────── ClientRepository");
            repository.findAll().forEach(entity -> log.info("│ {}", entity.toString()));
            log.info("└──────────────────────────────────────────");
        };
    }

    @Bean
    public CommandLineRunner logAccounts(AccountRepository repository) {
        return (args) -> {
            log.info("┌───────── AccountRepository");
            repository.findAll().forEach(entity -> log.info("│ {}", entity.toString()));
            log.info("└──────────────────────────────────────────");
        };
    }

    @Bean
    public CommandLineRunner logCards(CardRepository repository) {
        return (args) -> {
            log.info("┌───────── CardRepository");
            repository.findAll().forEach(entity -> log.info("│ {}", entity.toString()));
            log.info("└──────────────────────────────────────────");
        };
    }
}
