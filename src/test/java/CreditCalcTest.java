import org.junit.jupiter.api.*;
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

    @AfterEach
    void completeSome(){
        System.out.println();
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
        double confidentTotalAmountPlusPercent = 1_052_208d;
        double overpayment = 52_208d;

        Mockito.when(credit.getTotalAmount()).thenReturn(1_000_000);
        Mockito.when(credit.getPercent()).thenReturn(9.5d);
        Mockito.when(credit.getMonths()).thenReturn(12);

        double totalAmount = creditCalc.totalAmountPlusPercent(credit);
        System.out.println("Общая выплата" + totalAmount);

        assertEquals((overpayment + credit.getTotalAmount()), confidentTotalAmountPlusPercent,
                "Проверка общей суммы кредита с учётом процентов при сумме кредита " + credit.getTotalAmount() +
                        " ,ставке " + credit.getPercent() +
                        " на " + credit.getMonths() + " месяцев");
    }

    @Test
    public void overpayment() {
        BigDecimal monthlyPayment = new BigDecimal("87684.0");
        BigDecimal confidentlyOverpayment = new BigDecimal("52208.0");

        Mockito.when(credit.getTotalAmount()).thenReturn(1_000_000);
        Mockito.when(credit.getPercent()).thenReturn(9.5d);
        Mockito.when(credit.getMonths()).thenReturn(12);

        double overpayment = creditCalc.overpayment(credit);
        System.out.println("Переплата : " + overpayment);

        assertEquals(confidentlyOverpayment.compareTo(BigDecimal.valueOf(overpayment)), 0,
                "Проверка переплаты при сумме кредита " + credit.getTotalAmount() +
                        ", ежемесячном платеже " + monthlyPayment + " ,ставке " + credit.getPercent() +
                        " на " + credit.getMonths() + " месяцев");
    }
}
