import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

public class CreditCalcTest {
    @Mock
    Credit credit = Mockito.mock(Credit.class);

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
        BigDecimal confidentlyMonthlyPayment = new BigDecimal("87684.0");

        Mockito.when(credit.getTotalAmount()).thenReturn(1_000_000);
        Mockito.when(credit.getPercent()).thenReturn(9.5d);
        Mockito.when(credit.getMonths()).thenReturn(12);

        int monthlyPayment = creditCalc.monthlyPayment(credit);
        System.out.println("Ежемесячный платёж равен: " + monthlyPayment);

        assertEquals(confidentlyMonthlyPayment.compareTo(BigDecimal.valueOf(monthlyPayment)), 0,
                "Проверка ежемесячного платежа при сумме кредита " + credit.getTotalAmount() +
                        ", на " + credit.getMonths() + " месяцев, при ставке " + credit.getPercent());
    }

    @Test
    public void totalAmountPlusPercent() {
        double confidentTotalAmountPlusPercent = 1_052_208;
        double totalAmount = creditCalc.totalAmountPlusPercent(credit);
        double overpayment = 1.5;

        Mockito.when(credit.getTotalAmount()).thenReturn(1_000_000);
        Mockito.when(credit.getPercent()).thenReturn(9.5d);
        Mockito.when(credit.getMonths()).thenReturn(12);

        assertEquals((overpayment + totalAmount), confidentTotalAmountPlusPercent,
                "Проверка общей суммы кредита с учётом процентов при сумме кредита" + credit.getTotalAmount() +
                        " ,ставке" + credit.getPercent() +
                        " на" + credit.getMonths() + " месяцев");
    }

    @Test
    public void overpayment() {
        BigDecimal monthlyPayment = new BigDecimal("5.6");
        BigDecimal confidentlyOverpayment = new BigDecimal("6.5");

        Mockito.when(credit.getTotalAmount()).thenReturn(1_000_000);
        Mockito.when(credit.getPercent()).thenReturn(9.5d);
        Mockito.when(credit.getMonths()).thenReturn(12);

        double overpayment = creditCalc.overpayment(credit);
        assertEquals(confidentlyOverpayment.compareTo(BigDecimal.valueOf(overpayment)), 0,
                "Проверка переплаты при сумме кредита " + credit.getTotalAmount() +
                        ", ежемесячном платеже" + monthlyPayment + " ,ставке" + credit.getPercent() +
                        " на" + credit.getMonths() + " месяцев");
    }
}
