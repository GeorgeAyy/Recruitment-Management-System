
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author fatim
 */
  

package GUI;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

/**
 *
 * @author georg
 */
public class MainLogin extends Scene{

    public MainLogin(StackPane root, double d, double d1, Stage primaryStage) {
        super(root, d, d1);
        Label welcome = new Label("Welcome to CareerPal!");
        welcome.setStyle("-fx-text-fill: white;");
        welcome.setFont(Font.font("Lucida Calligraphy",26));
        HBox topbox = new HBox(welcome);
        topbox.setAlignment(Pos.CENTER);
        topbox.setPadding(new Insets(100,0,0,0));
        VBox hb=new VBox(topbox);
        hb.setAlignment(Pos.CENTER);
        hb.setPadding(new Insets(50,0,0,0));
        BorderPane mypane = new BorderPane();
        Button login = new Button("Sign In");
        login.setMinSize(294, 30);
        login.setStyle("-fx-background-color: cornflowerblue;-fx-cursor: hand; -fx-background-radius: 15px; -fx-text-fill: #ffffff");
        login.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {
                primaryStage.setScene(new SignInOptions(new StackPane(),1200,700,primaryStage));
            }
        });
        Button logout = new Button("Sign Up");
        logout.setMinSize(294, 30);
        logout.setStyle("-fx-background-color: cornflowerblue;-fx-cursor: hand; -fx-background-radius: 15px; -fx-text-fill: #ffffff");
        logout.setOnAction(new EventHandler<ActionEvent>(){
         @Override
            public void handle(ActionEvent event) {
                primaryStage.setScene(new SignUpOptions(new StackPane(),1200,700,primaryStage));
            }
        });
        Label ifYou = new Label("If you want to learn more about me ");
        ifYou.setStyle("-fx-text-fill: white;");
        Hyperlink aboutMe = new Hyperlink("Click Here!");
        aboutMe.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {
                primaryStage.setScene(new aboutme(new StackPane(),1200,700,primaryStage));
            }
        });
        HBox hb1 = new HBox(ifYou,aboutMe);
        hb1.setAlignment(Pos.TOP_CENTER);
        hb1.setPadding(new Insets(0,0,70,0));
        VBox centerbox = new VBox(40);
        centerbox.setPadding(new Insets(90,0,0,0));
        centerbox.setAlignment(Pos.TOP_CENTER);
        centerbox.getChildren().addAll(login,logout);
        mypane.setBottom(hb1);
        mypane.setTop(hb);
        mypane.setCenter(centerbox);
        ImageView background = new ImageView(RecruitmentSystem.Background); 
        root.getChildren().add(background);
        root.getChildren().add(mypane);
    }
    
}

