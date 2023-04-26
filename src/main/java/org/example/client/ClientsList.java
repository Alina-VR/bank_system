package org.example.client;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.ArrayList;
import java.util.List;

public class ClientsList {
    @JsonProperty("Clients")
    private List<Client> clients;

    public ClientsList(final List<Client> clients) {
        this.clients = clients;
    }

    public ClientsList() {
        clients = new ArrayList<>();
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();

        for (Client client : getClients()) {
            stringBuilder.append(client.toString());
        }

        return String.valueOf(stringBuilder);
    }

    public List<Client> toClientsArray() {
        return new ArrayList<>(clients);
    }

    public List<Client> getClients() {
        return clients;
    }

    public void setClients(final List<Client> clients) {
        this.clients = clients;
    }
}
