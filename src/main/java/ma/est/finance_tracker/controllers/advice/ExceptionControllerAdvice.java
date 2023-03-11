package ma.est.finance_tracker.controllers.advice;

import ma.est.finance_tracker.exceptions.ExpenseNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
public class ExceptionControllerAdvice {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorDetails> expenseNotFoundExceptionHandler(MethodArgumentNotValidException ex) {
        ErrorDetails errorDetails = ErrorDetails.builder()
                .timestamp(LocalDateTime.now())
                .message(ex.getFieldError().getDefaultMessage())
                .build();

        return ResponseEntity.badRequest()
                .body(errorDetails);
    }

    @ExceptionHandler(ExpenseNotFoundException.class)
    public ResponseEntity<ErrorDetails> expenseNotFoundExceptionHandler(ExpenseNotFoundException ex) {
        ErrorDetails errorDetails = ErrorDetails.builder()
                .timestamp(LocalDateTime.now())
                .message(ex.getMessage())
                .build();

        return ResponseEntity.badRequest()
                .body(errorDetails);
    }
}
