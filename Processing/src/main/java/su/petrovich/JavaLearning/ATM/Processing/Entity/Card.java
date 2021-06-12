package su.petrovich.JavaLearning.ATM.Processing.Entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "cards")
@NoArgsConstructor
@Data
public class Card {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    private String number; // 16..18 цифр
    private String holderName; // латинские буквы и пробел
    private Integer expirationYear; // Год окончания срока действия карты
    private Integer expirationMonth; // Месяц окончания срока действия карты
    private String pinCode; // 4..6 цифр
    private String securityCode; // CVC2/CVV2 код 3 цифры

    @ManyToOne
    @JoinColumn(nullable = false)
    private Account account;
}
