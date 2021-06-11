package su.petrovich.JavaLearning.ATM.Processing.Entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "clients")
@NoArgsConstructor
@Data
@Accessors(chain = true)

public class Client {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    //@Basic (fetch = FetchType.LAZY).
    private String firstName;
    private String lastName;
    private String holderName;

    @OneToMany(mappedBy = "clientId"/*, fetch = FetchType.EAGER*/)
    private Set<Account> accounts;

//    @OneToMany(mappedBy = "client_id")
//    private Set<Card> cards;
}
