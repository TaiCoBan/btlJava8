package com.utc.btljava.database.service;

import com.utc.btljava.database.entity.Account;
import com.utc.btljava.database.service.base.BaseServiceImpl;

import java.util.Optional;

public class AccountService extends BaseServiceImpl<Account> {
  public AccountService(Class<Account> clazz) {
    super(clazz);
  }
  
  public boolean login(String username, String password) {
    Optional<Account> account = findByField("username", username);
    if (!account.isPresent()) {
      return false;
    }
    
    if (!account.get().getPassword().equals(password)) {
      return false;
    }
    
    return true;
  }
  
  public boolean register(String username, String email, String password, String confirmPassword) {
    Optional<Account> account = findByField("username", username);
    if (account.isPresent()) {
      return false;
    }
    
    return true;
  }
}
