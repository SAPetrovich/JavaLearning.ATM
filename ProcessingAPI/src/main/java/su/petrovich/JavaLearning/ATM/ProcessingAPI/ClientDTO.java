package su.petrovich.JavaLearning.ATM.ProcessingAPI;

import lombok.AllArgsConstructor;
import lombok.ToString;
import lombok.Value;

import javax.persistence.OneToMany;
import java.util.Set;

@Value
public class ClientDTO {

    String firstName;
    String lastName;
}

