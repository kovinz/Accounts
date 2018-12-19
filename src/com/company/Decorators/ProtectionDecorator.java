package com.company.Decorators;

import com.company.Accounts.Account;
import com.company.Clients.Client;

public class ProtectionDecorator extends AccountDecorator {
  public ProtectionDecorator(Account wrappee) {
    super(wrappee);
  }

  @Override
  public void withdraw(double money){
    Client client = wrappee.getClient();
    if (((client.getAddress() != null) && (client.getPassportId() != null)) || money < 1000){
      wrappee.withdraw(money);
    }
  }
}
