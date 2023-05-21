package org.bankSystem.client;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.ArrayList;
import java.util.List;

/** Client list class */
public class ClientsList {
    /** List of clients */
    @JsonProperty("Clients")
    private List<Client> clients;

    /** Constructor */
    public ClientsList(final List<Client> clients) {
        this.clients = clients;
    }

    /** Empty constructor */
    public ClientsList() {
        clients = new ArrayList<>();
    }

    /** This method give a string interpretation of the client list */
    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();

        for (Client client : getClients()) {
            stringBuilder.append(client.toString());
        }

        return String.valueOf(stringBuilder);
    }

    /** Change list structure */
    public List<Client> toClientsArray() {
        return new ArrayList<>(clients);
    }

    /** Clients list getter */
    public List<Client> getClients() {
        return clients;
    }

    /** Clients list setter */
    public void setClients(final List<Client> clients) {
        this.clients = clients;
    }
}
