package DataTest;

import org.bankSystem.account.AbstractAccount;
import org.bankSystem.account.Credit;
import org.bankSystem.account.Debit;
import org.bankSystem.bank.Bank;
import org.bankSystem.client.Client;
import org.bankSystem.data.Data;
import org.bankSystem.data.IoService;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class IoServiceTest {
    static Credit credit;
    static Debit debit;
    static Client client1;
    static Client client2;
    static Map<String, Client> RUNTIME_DATA_TEST = new HashMap<>();
    static Map<String, AbstractAccount> ACCOUNT_DATA_TEST = new HashMap<>();
    static Map<String, Bank> BANKS_TEST = new HashMap<>();

    static Map<String, Client> RUNTIME_DATA_KEEP = new HashMap<>();
    static Map<String, AbstractAccount> ACCOUNT_DATA_KEEP = new HashMap<>();
    static Map<String, Bank> BANKS_KEEP = new HashMap<>();


    @BeforeEach
    public void makeStartConditions() {

        RUNTIME_DATA_TEST.clear();
        ACCOUNT_DATA_TEST.clear();
        BANKS_TEST.clear();

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

    @BeforeAll
    public static void takeData() {
        Data.takeData();
        RUNTIME_DATA_KEEP = Data.RUNTIME_DATA;
        ACCOUNT_DATA_KEEP = Data.ACCOUNT_DATA;
        BANKS_KEEP = Data.BANKS;
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

    @AfterAll
    public static void saveData() {
        Data.RUNTIME_DATA.clear();
        Data.ACCOUNT_DATA.clear();
        Data.BANKS.clear();

        List<String> keys1 = new ArrayList<>(RUNTIME_DATA_KEEP.keySet());

        for (String key : keys1) {
            Client value = RUNTIME_DATA_KEEP.get(key);
            Data.RUNTIME_DATA.put(key, value);
        }

        List<String> keys2 = new ArrayList<>(ACCOUNT_DATA_KEEP.keySet());

        for (String key : keys2) {
            AbstractAccount value = ACCOUNT_DATA_KEEP.get(key);
            Data.ACCOUNT_DATA.put(key, value);
        }

        List<String> keys3 = new ArrayList<>(BANKS_KEEP.keySet());

        for (String key : keys3) {
            Bank value = BANKS_KEEP.get(key);
            Data.BANKS.put(key, value);
        }


        Data.saveData("all");
    }
}
