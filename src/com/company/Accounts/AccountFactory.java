package com.company.Accounts;

import com.company.Clients.Client;
import com.company.Decorators.ProtectionDecorator;

import java.util.Calendar;

public class AccountFactory {
  private double percentForCurrentAccount;
  private double commission;
  private double smallPercentForDepositAccount;
  private double mediumPercentForDepositAccount;
  private double bigPercentForDepositAccount;

  public AccountFactory(double percentForCurrentAccount, double commission, double smallPercentForDepositAccount,
                        double mediumPercentForDepositAccount, double bigPercentForDepositAccount) {
    this.percentForCurrentAccount = percentForCurrentAccount;
    this.commission = commission;
    this.smallPercentForDepositAccount = smallPercentForDepositAccount;
    this.mediumPercentForDepositAccount = mediumPercentForDepositAccount;
    this.bigPercentForDepositAccount = bigPercentForDepositAccount;
  }

  public Account getCurrentAccount(double money, Client client){
    return new CurrentAccount(money, client, percentForCurrentAccount);
  }

  public Account getDepositAccount(double money, Client client, Calendar date){
    return new DepositAccount(money, client, date,
            smallPercentForDepositAccount, mediumPercentForDepositAccount, bigPercentForDepositAccount);
  }

  public Account getCreditAccount(double money, Client client, double moneyLimit){
    return new CreditAccount(money, client, moneyLimit, commission);
  }
}
