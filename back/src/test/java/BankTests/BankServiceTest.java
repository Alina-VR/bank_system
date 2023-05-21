package BankTests;

import org.bankSystem.account.Credit;
import org.bankSystem.account.Debit;
import org.bankSystem.bank.Bank;
import org.bankSystem.bank.BankService;
import org.bankSystem.client.Client;
import org.bankSystem.data.Data;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class BankServiceTest {

    static Bank bank;
    static Debit debit;
    static Credit credit;
    static Client client;

    @BeforeAll
    public static void createBank() {
        bank = new Bank("VTB", "aaa", 1000000, 0.5);
        List<String> accounts = new ArrayList<>();
        debit = new Debit("a", "VTB", "debit", false, 100);
        credit = new Credit("a", "VTB", "credit", true, 100, 1000000, 0.5);
        client = new Client("a", "a", "a", "0", "a", "a");
        accounts.add("aVTBdebit");
        accounts.add("aVTBcredit");
        bank.setAccounts(accounts);
        client.setAccounts(accounts);
        Data.ACCOUNT_DATA.clear();
        Data.BANKS.clear();
        Data.RUNTIME_DATA.clear();
        Data.BANKS.put("VTB", bank);
        Data.RUNTIME_DATA.put("a", client);
        Data.ACCOUNT_DATA.put("aVTBdebit", debit);
        Data.ACCOUNT_DATA.put("aVTBcredit", credit);
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

    @Test
    public void testSeeAccountInformation() {
        BankService.seeAccountInformation("aVTBdebit");

        PrintStream stream = mock(PrintStream.class);
        ArgumentCaptor<String> captor = ArgumentCaptor.forClass(String.class);
        System.setOut(stream);

        String params = "Account type: " + "debit\n" + "Balance: "
                + "100\n" + "Client: " + "a" + " " + "a";
        System.out.println(params);

        verify(stream).println(captor.capture());
        assertEquals(captor.getValue(), params);
    }

    @Test
    public void testSuspendAccount() {
        assertTrue(credit.getActive());
        BankService.suspendAccount("aVTBcredit");

        assertFalse(credit.getActive());
    }

    @Test
    public void testUnlockAccount() {
        assertFalse(debit.getActive());
        BankService.unlockAccount("aVTBdebit");

        assertTrue(debit.getActive());
    }

    @Test
    public void testAssignDebt() {
        assertEquals(credit.getCreditDebt(), 100);
        BankService.assignDebt("aVTBcredit");
        assertEquals(credit.getCreditDebt(), 150);
    }

    @AfterAll
    public static void clear() {
        Data.ACCOUNT_DATA.clear();
        Data.BANKS.clear();
        Data.RUNTIME_DATA.clear();
    }

}
