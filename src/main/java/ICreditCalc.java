import java.math.BigDecimal;

public interface ICreditCalc {
    public BigDecimal monthlyPayment(Credit credit);

    public BigDecimal totalAmountPlusPercent(Credit credit);

    public BigDecimal overpayment(Credit credit);
}
