package su.petrovich.JavaLearning.ATM.Processing.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import su.petrovich.JavaLearning.ATM.Processing.Entity.Client;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {
}
