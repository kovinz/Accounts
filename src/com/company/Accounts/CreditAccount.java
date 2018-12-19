package com.company.Accounts;

import com.company.Clients.Client;

public class CreditAccount extends GeneralAccount {
  private double moneyLimit;
  private double commission;

  public CreditAccount(double money, Client client, double moneyLimit, double commission) {
    super(money, client);
    this.moneyLimit = moneyLimit;
    this.commission = commission;
  }

  public void withdrawCommission(){
    super.withdraw(commission);
  }

  @Override
  public void withdraw(double money){
    if ((getMoney() < 0) && (getMoney() > moneyLimit)){
      super.withdraw(money + commission);
    }
    if (getMoney() >= 0){
      super.withdraw(money);
    }
  }
}
