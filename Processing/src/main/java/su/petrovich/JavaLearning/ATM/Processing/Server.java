package su.petrovich.JavaLearning.ATM.Processing;

import org.springframework.context.ApplicationContext;
import org.springframework.data.repository.CrudRepository;
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
    // Вывод содержимого репозиториев в отладочный протокол
    public static CommandLineRunner logBeans(ApplicationContext appContext) {
        return (args) -> {
            if (!log.isDebugEnabled()) return;
            appContext.getBeansOfType(CrudRepository.class).forEach( (repositoryName, repository) -> {
                log.debug("┌──────────── {}", repositoryName);
                repository.findAll().forEach(entity -> log.debug("│ {}", entity.toString()));
                log.debug("└──────────────────────────────────────────");
            });
        };
    }

}
