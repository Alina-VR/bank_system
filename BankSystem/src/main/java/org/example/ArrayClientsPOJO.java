package org.example;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;
@Getter
@Setter
public class ArrayClientsPOJO {
    @JsonProperty("Clients")
    List<ClientPOJO> clients;

    public ArrayClientsPOJO() { }


    public ArrayClientsPOJO(List<ClientPOJO> clients) {
        this.clients = clients;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("");
        for (ClientPOJO client:
             clients) {
            stringBuilder.append(client.toString());

        }
        return String.valueOf(stringBuilder);
    }

}

