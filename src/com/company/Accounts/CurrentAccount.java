package com.company.Accounts;

import com.company.Clients.Client;

public class CurrentAccount extends GeneralAccount {
  private double percent;

  public CurrentAccount(double money, Client client, double percent) {
    super(money, client);
    this.percent = percent;
  }

  @Override
  public void withdraw(double money){
    if (this.getMoney() >= money){
      super.withdraw(money);
    }
    else{
      System.out.println("Not enough money on account.");
    }
  }

  public void addPercent(){
    replenish(getMoney() * percent/100);
  }
}
