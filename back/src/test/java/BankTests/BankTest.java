package BankTests;

import org.bankSystem.bank.Bank;
import org.bankSystem.bank.BankService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class BankTest {

    Bank bank;

    @BeforeEach
    public void createBank() {
        bank = new Bank("VTB", "aaa", 1000000, 0.5);
        List<String> accounts = new ArrayList<>();
        accounts.add("aVTBdebit");
        accounts.add("aVTBcredit");
        bank.setAccounts(accounts);
    }

    @Test
    public void testSeeAccounts() {
        BankService.seeAccounts(bank);

        PrintStream stream = mock(PrintStream.class);
        ArgumentCaptor<String> captor = ArgumentCaptor.forClass(String.class);
        System.setOut(stream);

        String params = "aVTBdebit\n" + "aVTBcredit";
        System.out.println(params);

        verify(stream).println(captor.capture());
        assertEquals(captor.getValue(), params);
    }

    @Test
    public void testSeeInformation() {
        BankService.seeInformation(bank);

        PrintStream stream = mock(PrintStream.class);
        ArgumentCaptor<String> captor = ArgumentCaptor.forClass(String.class);
        System.setOut(stream);

        String params = "bank: " + "VTB\n" + "registration number: "
                + "aaa\n" + "credit limit: " + "1000000\n" + "fee: " + "0.5";
        System.out.println(params);

        verify(stream).println(captor.capture());
        assertEquals(captor.getValue(), params);
    }


}
