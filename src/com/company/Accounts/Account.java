package com.company.Accounts;

import com.company.Clients.Client;

public interface Account {
  void withdraw(double money);
  void replenish(double money);
  void transfer(Account generalAccountToTransfer, double money);
  double getMoney();
  Client getClient();
}
