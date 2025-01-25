package com.utc.btljava.database.entity;

import com.utc.btljava.database.entity.base.BaseEntity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Achievement extends BaseEntity {
  @Column(nullable = false)
  private String name;
  @Column(nullable = false)
  private String description;
  @ManyToMany(mappedBy = "achievements")
  private Set<Account> accounts = new HashSet<>();
  
  public Achievement(String name, String description) {
    this.name = name;
    this.description = description;
  }
  
  public String getName() {
    return name;
  }
  
  public void setName(String name) {
    this.name = name;
  }
  
  public String getDescription() {
    return description;
  }
  
  public void setDescription(String description) {
    this.description = description;
  }
  
  public Set<Account> getAccounts() {
    return accounts;
  }
  
  public void setAccounts(Set<Account> accounts) {
    this.accounts = accounts;
  }
}
