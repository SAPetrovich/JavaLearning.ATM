package su.petrovich.JavaLearning.ATM.Processing.Entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
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

    @Column(name = "number", length = 20, unique = true, nullable = false)
    private String number;

    @Column(name = "balance", nullable = false)
    private BigInteger balance;

    @Column(name = "currencyCode", length = 3, nullable = false)
    private String currencyCode;

    @ManyToOne
    @JoinColumn(name = "client_id", nullable = false)
    private Client client;

    @OneToMany(mappedBy = "account", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @ToString.Exclude
    private Set<Card> cards;

}
