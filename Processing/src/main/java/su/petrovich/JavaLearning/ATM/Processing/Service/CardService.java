package su.petrovich.JavaLearning.ATM.Processing.Service;


import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import su.petrovich.JavaLearning.ATM.Processing.Entity.Account;
import su.petrovich.JavaLearning.ATM.Processing.Entity.Card;
import su.petrovich.JavaLearning.ATM.Processing.Entity.Client;
import su.petrovich.JavaLearning.ATM.Processing.Repository.AccountRepository;
import su.petrovich.JavaLearning.ATM.Processing.Repository.CardRepository;
import su.petrovich.JavaLearning.ATM.Processing.exception.CardNotFoundException;
import su.petrovich.JavaLearning.ATM.ProcessingAPI.BalanceDTO;
import su.petrovich.JavaLearning.ATM.ProcessingAPI.ClientDTO;
import java.math.BigDecimal;

/**
 * Класс обеспечивающий получение баланса
 */
@Service
@AllArgsConstructor
public class CardService {

    private final CardRepository cardRepository;
    private final AccountRepository accountRepository;

    /**
     * Возвращает баланс счета, связанного с картой {@code cardNumber}
     */
    public BalanceDTO getBalance(String cardNumber) {
        Account account = cardRepository.findByNumber(cardNumber).orElseThrow(CardNotFoundException::new).getAccount();
        return mapToBalanceDTO(account);
    }

    /**
     * Возвращает информацию о клиенте-держателе карты {@code cardNumber}
     */
    public ClientDTO getClientInfo(String cardNumber) {
        Card card = cardRepository.findByNumber(cardNumber).orElseThrow(CardNotFoundException::new);
        return mapToClientDTO(card.getClient());
    }

    public Boolean isValid(String cardNumber, String pinCode){
        return cardRepository.findByNumber(cardNumber)
                .filter( card1 -> !card1.isExpired() && card1.isValidPin(pinCode) )
                .isPresent();
    }

    private BalanceDTO mapToBalanceDTO(Account account){
        return new BalanceDTO(new BigDecimal(account.getBalance()));
    }

    private ClientDTO mapToClientDTO(Client client){
        return new ClientDTO(client.getFirstName(), client.getLastName());
    }

}
