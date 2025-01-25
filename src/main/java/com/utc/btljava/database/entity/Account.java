package com.utc.btljava.database.entity;

import com.utc.btljava.database.entity.base.BaseEntity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Account extends BaseEntity {
  @Column(nullable = false)
  private String username;
  @Column(nullable = false)
  private String password;
  @ManyToMany
  @JoinTable(
          name = "account_achievement",
          joinColumns = @JoinColumn(name = "account_id"),
          inverseJoinColumns = @JoinColumn(name = "achievement_id")
  )
  private Set<Achievement> achievements = new HashSet<>();
  
  public String getUsername() {
    return username;
  }
  
  public void setUsername(String username) {
    this.username = username;
  }
  
  public String getPassword() {
    return password;
  }
  
  public void setPassword(String password) {
    this.password = password;
  }
  
  public Set<Achievement> getAchievements() {
    return achievements;
  }
  
  public void setAchievements(Set<Achievement> achievements) {
    this.achievements = achievements;
  }
}
