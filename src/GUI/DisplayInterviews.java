/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;

import static GUI.RecruitmentSystem.Home;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import main.Employee;

/**
 *
 * @author georg
 */
public class DisplayInterviews extends Scene{
    
    public DisplayInterviews(StackPane root, double d, double d1,Stage primaryStage,Employee emp,int index) {
        super(root, d, d1);
        BorderPane bp = new BorderPane();
        Label lb = new Label("Your Interviews");
        lb.setFont(Font.font("Elephant",25)); 
        lb.setStyle("-fx-text-fill: white;");
        HBox labelBox = new HBox(lb);
        labelBox.setPadding(new Insets(90,0,0,0));
        labelBox.setAlignment(Pos.CENTER);
        TextArea TA = new TextArea();
        TA.setEditable(false);
        VBox vb = new VBox();
        VBox vb1 = new VBox();
        try{
            File x = new File(emp.getEmail()+ "Interviews.txt");
            BufferedReader br = new BufferedReader(new FileReader(x));
            if (br.readLine() == null) 
            {
               System.out.println("File is empty");
            }
            else 
            {
                FileReader in = new FileReader(emp.getEmail() + "Interviews.txt");
                Scanner Sr = new Scanner(in);
                int count = 0;
            while(Sr.hasNextLine())
                {
                    TA.appendText(Sr.nextLine());
                    count++;
                }
            }
        }
        catch(IOException ex)
        {
            
        }
        HBox homz=new HBox();
      ImageView homeimage = new ImageView(Home);
      homeimage.minHeight(10);
      homeimage.minWidth(10);
      Button home=new Button("",homeimage);
      home.setStyle("-fx-background-color: cornflowerblue;-fx-cursor: hand; -fx-background-radius: 15px; -fx-text-fill: #ffffff");
    
      home.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {
                primaryStage.setScene(new MainLogin(new StackPane(),1200,700,primaryStage));
            }
        });
      homz.getChildren().add(home);
      homz.setAlignment(Pos.TOP_RIGHT);
      ImageView backimage=new ImageView(RecruitmentSystem.BackBtn);
      Button back=new Button("",backimage);
                back.setStyle("-fx-background-color: cornflowerblue;-fx-cursor: hand; -fx-background-radius: 15px; -fx-text-fill: #ffffff");
                HBox backhb=new HBox();
                backhb.setAlignment(Pos.BOTTOM_LEFT);
                backhb.getChildren().add(back);
                back.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {
                primaryStage.setScene(new EmployeeScreen(new StackPane(),1200,700,primaryStage,emp,index));
            }
                
                });
        TA.prefWidth(400);
        TA.setWrapText(true);
        ScrollPane scrollPane = new ScrollPane();
        scrollPane.setContent(TA);
        scrollPane.setFitToWidth(true);
        scrollPane.setPrefWidth(400);
        scrollPane.setPrefHeight(180);
        vb1.getChildren().addAll(homz,labelBox);
        vb.getChildren().add(scrollPane);
        vb.setAlignment(Pos.CENTER);
        vb1.setAlignment(Pos.CENTER);
        vb.setPadding(new Insets(0,50,0,50));
        bp.setTop(vb1);
        bp.setCenter(vb);
        bp.setBottom(backhb);
        root.getChildren().add(new ImageView(RecruitmentSystem.Background));
        root.getChildren().add(bp);
        
    }
    
}
