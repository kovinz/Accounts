package com.company.Handlers;

import com.company.Accounts.Account;

import java.lang.reflect.Method;

public class AccountHandler extends Handler {
  @Override
  public void request(Account account) {
    Class clazz = account.getClass();
    String clazzName = clazz.getSimpleName();
    try {
      if (clazzName.equals("CurrentAccount")) {
        Method method = clazz.getDeclaredMethod("addPercent");
        method.invoke(account);
      } else if (clazzName.equals("CreditAccount")) {
        Method method = clazz.getDeclaredMethod("withdrawCommission");
        method.invoke(account);
      } else if (clazzName.equals("DepositAccount")) {
        Method method = clazz.getDeclaredMethod("addPercent");
        method.invoke(account);
      } else {
        requestToNext(account);
      }
    } catch (Exception e) {
      requestToNext(account);
    }
  }
}
