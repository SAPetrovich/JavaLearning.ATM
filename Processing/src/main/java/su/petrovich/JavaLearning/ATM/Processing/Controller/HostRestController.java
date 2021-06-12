package su.petrovich.JavaLearning.ATM.Processing.Controller;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import su.petrovich.JavaLearning.ATM.ProcessingAPI.BalanceDTO;
import su.petrovich.JavaLearning.ATM.Processing.Service.CardService;
import su.petrovich.JavaLearning.ATM.ProcessingAPI.ClientDTO;


@RestController
@RequestMapping("/card/{cardNumber}")
@AllArgsConstructor
@Slf4j
public class HostRestController {

    private final CardService cardService;

    // http://localhost:2200/card/1234123412340001/client/0001    ERROR expired
    // http://localhost:2200/card/1234123412340001/client/0002    ERROR expired & invalid pin
    // http://localhost:2200/card/1234123412340002/client/0001    ERROR invalid pin
    // http://localhost:2200/card/1234123412340002/client/0002    SUCCESS
    @GetMapping("/client/{pinCode}")
    public ClientDTO getClient(@PathVariable String cardNumber, @PathVariable String pinCode) {
        return cardService.getClient(cardNumber, pinCode);
    }

    // http://localhost:2200/card/1234123412340001/balance
    // http://localhost:2200/card/1234123412340002/balance
    // http://localhost:2200/card/1234123412340003/balance
    // http://localhost:2200/card/1234123412340004/balance
    // http://localhost:2200/card/1234123412340009/balance
    @GetMapping("/balance")
    public BalanceDTO getBalance(@PathVariable String cardNumber) {
        return cardService.getBalance(cardNumber);
    }

}
