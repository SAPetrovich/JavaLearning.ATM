package su.petrovich.JavaLearning.ATM.Processing.Controller;

import su.petrovich.JavaLearning.ATM.Processing.Entity.Account;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import su.petrovich.JavaLearning.ATM.Processing.Entity.Client;
import su.petrovich.JavaLearning.ATM.Processing.repository.ClientRepository;

import java.util.Set;


@RestController
@AllArgsConstructor
@Slf4j
public class HostRestController {

    private ClientRepository clientRepository;

    @GetMapping("/Clients")
    public String getClientsInfo() {
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append("{");
        for (Client client : clientRepository.findAll()) {
            log.info("---- клиент " + client.getFirstName());
            stringBuilder.append(" ").append(client.getFirstName()).append(" {");
            log.info("---- 1");
            Set<Account> accountSet = client.getAccounts();
            log.info("---- 2");
            stringBuilder.append(accountSet.isEmpty());
            log.info("---- 3");
            stringBuilder.append(accountSet.size());
            log.info("---- 4");
//            accountSet.forEach(account -> {
//                stringBuilder.append(" " + account.getBalance());
//            });
            stringBuilder.append(" }");

        }
        stringBuilder.append("}");

        return stringBuilder.toString();
    }

}
