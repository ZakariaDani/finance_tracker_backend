package ma.est.finance_tracker.controllers;

import jakarta.validation.Valid;
import ma.est.finance_tracker.dtos.ExpenseDto;
import ma.est.finance_tracker.services.ExpenseService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/expenses")
public class ExpenseController {
    private final ExpenseService expenseService;

    public ExpenseController(ExpenseService expenseService) {
        this.expenseService = expenseService;
    }

    @GetMapping("{userId}")
    public ResponseEntity<List<ExpenseDto>> getExpensesByUserId(@PathVariable Long userId) {
       return ResponseEntity.ok(expenseService.getAllExpenseByUse(userId));
    }

    @PutMapping("{id}")
    public ResponseEntity<ExpenseDto> updateExpense(@PathVariable Long id, @RequestBody @Valid ExpenseDto req){
        return ResponseEntity.ok(expenseService.updateExprense(id,req));
    }

    @PostMapping
    public ResponseEntity<ExpenseDto> createExpense(@RequestBody @Valid ExpenseDto expenseDto) {
        ExpenseDto createdDto =expenseService.createExpense(expenseDto);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(createdDto);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        expenseService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
