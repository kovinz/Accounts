package com.company.Accounts;

import com.company.Clients.Client;

public abstract class GeneralAccount implements Account {
  private double money;
  private Client client;

  public GeneralAccount(double money, Client client) {
    this.money = money;
    this.client = client;
  }

  @Override
  public void withdraw(double money){
    this.money -= money;
  };

  @Override
  public void replenish(double money){
    this.money += money;
  };

  @Override
  public void transfer(Account generalAccountToTransfer, double money){
    if ((this != generalAccountToTransfer) && (this.getClient() == generalAccountToTransfer.getClient())){
      this.withdraw(money);
      generalAccountToTransfer.replenish(money);
    }
  };

  @Override
  public double getMoney() {
    return money;
  }

  public Client getClient() {
    return client;
  }
}
