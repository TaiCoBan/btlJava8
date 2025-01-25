package com.utc.btljava.constants;

import javafx.scene.text.Font;

public class Constant {
  public static final double W = 16*80;
  public static final double H = 10*80;
  public static final double ROOM_W = 200;
  public static final double ROOM_H = 200;
  
  // FONT
  public static final Font H1 = Font.loadFont(Constant.class.getResourceAsStream("/fonts/Pixel Game.otf"), 64);
  public static final Font H2 = Font.loadFont(Constant.class.getResourceAsStream("/fonts/Pixel Game.otf"), 32);
  public static final Font H3 = Font.loadFont(Constant.class.getResourceAsStream("/fonts/Pixel Game.otf"), 16);
}
