package ma.est.finance_tracker.repositories;

import ma.est.finance_tracker.models.Expense;
import ma.est.finance_tracker.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface ExpenseRepository extends JpaRepository<Expense, Long> {
    List<Expense> findByUserOrderByDateDesc(User user);


}
