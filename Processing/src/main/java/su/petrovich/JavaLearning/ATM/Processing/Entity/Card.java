package su.petrovich.JavaLearning.ATM.Processing.Entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.util.Calendar;
import java.util.GregorianCalendar;

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
    private Client client;

    @ManyToOne
    @JoinColumn(nullable = false)
    private Account account;

    public Boolean isExpired() {
        Calendar calendar = new GregorianCalendar();

        int delta = expirationYear - calendar.get(Calendar.YEAR);
        if (delta == 0)
            delta = expirationMonth - 1 - calendar.get(Calendar.MONTH);

        return delta <= 0;
    }

    public Boolean isValidPin(String pinCode) {
        return pinCode.contentEquals(this.pinCode);
    }
}
