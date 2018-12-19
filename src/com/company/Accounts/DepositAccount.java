package com.company.Accounts;

import com.company.Clients.Client;

import java.util.Calendar;

public class DepositAccount extends GeneralAccount {
  private double percent;
  private Calendar date;

  public DepositAccount(double money, Client client, Calendar date,
                        double smallPercent, double mediumPercent, double bigPercent) {
    super(money, client);
    this.date = date;

    if (money < 100000){
      percent = smallPercent;
    } else if (money > 1000000){
      percent = bigPercent;
    } else {
      percent = mediumPercent;
    }
  }

  public void addPercent(){
    Calendar todayDate = Calendar.getInstance();
    if (todayDate.compareTo(date) > -1){
      replenish(getMoney() * percent/100);
    }
  }

  @Override
  public void withdraw(double money){
    Calendar todayDate = Calendar.getInstance();
    if (todayDate.compareTo(date) > -1){
      super.withdraw(money);
    }
  }
}
