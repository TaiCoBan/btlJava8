package com.utc.btljava.view;

import com.utc.btljava.controller.KeyInput;
import com.utc.btljava.controller.State;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;

public class Game extends Scene {
  KeyInput keyInput;
  State state;
  
  Map map;
  Character character;
  
  public Game(State state, KeyInput keyInput, Map map, Character character) {
    super(new Pane());
    this.state = state;
    this.keyInput = keyInput;
    this.map = map;
    this.character = character;
  }
  
  public void setUI() {
  
  }
  
  public void update() {
    map.update();
    character.update();
  }
}
