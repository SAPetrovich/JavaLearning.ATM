package su.petrovich.JavaLearning.ATM.Processing.repository;

import su.petrovich.JavaLearning.ATM.Processing.Entity.Card;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CardRepository extends CrudRepository<Card, Long> {
}
