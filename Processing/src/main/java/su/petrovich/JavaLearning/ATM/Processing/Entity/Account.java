package su.petrovich.JavaLearning.ATM.Processing.Entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.math.BigInteger;
import java.util.Set;

@Entity
@Table(name = "accounts")
@NoArgsConstructor
@Data
public class Account {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    private String number;
    private String currencyCode;
    private BigInteger balance;

    @ManyToOne
    @JoinColumn(name = "clientId", nullable = false)
    private Client clientId;

    @OneToMany(mappedBy = "account_id")
    private Set<Card> accounts;

}
