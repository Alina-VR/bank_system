package BankTests;

import org.bankSystem.bank.Bank;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class BankTest {

    static Bank bank;

    @BeforeAll
    public static void createBank() {
        bank = new Bank("VTB", "aaa", 100, 0.5);
    }

    @Test
    public void testToString() {


        bank.toString();

        PrintStream stream = mock(PrintStream.class);
        ArgumentCaptor<String> captor = ArgumentCaptor.forClass(String.class);
        System.setOut(stream);

        String params = "VTB " + "aaa " + "100 " + "0.5";
        System.out.println(params);

        verify(stream).println(captor.capture());
        assertEquals(captor.getValue(), params);
    }
}