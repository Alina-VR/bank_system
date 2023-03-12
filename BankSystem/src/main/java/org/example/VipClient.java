package org.example;

class VipClient extends AbstractClient{
    public VipClient(String userName, String userSurname, String address, String passport, String login, String password) {
        super(userName, userSurname, address, passport, login, password);
    }

    @Override
    public String setID(String userName, String userSurname, String passport) {
        return passport;
    }
}

