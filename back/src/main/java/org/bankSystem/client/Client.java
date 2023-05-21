package org.bankSystem.client;

/** Not abstract client */
public class Client extends AbstractClient {
    /** Constructor */
    public Client(final String userName, final String userSurname,
                  final String address, final String passport,
                  final String login, final String password) {
        super(userName, userSurname, address, passport, login, password);
    }

    /** Empty constructor */
    public Client() {
    }
}
