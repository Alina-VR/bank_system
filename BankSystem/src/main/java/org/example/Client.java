package org.example;

import java.util.ArrayList;

public class Client extends AbstractClient {

    public Client(String userName, String userSurname, String address, String passport, String login, String password, ArrayList<String> accounts) {
        super(userName, userSurname, address, passport, login, password, accounts);
    }

    public Client(){ }

    ////@Override
   /// public String setID(String userName, String userSurname, String passport) {
       //// return null;
    ////}

}


