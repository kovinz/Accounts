package com.company.Decorators;

import com.company.Accounts.GeneralAccount;
import com.company.Accounts.Account;
import com.company.Clients.Client;

public class AccountDecorator implements Account {
  protected Account wrappee;

  public AccountDecorator(Account wrappee) {
    this.wrappee = wrappee;
  }

  @Override
  public void withdraw(double money) {
    wrappee.withdraw(money);
  }

  @Override
  public void replenish(double money) {
    wrappee.replenish(money);
  }

  @Override
  public void transfer(Account generalAccountToTransfer, double money) {
    wrappee.transfer(generalAccountToTransfer, money);
  }

  @Override
  public double getMoney(){
    return wrappee.getMoney();
  }

  @Override
  public Client getClient(){
    return wrappee.getClient();
  }
}
