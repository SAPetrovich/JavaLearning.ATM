package su.petrovich.JavaLearning.ATM.ProcessingAPI;

import lombok.Value;

import java.math.BigDecimal;

@Value
public class BalanceDTO {
    BigDecimal value;
}
