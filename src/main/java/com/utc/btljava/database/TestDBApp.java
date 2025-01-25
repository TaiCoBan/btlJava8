package com.utc.btljava.database;

import com.utc.btljava.database.entity.Account;
import com.utc.btljava.database.service.AccountService;

public class TestDBApp {
  public static void main(String[] args) {
    System.out.println("hehe");
    AccountService accountService = new AccountService(Account.class);
    
    Account account = accountService.findById(2).get();
    System.out.println(account.toString());
  }
}
