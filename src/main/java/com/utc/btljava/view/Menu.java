package com.utc.btljava.view;

import com.utc.btljava.constants.Constant;
import com.utc.btljava.controller.State;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;

public class Menu extends Scene {
  State state;
  Popup popup;
  
  public Menu(State state, Popup popup) {
    super(new StackPane());
    this.state = state;
    this.popup = popup;
    setUp();
  }
  
  // menu scene
  //   - root (StackPane)
  //       - layout 1 (StackPane): background, play button, setting button
  //       - layout 2 (BorderPane): popups
  public void setUp() {
    StackPane root = (StackPane) this.getRoot();
    root.getStylesheets().add(getClass().getResource("/static/styles.css").toExternalForm());
    
    AnchorPane layout1 = new AnchorPane();
    
    // BACKGROUND
    Image bgImage = new Image(getClass().getResourceAsStream("/image/background/space-background.png"));
    ImageView background = new ImageView(bgImage);
    background.setFitWidth(Constant.W);
    background.setFitHeight(Constant.H);
    
    // BUTTONS
    Button playButton = new Button("Play");
    playButton.getStyleClass().add("play-button");
    AnchorPane.setBottomAnchor(playButton, 40.0);
    AnchorPane.setLeftAnchor(playButton, Constant.W/2 - 350/2.0);
    playButton.setOnAction(event -> {
      System.out.println("Play button clicked");
      root.getChildren().add(popup.loginForm());
    });
    
    Button settingBtn = new Button("");
    settingBtn.getStyleClass().add("setting-button");
    AnchorPane.setBottomAnchor(settingBtn, 40.0);
    AnchorPane.setLeftAnchor(settingBtn, 40.0);
    settingBtn.setOnAction(event -> {
      System.out.println("Setting button clicked");
    });
    
    layout1.getChildren().addAll(background, playButton, settingBtn);
    
    root.getChildren().addAll(layout1);
  }
  
  public void update() {
    //
  }
}
