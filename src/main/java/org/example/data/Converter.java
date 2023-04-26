package org.example.data;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import java.io.File;
import java.io.IOException;
import java.util.Objects;
import org.example.account.AccountsList;
import org.example.bank.BanksList;
import org.example.client.ClientsList;

public final class Converter {
    private static final String BASEFILE1 = "/ClientsData.json";
    private static final String BASEFILE2 = "/AccountsData.json";
    private static final String BASEFILE3 = "/BanksData.json";

    private Converter() {
    }

    public static void toJSONClient(final ClientsList clientsList) throws IOException {
        ObjectMapper mapper = new ObjectMapper();

        mapper.configure(SerializationFeature.INDENT_OUTPUT, true);
        mapper.writeValue(new File("src/main/resources" + BASEFILE1), clientsList);
    }

    public static ClientsList toJavaObjectClient() throws IOException {
        ObjectMapper mapper = new ObjectMapper();

        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        return mapper.readValue(new File(Objects.requireNonNull(Converter.class.getResource(BASEFILE1)).getFile()),
                ClientsList.class);
    }

    public static void toJSONAccount(final AccountsList accountsList) throws IOException {
        ObjectMapper mapper = new ObjectMapper();

        mapper.configure(SerializationFeature.INDENT_OUTPUT, true);
        mapper.writeValue(new File("src/main/resources" + BASEFILE2), accountsList);
    }

    public static AccountsList toJavaObjectAccount() throws IOException {
        ObjectMapper mapper = new ObjectMapper();

        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        return mapper.readValue(new File(Objects.requireNonNull(Converter.class.getResource(BASEFILE2)).getFile()),
                AccountsList.class);
    }

    public static void toJSONBank(final BanksList banksList) throws IOException {
        ObjectMapper mapper = new ObjectMapper();

        mapper.configure(SerializationFeature.INDENT_OUTPUT, true);
        mapper.writeValue(new File("src/main/resources" + BASEFILE3), banksList);
    }

    public static BanksList toJavaObjectBank() throws IOException {
        ObjectMapper mapper = new ObjectMapper();

        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        return mapper.readValue(new File(Objects.requireNonNull(Converter.class.getResource(BASEFILE3)).getFile()),
                BanksList.class);
    }
}


