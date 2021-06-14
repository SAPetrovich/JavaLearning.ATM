package su.petrovich.JavaLearning.ATM.Processing.Repository;

import org.springframework.data.repository.CrudRepository;
import su.petrovich.JavaLearning.ATM.Processing.Entity.Client;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends CrudRepository<Client, Long> {
}
