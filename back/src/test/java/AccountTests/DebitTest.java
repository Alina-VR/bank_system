package AccountTests;

import org.bankSystem.account.Debit;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class DebitTest {
    Debit debit;

    @BeforeEach
    public void makeDebit() {
        debit = new Debit("aa", "SberBank", "debit", 1000);
    }

    @Test
    public void testDebitPush(){
        debit.push(500);
        assertEquals(1500, debit.getBalance());
    }

    @Test
    public void testDebitWithdrawSumThatLessThenBalance() {
        debit.withdraw(500);
        assertEquals(500, debit.getBalance());
    }

    @Test
    public void testDebitWithdrawMoreThenBalance() {
        debit.withdraw(999900);
        assertEquals(0, debit.getBalance());
    }
}
