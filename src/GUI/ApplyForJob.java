/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

/**
 *
 * @author fatim
 */
public class ApplyForJob extends Scene {
    
    public ApplyForJob(StackPane root, double d, double d1,Stage primaryStage) {
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
            
            Label text=new Label("Apply for a job");
            text.setStyle("-fx-text-fill: white;");
            text.setFont(Font.font("Eelephant",20));
                 
            HBox texthb=new HBox();
             texthb.getChildren().addAll(text);
             texthb.setAlignment(Pos.CENTER);
            
            //top vertical box that holds home button and the name of the page
            VBox top=new VBox(20);
            top.getChildren().addAll(homehb,texthb);
            top.setAlignment(Pos.CENTER);
            Label cat=new Label("category:");
              cat.setStyle("-fx-text-fill: white;");
            //options is the HBox that has both the categories and their choices
            HBox options=new HBox(10);
        ObservableList<String> items = FXCollections.observableArrayList(
                "Professional",
                "Highly Skilled",
                "Skilled",
                "Semi-Skilled");
           ComboBox comboBox = new ComboBox(items);
           options.getChildren().addAll(cat,comboBox);
           
           //jobs displayed based on chosen category
           
           
           
        
    }
    
}
