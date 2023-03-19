package org.example;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
@Getter
@Setter
public class ArrayAccountsPOJO {
    @JsonProperty("Accounts")
    List<AccountPOJO> accounts;

    public ArrayAccountsPOJO() { }


    public ArrayAccountsPOJO(List<AccountPOJO> accounts) {
        this.accounts = accounts;
    }


    public List<Account> toAccountsArray() {
        List<Account> array = new ArrayList<>();
        for (AccountPOJO account:
                accounts) {
            array.add(Account.toAccount(account));
        }
        return array;
    }

    ///@Override
//    public String toString() {
//        StringBuilder stringBuilder = new StringBuilder("");
//        for (Account account:
//                accounts) {
//            stringBuilder.append(account.toString());
//
//        }
//        return String.valueOf(stringBuilder);
//    }

}

