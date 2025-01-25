package com.utc.btljava.view;

import com.utc.btljava.controller.KeyInput;
import com.utc.btljava.controller.State;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;

public class Home extends Scene {
  KeyInput keyInput;
  State state;
  
  Map map;
  Character character;
  
  public Home(State state, KeyInput keyInput, Map map, Character character) {
    super(new Pane());
    this.keyInput = keyInput;
    this.map = map;
    this.character = character;
  }
  
  public void setUp() {
    // SET KEYINPUT FOR HOME AND MORE ...
  }
  
  public void update() {
    // UPDATE DX, DY OF MAP, ...
    map.update();
    character.update();
  }
}
