package su.petrovich.JavaLearning.ATM.Processing.repository;

import su.petrovich.JavaLearning.ATM.Processing.Entity.Account;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends CrudRepository<Account, Long> {
}
