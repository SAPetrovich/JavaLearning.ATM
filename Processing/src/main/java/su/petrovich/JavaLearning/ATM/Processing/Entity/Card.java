package su.petrovich.JavaLearning.ATM.Processing.Entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.time.LocalDate;
import java.time.temporal.TemporalAdjusters;

@Entity
@Table(name = "cards")
@NoArgsConstructor
@Data
public class Card {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @Column(name = "number", unique = true, nullable = false)
    private String number; // Обычно 16..18 цифр

    @Column(name = "holderName", length = 50, unique = true, nullable = false)
    private String holderName; // латинские буквы и пробел

    @Column(name = "expirationDate", nullable = false)
    private LocalDate expirationDate; // месяц окончания срока действия карты (день игнорируется, и подразумевается последний)

    @Column(name = "pinCode", nullable = false)
    private String pinCode; // Обычно 4..6 цифр

    @Column(name = "securityCode", nullable = false)
    private String securityCode; // CVC2/CVV2 код 3 цифры

    @ManyToOne
    @JoinColumn(nullable = false)
    private Client client;

    @ManyToOne
    @JoinColumn(nullable = false)
    private Account account;

    public Boolean isNotExpired() {
        return !expirationDate.with(TemporalAdjusters.lastDayOfMonth()).isBefore(LocalDate.now());
    }

    public Boolean isValidPin(String pinCode) {
        return pinCode.contentEquals(this.pinCode);
    }
}
