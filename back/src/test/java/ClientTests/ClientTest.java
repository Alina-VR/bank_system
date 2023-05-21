package ClientTests;

import org.bankSystem.client.Client;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class ClientTest {

    static Client client;

    @BeforeAll
    public static void createClient() {
        client = new Client("a", "a", "a", "0", "a", "a");
    }

    @Test
    public void testToString() {


        client.toString();

        PrintStream stream = mock(PrintStream.class);
        ArgumentCaptor<String> captor = ArgumentCaptor.forClass(String.class);
        System.setOut(stream);

        String params = "User name: a, User Surname: a, Address: a, Passport: 0, Login: a, Password: a";
        System.out.println(params);

        verify(stream).println(captor.capture());
        assertEquals(captor.getValue(), params);
    }
}
