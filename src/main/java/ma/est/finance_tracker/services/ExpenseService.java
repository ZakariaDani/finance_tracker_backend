package ma.est.finance_tracker.services;

import ma.est.finance_tracker.dtos.ExpenseDto;
import ma.est.finance_tracker.exceptions.ExpenseNotFoundException;
import ma.est.finance_tracker.models.Expense;
import ma.est.finance_tracker.models.PaymentMethod;
import ma.est.finance_tracker.models.User;
import ma.est.finance_tracker.repositories.ExpenseRepository;
import ma.est.finance_tracker.repositories.PaymentMethodRepository;
import ma.est.finance_tracker.repositories.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ExpenseService {
    private final ExpenseRepository expenseRepository;
    private final PaymentMethodRepository paymentMethodRepository;
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;

    public ExpenseService(ExpenseRepository expenseRepository, PaymentMethodRepository paymentMethodRepository, UserRepository userRepository, ModelMapper modelMapper) {
        this.expenseRepository = expenseRepository;
        this.paymentMethodRepository = paymentMethodRepository;
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
    }

    public ExpenseDto createExpense(ExpenseDto expenseDto) {
        Expense expense = getExpense(expenseDto);
        PaymentMethod paymentMethod = paymentMethodRepository.findByName(expenseDto.getPaymentMethodName()).orElseThrow();
        expense.setPaymentMethod(paymentMethod);
        User user = userRepository.findById(expenseDto.getUserId()).orElseThrow();
        expense.setUser(user);
        Expense createdExpense = expenseRepository.save(expense);
        return getExpenseDto(createdExpense);
    }

    public ExpenseDto updateExprense(Long ExpenseId, ExpenseDto expenseDto){
        Expense exiteExpense = expenseRepository.findById(ExpenseId).orElseThrow();
        exiteExpense.setDate(expenseDto.getDate());
        exiteExpense.setAmount(expenseDto.getAmount());
        PaymentMethod paymentMethod = paymentMethodRepository.findByName(expenseDto.getPaymentMethodName()).orElseThrow();
        exiteExpense.setPaymentMethod(paymentMethod);
        User user = userRepository.findById(expenseDto.getUserId()).orElseThrow();
        exiteExpense.setUser(user);
        return getExpenseDto(expenseRepository.save(exiteExpense));
    }

    public List<ExpenseDto> getAllExpenseByUse(Long userId) {
        User user = userRepository.findById(userId).orElseThrow();
        List<ExpenseDto> expenses = expenseRepository.findByUserOrderByDateDesc(user)
                .stream()
                .map(this::getExpenseDto)
                .collect(Collectors.toList());
        return expenses;
    }

    public void deleteById(Long id) {
        expenseRepository.findById(id).orElseThrow(ExpenseNotFoundException::new);
        expenseRepository.deleteById(id);
    }

    private ExpenseDto getExpenseDto(Expense createdExpense) {
        return modelMapper.map(createdExpense, ExpenseDto.class);
    }

    private Expense getExpense(ExpenseDto expenseDto) {
        return modelMapper.map(expenseDto, Expense.class);
    }

}
