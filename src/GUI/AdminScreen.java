/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;

/**
 *
 * @author fatim
 */
import GUI.MainLogin;
import java.io.IOException;
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
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author fatim
 */
public class AdminScreen extends Scene{
    
     public AdminScreen(StackPane root, double d, double d1,Stage primaryStage) {
        super(root, d, d1);
            ImageView homeimage = new ImageView(RecruitmentSystem.Home);
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
            Label choices=new Label("Pick one of the following choices ");
            choices.setFont(Font.font("Elephant",20)); 
            choices.setStyle("-fx-text-fill: white;");
            HBox hb =new HBox();
            hb.getChildren().add(choices);
            hb.setAlignment(Pos.CENTER);
            hb.setPadding(new Insets(50,5,5,5));
            HBox hb1=new HBox();
            hb1.getChildren().add(home);
            hb1.setAlignment(Pos.TOP_RIGHT);
            hb1.setPadding(new Insets(5,5,5,5));
        
            VBox txt=new VBox(10);
            txt.getChildren().addAll(hb1,hb);
              ImageView backimage = new ImageView(RecruitmentSystem.BackBtn);
            Button back=new Button("",backimage);
            back.setStyle("-fx-background-color: cornflowerblue; -fx-cursor: hand;-fx-background-radius: 15px; -fx-text-fill: #ffffff");
            back.setOnAction(new EventHandler<ActionEvent>(){
                @Override
                public void handle(ActionEvent event) {
                  primaryStage.setScene(new SignInOptions(new StackPane(),1200,700,primaryStage));
                }
            });
            HBox backhb=new HBox(back);
            backhb.setAlignment(Pos.BOTTOM_LEFT);
            backhb.setPadding(new Insets(5,5,30,5));
            
            
            Button deljob=new Button("Delete job");
            deljob.setStyle("-fx-background-color: cornflowerblue;-fx-cursor: hand; -fx-background-radius: 15px; -fx-text-fill: #ffffff");
            deljob.setMinSize(294, 30);
            deljob.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {
            try {
                    primaryStage.setScene(new DeleteJobs(new StackPane(),1200,700,primaryStage));
                }  catch (ClassNotFoundException ex) {
                    Logger.getLogger(AdminScreen.class.getName()).log(Level.SEVERE, null, ex);
                }
                    
            }
        });
            Button delapplicant=new Button("Delete applicant's register");
            delapplicant.setStyle("-fx-background-color: cornflowerblue;-fx-cursor: hand; -fx-background-radius: 15px; -fx-text-fill: #ffffff");
            delapplicant.setMinSize(294, 30);
            delapplicant.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {
                try {
                    primaryStage.setScene(new DeleteEmployee(new StackPane(),1200,700,primaryStage));
                } catch (IOException ex) {
                    Logger.getLogger(AdminScreen.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(AdminScreen.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
     
     });
            Button delempl=new Button("Delete agency's register");
             delempl.setStyle("-fx-background-color: cornflowerblue;-fx-cursor: hand; -fx-background-radius: 15px; -fx-text-fill: #ffffff");
             delempl.setMinSize(294, 30);
             delempl.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {
                try {
                    primaryStage.setScene(new DeleteEmployer(new StackPane(),1200,700,primaryStage));
                } catch (IOException | ClassNotFoundException ex) {
                    Logger.getLogger(AdminScreen.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
            Button logout=new Button("logout");
            logout.setStyle("-fx-background-color: cornflowerblue;-fx-cursor: hand; -fx-background-radius: 15px; -fx-text-fill: #ffffff");
            logout.setMinSize(294, 30);
            logout.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {
                primaryStage.setScene(new MainLogin(new StackPane(),1200,700,primaryStage));
            }
            
        });
            VBox btns=new VBox(30);
            btns.getChildren().addAll(deljob,delapplicant,delempl,logout);
            btns.setAlignment(Pos.TOP_CENTER);
            btns.setPadding(new Insets(10,5,5,20));
            BorderPane mypane = new BorderPane();
              mypane.setTop(txt);
            mypane.setCenter(btns);
            mypane.setBottom(back);
          
            root.getChildren().add(new ImageView(RecruitmentSystem.Background));
            root.getChildren().add(mypane); 

    
    }
    
        
        
        
}
    
  
    
  