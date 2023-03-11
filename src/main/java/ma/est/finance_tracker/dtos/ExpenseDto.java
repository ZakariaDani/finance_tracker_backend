package ma.est.finance_tracker.dtos;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ExpenseDto {

    private Long id;

    @Min(value = 10, message = "value must be greater than 10")
    private double amount;
    private LocalDate date;

    private String paymentMethodName;

    private Long userId;

}
