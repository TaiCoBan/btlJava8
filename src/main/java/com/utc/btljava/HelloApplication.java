package com.utc.btljava;
import com.utc.btljava.controller.Gameloop;
import javafx.application.Application;
import javafx.stage.Stage;

public class HelloApplication extends Application {

  @Override
  public void start(Stage stage){
    Gameloop gameloop = new Gameloop(stage);
    gameloop.setUp();
    gameloop.start();
  }


  public static void main(String[] args) {
    launch(args);
  }
}
