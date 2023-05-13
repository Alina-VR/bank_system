package AccountTests;

import org.bankSystem.account.Credit;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


public class CreditTest {
    Credit credit;

    @BeforeEach
    public void makeCredit() {
        credit = new Credit("aaa", "VTB", "credit", 1000, 1000000, 0);
    }

    @Test
    public void testCreditPushSumLessThenDebt(){
        credit.push(500);
        assertEquals(500, credit.getCreditDebt());
    }

    @Test
    public void testCreditPushSumMoreThenDebt(){
        credit.push(1500);
        assertEquals(0, credit.getCreditDebt());
    }

    @Test
    public void testCreditPushWithoutDebt(){
        credit.setCreditDebt(0);
        credit.push(500);
        assertEquals(0, credit.getCreditDebt());
    }

    @Test
    public void testCreditWithdrawSumThatWithDebtLessThenCreditLimit() {
        credit.withdraw(500);
        assertEquals(1500, credit.getCreditDebt());
    }

    @Test
    public void testCreditWithdrawSumWithDebtMoreThenLimit() {
        credit.withdraw(999900);
        assertEquals(1000000, credit.getCreditDebt());
    }

    @Test
    public void testCreditWithdrawDebtEqualLimit(){
        credit.setCreditDebt(1000000);
        credit.withdraw(1000);
        assertEquals(1000000, credit.getCreditDebt());
    }
}
