package ma.est.finance_tracker.dtos;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class IncomeDto {

    private Long id;

    private double amount;
    private LocalDate date;
    private String source;


    private Long userId;

}
