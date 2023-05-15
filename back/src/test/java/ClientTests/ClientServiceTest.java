package ClientTests;

import org.bankSystem.account.Credit;
import org.bankSystem.account.Debit;
import org.bankSystem.bank.Bank;
import org.bankSystem.client.Client;
import org.bankSystem.client.ClientService;
import org.bankSystem.data.Data;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ClientServiceTest {
    Credit credit;
    Debit debit;
    Client client;

    @BeforeEach
    public void makeStartConditions() {
        credit = new Credit("a", "VTB", "credit", 1000, 1000000, 0);
        debit = new Debit("a", "VTB", "debit", 1000);
        debit = new Debit("a", "SberBank", "debit", 1000);
        client = new Client("a", "b", "moscow", "000", "a", "a");
        Data.BANKS.put("VTB", new Bank("VTB", "aaa", 1000000, 0));
        Data.BANKS.put("SberBank", new Bank("SberBank", "bbb", 2000000, 0));
        Data.ACCOUNT_DATA.put("aVTBdebit", new Debit("a", "VTB", "debit", 1000));
        Data.ACCOUNT_DATA.put("aVTBcredit", new Credit("a", "VTB", "credit", 1000, 1000000, 0.5));
        Data.ACCOUNT_DATA.put("aSberBankdebit", new Debit("a", "SberBank", "debit", 1000));
    }

    @Test
    public void testWorkWithAccountDebitPush() {
        String input = "push 1000";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        ClientService.push("aVTBdebit", 1000);
        assertEquals(2000, ((Debit)Data.ACCOUNT_DATA.get("aVTBdebit")).getBalance());
    }

    @Test
    public void testWorkWithAccountDebitWithdrawLessThenBalance() {
        String input = "withdraw 500";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        ClientService.withdraw("aVTBdebit", 500);
        assertEquals(500, ((Debit)Data.ACCOUNT_DATA.get("aVTBdebit")).getBalance());
    }

    @Test
    public void testWorkWithAccountCreditPushLessThenDebt() {
        String input = "push 500";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        ClientService.push("aVTBcredit", 500);
        assertEquals(500, ((Credit)Data.ACCOUNT_DATA.get("aVTBcredit")).getCreditDebt());
    }

    @Test
    public void testWorkWithAccountCreditWithdrawLessThenLimit() {
        String input = "withdraw 500";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        ClientService.withdraw("aVTBcredit", 500);
        assertEquals(1500, ((Credit)Data.ACCOUNT_DATA.get("aVTBcredit")).getCreditDebt());
    }

    @Test
    public void testWorkWithAccountDebitTransfer() {
        String input = "transfer aSberBankdebit 500";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        ClientService.transfer("aVTBdebit", "aSberBankdebit", 500);
        assertEquals(1500, ((Debit)Data.ACCOUNT_DATA.get("aSberBankdebit")).getBalance());
    }


}
