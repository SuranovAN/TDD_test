import java.math.BigDecimal;

public class CreditCalc implements ICreditCalc{
    private final Credit credit;

    public CreditCalc(Credit credit) {
        this.credit = credit;
    }


    @Override
    public BigDecimal monthlyPayment(Credit credit) {
        return null;
    }

    @Override
    public BigDecimal totalAmountPlusPercent(Credit credit) {
        return null;
    }

    @Override
    public BigDecimal overpayment(Credit credit) {
        return null;
    }
}
