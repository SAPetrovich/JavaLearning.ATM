package su.petrovich.JavaLearning.ATM.Processing.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import su.petrovich.JavaLearning.ATM.Processing.Entity.Account;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {
}
