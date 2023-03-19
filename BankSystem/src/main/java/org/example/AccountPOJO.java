package org.example;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;


@Setter
@Getter
public class AccountPOJO {
    @JsonProperty("ID")
    String ID;
    @JsonProperty("login")
    String login;
    @JsonProperty("bankName")
    String bankName;
    @JsonProperty("accountType")
    String accountType;
    @JsonProperty("balance")
    int balance;

    public AccountPOJO() { }


    public AccountPOJO(Account account) {
        this.ID = account.getID();
        this.login = account.getLogin();
        this.bankName = account.getBankName();
        this.accountType = account.getAccountType();
        this.balance = account.getBalance();
    }


}
