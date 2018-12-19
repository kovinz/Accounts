package com.company.Handlers;

import com.company.Accounts.Account;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class AccountDecoratorHandler extends Handler {
  @Override
  public void request(Account account) {
    Class clazz = account.getClass();
    clazz = clazz.getSuperclass();
    try {
      Field fieldToTransact = clazz.getDeclaredField("wrappee");
      fieldToTransact.setAccessible(true);
      Account accountToTransact = (Account) fieldToTransact.get(account);
      Class classOfAccount = accountToTransact.getClass();
      String classOfAccountName = classOfAccount.getSimpleName();
      if (classOfAccountName.equals("CurrentAccount")) {
        Method method = classOfAccount.getDeclaredMethod("addPercent");
        method.invoke(accountToTransact);
      } else if (classOfAccountName.equals("CreditAccount")) {
        Method method = classOfAccount.getDeclaredMethod("withdrawCommission");
        method.invoke(accountToTransact);
      } else if (classOfAccountName.equals("DepositAccount")) {
        Method method = classOfAccount.getDeclaredMethod("addPercent");
        method.invoke(accountToTransact);
      } else {
        requestToNext(account);
      }
    } catch (Exception e) {
      requestToNext(account);
    }
  }
}
