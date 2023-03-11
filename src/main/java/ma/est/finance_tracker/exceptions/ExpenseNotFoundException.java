package ma.est.finance_tracker.exceptions;

public class ExpenseNotFoundException extends RuntimeException{
    private final static String MESSAGE ="NO EXPENSE XITH PROVIDED ID IS FOUND";

    public ExpenseNotFoundException() {
        super(MESSAGE);
    }
}
