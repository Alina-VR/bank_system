package org.example.client;

public class Client extends AbstractClient {
    public Client(final String userName, final String userSurname,
                  final String address, final String passport,
                  final String login, final String password) {
        super(userName, userSurname, address, passport, login, password);
    }

    public Client() {
    }
}



