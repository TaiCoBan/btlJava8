package com.utc.btljava.controller;

import com.utc.btljava.constants.Constant;
import com.utc.btljava.database.entity.Account;
import com.utc.btljava.database.service.AccountService;
import com.utc.btljava.view.Character;
import com.utc.btljava.view.*;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class Gameloop {
  private Stage stage;
  
  public Gameloop(Stage stage) {
    this.stage = stage;
  }
  
  // DATABASE
  AccountService accountService = new AccountService(Account.class);
  
  // STATE
  State state = new State();
  
  // SYSTEM
  KeyInput keyInput = new KeyInput();
  
  // ENTITY
  // Mobs mobs = new Mobs();
  Map map = new Map(/*mobs*/);
  Character character = new Character(keyInput);
  
  // SCENES
  Popup popup = new Popup(accountService);
  Menu menu = new Menu(state, popup);
  Home home = new Home(state, keyInput, map, character);
  Game game = new Game(state, keyInput, map, character);
  
  public void start() {
  
  }
  
  public void update() {
    if (state.currentScene == state.menu) {
      menu.update();
    } else if (state.currentScene == state.home) {
      home.update();
    } else if (state.currentScene == state.game) {
      game.update();
    }
  }
  
  public void setUp() {
    Font.loadFont(getClass().getResourceAsStream("/fonts/Pixel Game.otf"), 16);
    stage.setScene(menu);
    stage.setResizable(false);
    stage.setWidth(Constant.W);
    stage.setHeight(Constant.H);
    stage.show();
  }
}
