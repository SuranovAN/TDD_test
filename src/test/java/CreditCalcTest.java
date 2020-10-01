import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

public class CreditCalcTest {
    @Mock
    Credit credit = new Credit();
    CreditCalc creditCalc = new CreditCalc(credit);

    @BeforeAll
    static void init() {
        System.out.println("Starting tests!");
    }

    @BeforeEach
    void initTest() {
        System.out.println("Start new test");
    }

    @AfterAll
    static void completeTests() {
        System.out.println("Tests complete");
    }

    @Test
    public void testMonthlyPayment() {
        BigDecimal confidentlyMonthlyPayment = new BigDecimal("2.5");
        BigDecimal monthlyPayment = creditCalc.monthlyPayment(credit);
        assertEquals(confidentlyMonthlyPayment.compareTo(monthlyPayment), 0,
                "Проверка ежемесячного платежа при сумме кредита " + credit.getTotalAmount() +
                        ", на " + credit.getMonths() + " месяцев, при ставке " + credit.getPercent());
    }

    @Test
    public void totalAmountPlusPercent() {
        BigDecimal confidentTotalAmountPlusPercent = new BigDecimal("12.5");
        BigDecimal totalAmount = creditCalc.totalAmountPlusPercent(credit);
        BigDecimal overpayment = new BigDecimal("1.5");
        assertEquals(confidentTotalAmountPlusPercent.compareTo(totalAmount.add(overpayment)), 0,
                "Проверка общей суммы кредита с учётом процентов при сумме кредита" + credit.getTotalAmount() +
                        " ,ставке" + credit.getPercent() +
                        " на" + credit.getMonths() + " месяцев");
    }

    @Test
    public void overpayment() {
        BigDecimal monthlyPayment = new BigDecimal("5.6");
        BigDecimal confidentlyOverpayment = new BigDecimal("6.5");
        BigDecimal overpayment = creditCalc.overpayment(credit);
        assertEquals(confidentlyOverpayment.compareTo(overpayment), 0,
                "Проверка переплаты при сумме кредита " + credit.getTotalAmount() +
                        ", ежемесячном платеже" + monthlyPayment + " ,ставке" + credit.getPercent() +
                        " на" + credit.getMonths() + " месяцев");
    }
}
