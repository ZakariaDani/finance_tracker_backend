package ma.est.finance_tracker.repositories;

import ma.est.finance_tracker.models.Expense;
import ma.est.finance_tracker.models.Income;
import ma.est.finance_tracker.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IncomeRepository extends JpaRepository<Income, Long> {
    Income findByUserOrderByDateDesc(User user);
}
