package com.utc.btljava.view;

import com.utc.btljava.constants.Constant;
import com.utc.btljava.database.service.AccountService;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Popup {
  private Node loginForm;
  private Node registerForm;
  private Node forgotPasswordForm;
  
  AccountService accountService;
  
  public Popup(AccountService accountService) {
    this.loginForm = loginForm();
    this.accountService = accountService;
  }
  
  // - StackPane
  //    - VBox: elements
  public BorderPane loginForm() {
    BorderPane layout = new BorderPane();
    
    // Ngăn thao tác với Layout 1 sau khi popup Layout 2
    Rectangle rect = new Rectangle(Constant.W, Constant.H);
    rect.setFill(Color.TRANSPARENT);
    
    // LOGIN FORM
    VBox loginForm = new VBox();
    loginForm.setPadding(new Insets(15));
    
//    loginForm.setPrefSize(400, 600);
    loginForm.setMaxSize(400, 500);
    loginForm.setBackground(new Background(new BackgroundFill(Color.web("#00000099"), null, null)));
    
    Label LOGIN = new Label("LOGIN");
    LOGIN.getStyleClass().add("login-title");
    
    Label usernameLb = new Label("USERNAME");
    usernameLb.getStyleClass().add("usernameLb");
    TextField usernameTf = new TextField();
    usernameTf.getStyleClass().add("usernameTf");
    
    Label passwordLb = new Label("PASSWORD");
    passwordLb.getStyleClass().add("usernameLb");
    PasswordField passwordTf = new PasswordField();
    passwordTf.getStyleClass().add("usernameTf");
    
    // BUTTONS
    Label forgotPasswordLb = new Label("Forgot password?");
    forgotPasswordLb.getStyleClass().add("forgot-password");
    
    Button loginBtn = new Button("Login");
    loginBtn.getStyleClass().add("login-button");
    loginBtn.setMaxWidth(Double.MAX_VALUE);
    loginBtn.setOnAction(event -> {
      if (!accountService.login(usernameTf.getText(), passwordTf.getText())) {
        System.out.println("Login failed");
      } else {
        System.out.println("Login successful");
      }
    });
    
    Label or = new Label("or");
    or.getStyleClass().add("or");
    VBox orBox = new VBox(or);
    orBox.setAlignment(Pos.CENTER);
    
    Button registerBtn = new Button("Register");
    registerBtn.getStyleClass().add("register-button");
    registerBtn.setMaxWidth(Double.MAX_VALUE);
    
    Button backBtn = new Button("Back");
    backBtn.getStyleClass().add("back-button");
    backBtn.setFont(Constant.H3);
//    backBtn.setLayoutX(200);
//    backBtn.setLayoutY(200);
    VBox backBtnBox = new VBox(backBtn);
//    backBtnBox.setAlignment(Pos.BOTTOM_RIGHT);
    backBtn.setOnAction(event -> {
      ((StackPane) backBtnBox.getParent().getParent().getParent()).getChildren().remove(layout);
    });
    
    loginForm.getChildren().addAll(
            LOGIN,
            usernameLb, usernameTf,
            passwordLb, passwordTf,
            forgotPasswordLb,
            loginBtn,
            orBox,
            registerBtn,
            backBtnBox
    );
    
    layout.setCenter(rect);
    layout.setCenter(loginForm);
    
    return layout;
  }
}
