package su.petrovich.JavaLearning.ATM.Processing.Repository;

import org.springframework.data.repository.CrudRepository;
import su.petrovich.JavaLearning.ATM.Processing.Entity.Account;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends CrudRepository<Account, Long> {
}
