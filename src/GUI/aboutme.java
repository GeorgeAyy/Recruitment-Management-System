/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author fatim
 */

 
package GUI;

import java.awt.Color;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.Side;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;
import javafx.stage.Stage;

/**
 *
 * @author georg
 */
public class aboutme extends Scene{

    public aboutme(StackPane root, double d, double d1,Stage primaryStage) {
        super(root, d, d1);
        Label myl = new Label("Welcome to my App!");
        myl.setFont(Font.font("Lucida Calligraphy",26));
        myl.setStyle("-fx-text-fill: white"); 
        Label myl1 = new Label ("A recruitment management system is a computer program ");
        myl1.setStyle("-fx-text-fill: white");
        myl1.setFont(Font.font("Trebuchet MS", 20));
        Label myl2 = new Label("that allows different types of users to interact with one another in order ");
        myl2.setStyle("-fx-text-fill: white");
        myl2.setFont(Font.font("Trebuchet MS", 20));
        Label myl3 = new Label("to facilitate the job search process. The system includes three main");
        myl3.setStyle("-fx-text-fill: white");
        myl3.setFont(Font.font("Trebuchet MS", 20));
        Label myl4 = new Label(" types of users: employers, agencies, and administrators.");
        myl4.setStyle("-fx-text-fill: white");
        myl4.setFont(Font.font("Trebuchet MS", 20));
        VBox vb2 = new VBox(40);
        vb2.getChildren().addAll(myl1,myl2,myl3,myl4);
        vb2.setAlignment(Pos.TOP_CENTER);
        vb2.setPadding(new Insets(50,0,0,0));
        ImageView homeimage = new ImageView(RecruitmentSystem.Home);
        homeimage.minHeight(10);
        homeimage.minWidth(10);
        Button home = new Button("",homeimage);
         home.setStyle("-fx-background-color: cornflowerblue; -fx-cursor: hand;-fx-background-radius: 15px; -fx-text-fill: #ffffff");
         home.setMaxSize(1, 1);
         HBox topright=new HBox(home);
         topright.setAlignment(Pos.TOP_RIGHT);
         topright.setPadding(new Insets(10,10,10,10));
         
        HBox hb1 = new HBox();
        hb1.setPadding(new Insets(70,0,0,0));
        hb1.setAlignment(Pos.CENTER);
        hb1.getChildren().add(myl);
        VBox vb=new VBox();
        vb.getChildren().addAll(topright,hb1);
        BorderPane pane = new BorderPane();
        pane.setTop(vb);
        pane.setCenter(vb2);
        home.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {
              primaryStage.setScene(new MainLogin(new StackPane(),1200,700,primaryStage));
            }
        });
        ImageView backimage=new ImageView(RecruitmentSystem.BackBtn);
        Button back=new Button("",backimage);
                back.setStyle("-fx-background-color: cornflowerblue;-fx-cursor: hand; -fx-background-radius: 15px; -fx-text-fill: #ffffff");
                HBox backhb=new HBox();
                backhb.setAlignment(Pos.BOTTOM_LEFT);
                backhb.getChildren().add(back);
                back.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {
                primaryStage.setScene(new MainLogin(new StackPane(),1200,700,primaryStage));
            }
                
                });
                pane.setBottom(backhb);
        root.getChildren().add(new ImageView(RecruitmentSystem.Background));
        root.getChildren().add(pane);
        
    }
    
}

