package com.company;

import com.company.Accounts.Account;
import com.company.Accounts.AccountFactory;
import com.company.Clients.Client;
import com.company.Decorators.ProtectionDecorator;
import com.company.Handlers.AccountDecoratorHandler;
import com.company.Handlers.AccountHandler;
import com.company.Handlers.Handler;

public class Main {

  public static void main(String[] args) {
    Client client = Client.newBuilder()
            .withFirstName("Nikola")
            .withSecondName("Kuznetsov")
            .withAddress("Ekaterinburg")
            .build();

    AccountFactory accountFactory = new AccountFactory(10, 20,
            5, 10, 15);

    Account account = accountFactory.getCurrentAccount(15000, client);
    Account account2 = accountFactory.getCreditAccount(0, client, -300000);

    account.withdraw(2000);
    System.out.println("Withdraw 2000 from account:");
    System.out.println(account.getMoney());

    account = new ProtectionDecorator(account);
    account.withdraw(2000);
    System.out.println("Cant withdraw >1000 because client has no passport id");
    System.out.println(account.getMoney());

    Handler handler = new AccountHandler();
    handler.linkWith(new AccountDecoratorHandler());
    handler.request(account);
    System.out.println("Added percents to account");
    System.out.println(account.getMoney());

    account.transfer(account2, 2000);
    System.out.println("Transferred 2000 from one to another account of one client");
    System.out.println(account.getMoney());
    System.out.println(account2.getMoney());
  }
}
