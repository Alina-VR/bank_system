package DataTest;

import org.example.account.AbstractAccount;
import org.example.account.Credit;
import org.example.account.Debit;
import org.example.bank.Bank;
import org.example.client.Client;
import org.example.data.Data;
import org.example.data.IoService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class IoServiceTest {
    Credit credit;
    Debit debit;
    Client client1;
    Client client2;
    Map<String, Client> RUNTIME_DATA_TEST = new HashMap<>();
    Map<String, AbstractAccount> ACCOUNT_DATA_TEST = new HashMap<>();
    Map<String, Bank> BANKS_TEST = new HashMap<>();


    @BeforeEach
    public void makeStartConditions() {
        credit = new Credit("a", "VTB", "credit", 1000, 1000000, 0);
        debit = new Debit("a", "VTB", "debit", 1000);
        debit = new Debit("a", "SberBank", "debit", 1000);
        client1 = new Client("a", "b", "moscow", "000", "a", "a");
        client2 = new Client("b", "a", "moscow", "000", "b", "b");

        Data.BANKS.put("VTB", new Bank("VTB", "aaa", 1000000, 0));
        Data.BANKS.put("SberBank", new Bank("SberBank", "bbb", 2000000, 0));

        Data.ACCOUNT_DATA.put("aVTBdebit", new Debit("a", "VTB", "debit", 1000));
        Data.ACCOUNT_DATA.put("aVTBcredit", new Credit("a", "VTB", "credit", 1000, 1000000, 0.5));
        Data.ACCOUNT_DATA.put("aSberBankdebit", new Debit("a", "SberBank", "debit", 1000));

        Data.RUNTIME_DATA.put("a", client1);
        Data.RUNTIME_DATA.put("b", client2);

        BANKS_TEST.put("VTB", new Bank("VTB", "aaa", 1000000, 0));
        BANKS_TEST.put("SberBank", new Bank("SberBank", "bbb", 2000000, 0));

        ACCOUNT_DATA_TEST.put("aVTBdebit", new Debit("a", "VTB", "debit", 1000));
        ACCOUNT_DATA_TEST.put("aVTBcredit", new Credit("a", "VTB", "credit", 1000, 1000000, 0.5));
        ACCOUNT_DATA_TEST.put("aSberBankdebit", new Debit("a", "SberBank", "debit", 1000));

        RUNTIME_DATA_TEST.put("a", client1);
        RUNTIME_DATA_TEST.put("b", client2);
    }

    @Test
    public void testSaveClientsData() {
        IoService.outputClientsData();

        Data.RUNTIME_DATA.clear();

        IoService.inputClientsData();

        List<String> keys1 = new ArrayList<>(Data.RUNTIME_DATA.keySet());

        for (String key : keys1) {
            Client value = Data.RUNTIME_DATA.get(key);
            Client testValue = RUNTIME_DATA_TEST.get(key);
            assertEquals(testValue.toString(), value.toString());
        }
    }

    @Test
    public void testSaveAccountsData() {
        IoService.outputAccountsData();

        Data.ACCOUNT_DATA.clear();

        IoService.inputAccountsData();

        List<String> keys2 = new ArrayList<>(Data.ACCOUNT_DATA.keySet());

        for (String key : keys2) {
            AbstractAccount value = Data.ACCOUNT_DATA.get(key);
            AbstractAccount testValue = ACCOUNT_DATA_TEST.get(key);
            assertEquals(testValue.toString(), value.toString());
        }
    }

    @Test
    public void testSaveBanksData() {
        IoService.outputBanksData();

        Data.BANKS.clear();

        IoService.inputBanksData();

        List<String> keys3 = new ArrayList<>(Data.BANKS.keySet());

        for (String key : keys3) {
            Bank value = Data.BANKS.get(key);
            Bank testValue = BANKS_TEST.get(key);
            assertEquals(testValue.toString(),value.toString());
        }
    }
}
