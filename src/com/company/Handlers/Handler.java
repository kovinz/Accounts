package com.company.Handlers;

import com.company.Accounts.Account;

public abstract class Handler {
  private Handler next;

  public Handler linkWith(Handler next) {
    this.next = next;
    return next;
  }

  public abstract void request(Account account);

  protected void requestToNext(Account account) {
    if (next == null) {
      return;
    }
    next.request(account);
  }
}