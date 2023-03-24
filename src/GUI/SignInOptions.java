
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.Side;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
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
import javafx.stage.Stage;

/**
 *
 * @author georg
 */
public class SignInOptions extends Scene{

    public SignInOptions(StackPane root, double d, double d1,Stage primaryStage) {
            super(root, d, d1);
            Label who=new Label("Sign in ");
            who.setFont(Font.font("Lucida Calligraphy",30));
            who.setStyle("-fx-text-fill: white"); 
            ImageView homeimage = new ImageView(RecruitmentSystem.Home);
            Button home=new Button("",homeimage);
            home.setStyle("-fx-background-color: cornflowerblue;-fx-cursor: hand; -fx-background-radius: 15px; -fx-text-fill: #ffffff");
            home.setOnAction(new EventHandler<ActionEvent>(){
                @Override
                public void handle(ActionEvent event) {
                  primaryStage.setScene(new MainLogin(new StackPane(),1200,700,primaryStage));
                }
            });
               ImageView backimage = new ImageView(RecruitmentSystem.BackBtn);
            Button back=new Button("",backimage);
            back.setStyle("-fx-background-color: cornflowerblue; -fx-cursor: hand;-fx-background-radius: 15px; -fx-text-fill: #ffffff");
            back.setOnAction(new EventHandler<ActionEvent>(){
                @Override
                public void handle(ActionEvent event) {
                  primaryStage.setScene(new MainLogin(new StackPane(),1200,700,primaryStage));
                }
            });
            HBox backhb=new HBox(back);
            backhb.setAlignment(Pos.TOP_LEFT);
            backhb.setPadding(new Insets(5,5,30,5));
           
            Button emp=new Button("Sign in as employee");
            emp.setMinSize(294, 30);
            emp.setStyle("-fx-background-color: cornflowerblue; -fx-cursor: hand;-fx-background-radius: 15px; -fx-text-fill: #ffffff");
            Button empl=new Button("Sign in as employer");
            empl.setMinSize(294, 30);
            empl.setStyle("-fx-background-color: cornflowerblue;-fx-cursor: hand; -fx-background-radius: 15px; -fx-text-fill: #ffffff");
            Button admin=new Button("Sign in as an admin");
            admin.setMinSize(294, 30);
            admin.setStyle("-fx-background-color: cornflowerblue; -fx-cursor: hand;-fx-background-radius: 15px; -fx-text-fill: #ffffff");
            HBox text=new HBox();
            text.getChildren().add(who);
            text.setAlignment(Pos.CENTER);
            text.setPadding(new Insets(50,5,5,5));
            HBox logo=new HBox();
            logo.getChildren().add(home);
            logo.setAlignment(Pos.TOP_RIGHT);
            logo.setPadding(new Insets(30,0,0,0));
            VBox vb =new VBox();
            vb.getChildren().addAll(logo,text);
            vb.setAlignment(Pos.CENTER);
            VBox vb1=new VBox(40);
            vb1.getChildren().addAll(emp,empl,admin);
            vb1.setAlignment(Pos.TOP_CENTER);
            vb1.setPadding(new Insets(50,0,0,0));
            emp.setOnAction(new EventHandler<ActionEvent>(){
                @Override
                public void handle(ActionEvent event) {
                   primaryStage.setScene(new SigninEmployee(new StackPane(),1200,700,primaryStage));
                }
            });
            empl.setOnAction(new EventHandler<ActionEvent>(){
                @Override
                public void handle(ActionEvent event) {
                    primaryStage.setScene(new SignInEmployer(new StackPane(),1200,700,primaryStage));
                }
            });
            admin.setOnAction(new EventHandler<ActionEvent>(){
                @Override
                public void handle(ActionEvent event) {
                    primaryStage.setScene(new SignInAdmin(new StackPane(),1200,700,primaryStage));
                }
            });
               Label noacc=new Label("New user?");
               noacc.setStyle("-fx-text-fill: white;");
              
             Hyperlink login = new Hyperlink("Sign up");
        login.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {
                primaryStage.setScene(new SignUpOptions (new StackPane(),1200,700,primaryStage));
            }
        });
        HBox hyper=new HBox(20);
        hyper.getChildren().addAll(noacc,login);
        hyper.setAlignment(Pos.TOP_CENTER);
        hyper.setPadding(new Insets(20,0,0,0));
        
        VBox btnhl=new VBox();
        btnhl.setAlignment(Pos.TOP_CENTER);
        btnhl.getChildren().addAll(hyper,backhb);
        
        
            BorderPane mypane = new BorderPane();
            mypane.setTop(vb);
            mypane.setCenter(vb1);
            mypane.setBottom(btnhl);
            
            root.getChildren().add(new ImageView(RecruitmentSystem.Background));
            root.getChildren().add(mypane); 
    }
}
