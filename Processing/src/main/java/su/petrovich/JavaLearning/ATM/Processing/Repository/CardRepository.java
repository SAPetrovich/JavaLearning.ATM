package su.petrovich.JavaLearning.ATM.Processing.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import su.petrovich.JavaLearning.ATM.Processing.Entity.Card;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CardRepository extends JpaRepository<Card, Long> {

    Optional<Card> findByNumber(String cardNumber);
}
