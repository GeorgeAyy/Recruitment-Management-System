/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

/**
 *
 * @author fatim
 */
public class Searchforjobs extends Scene{
    
      

    public Searchforjobs(StackPane root, double d, double d1, Stage primaryStage) {
        super(root, d, d1);
    
            ImageView homeimage = new ImageView(RecruitmentSystem.Home);
   
            homeimage.minHeight(10);
            homeimage.minWidth(10);
            Button home=new Button("",homeimage);
            home.setStyle("-fx-background-color: cornflowerblue; -fx-cursor: hand;-fx-background-radius: 15px; -fx-text-fill: #ffffff");
            home.setOnAction(new EventHandler<ActionEvent>(){
                @Override
                public void handle(ActionEvent event) {
                  primaryStage.setScene(new MainLogin(new StackPane(),1200,700,primaryStage));
                }
            });
              HBox homehb =new HBox();
            homehb.setAlignment(Pos.TOP_RIGHT);
            homehb.setPadding(new Insets(5,5,0,0));
            homehb.getChildren().add(home);
            
             Label text=new Label("Enter the name of the job you're searching for");
            text.setStyle("-fx-text-fill: white;");
            text.setFont(Font.font("Eelephant",30));
            
                   
            HBox texthb=new HBox();
             texthb.getChildren().addAll(text);
             texthb.setAlignment(Pos.CENTER);
             
             VBox top=new VBox(40);
            top.getChildren().addAll(homehb,texthb);
            top.setAlignment(Pos.CENTER);
            top.setPrefSize(400, 100);
   
          Label SB=new Label("Search for a job:");
           SB.setStyle("-fx-text-fill: white;");
           SB.setFont(Font.font(16));
           TextField SB1=new TextField();
             SB1.setPrefWidth(500); 
           
              Button search=new Button("Search");
              search.setStyle("-fx-background-color: cornflowerblue; -fx-cursor: hand; -fx-text-fill: #ffffff");
              
              HBox SBtxtbx=new HBox(10);
              SBtxtbx.getChildren().addAll(SB,SB1,search);
              SBtxtbx.setAlignment(Pos.CENTER);
              
              ImageView backimage = new ImageView(RecruitmentSystem.BackBtn);
            Button back=new Button("",backimage);
            back.setStyle("-fx-background-color: cornflowerblue; -fx-cursor: hand;-fx-background-radius: 15px; -fx-text-fill: #ffffff");
            back.setOnAction(new EventHandler<ActionEvent>(){
                @Override
                public void handle(ActionEvent event) {
                  primaryStage.setScene(new SignInEmployer(new StackPane(),1200,700,primaryStage));
                }
            });
            HBox backhb=new HBox(back);
            backhb.setAlignment(Pos.BOTTOM_LEFT);
            backhb.setPadding(new Insets(5,5,30,5));
              
               VBox btns=new VBox();
            btns.getChildren().addAll(top,SBtxtbx);
            btns.setAlignment(Pos.CENTER);
            
            BorderPane mypane = new BorderPane();
              mypane.setTop(top);
              mypane.setCenter(SBtxtbx);
              mypane.setBottom(back);
          
            
            
             root.getChildren().add(new ImageView(RecruitmentSystem.Background));
             root.getChildren().add(mypane); 
              
                
}
}
