package org.bankSystem.data;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import java.io.File;
import java.io.IOException;
import org.bankSystem.account.AccountsList;
import org.bankSystem.bank.BanksList;
import org.bankSystem.client.ClientsList;

/** Converter class */
public final class Converter {
    /** Clients data */
    private static final String BASEFILE1 = "ClientsData.json";
    /** Accounts data */
    private static final String BASEFILE2 = "AccountsData.json";
    /** Banks data */
    private static final String BASEFILE3 = "BanksData.json";

    /** Empty constructor */
    private Converter() {
    }

    /** Converts client object to json file */
    public static void toJSONClient(final ClientsList clientsList) throws IOException {
        ObjectMapper mapper = new ObjectMapper();

        mapper.configure(SerializationFeature.INDENT_OUTPUT, true);
        mapper.writeValue(new File(BASEFILE1), clientsList);
    }

    /** Converts json file to client object */
    public static ClientsList toJavaObjectClient() throws IOException {
        ObjectMapper mapper = new ObjectMapper();

        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        return mapper.readValue(new File(BASEFILE1),
                ClientsList.class);
    }

    /** Converts account object to json file */
    public static void toJSONAccount(final AccountsList accountsList) throws IOException {
        ObjectMapper mapper = new ObjectMapper();

        mapper.configure(SerializationFeature.INDENT_OUTPUT, true);
        mapper.writeValue(new File(BASEFILE2), accountsList);
    }

    /** Converts json file to account object */
    public static AccountsList toJavaObjectAccount() throws IOException {
        ObjectMapper mapper = new ObjectMapper();

        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        return mapper.readValue(new File(BASEFILE2),
                AccountsList.class);
    }

    /** Converts bank object to json file */
    public static void toJSONBank(final BanksList banksList) throws IOException {
        ObjectMapper mapper = new ObjectMapper();

        mapper.configure(SerializationFeature.INDENT_OUTPUT, true);
        mapper.writeValue(new File(BASEFILE3), banksList);
    }

    /** Converts json file to bank object */
    public static BanksList toJavaObjectBank() throws IOException {
        ObjectMapper mapper = new ObjectMapper();

        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        return mapper.readValue(new File(BASEFILE3),
                BanksList.class);
    }
}
