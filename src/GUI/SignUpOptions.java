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

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author fatim
 */
public class SignUpOptions extends Scene {
    
    public SignUpOptions(StackPane root, double d, double d1,Stage primaryStage) {
        super(root, d,d1);
        Label who=new Label("Sign up");
         who.setFont(Font.font("Lucida Calligraphy",30));
         who.setStyle("-fx-text-fill: white"); 
       
         ImageView homeimage=new ImageView(RecruitmentSystem.Home);
         homeimage.minHeight(10);
         homeimage.minWidth(10);
         Button home =new Button("",homeimage);
         home.setStyle("-fx-background-color: cornflowerblue; -fx-cursor: hand;-fx-background-radius: 15px; -fx-text-fill: #ffffff");
         home.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {
              primaryStage.setScene(new MainLogin(new StackPane(),1200,700,primaryStage));
            }
         });
        Button empsu=new Button("Sign up as an employee");
        empsu.setMinSize(294, 30);
        empsu.setStyle("-fx-background-color: cornflowerblue; -fx-cursor: hand;-fx-background-radius: 15px; -fx-text-fill: #ffffff");
        empsu.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {
              primaryStage.setScene(new SignUpEmployee(new StackPane(),1200,700,primaryStage));
            }
         });
        
        Button emplsu=new Button("Sign up as an employer");
        emplsu.setMinSize(294, 30);
        emplsu.setStyle("-fx-background-color: cornflowerblue; -fx-cursor: hand;-fx-background-radius: 15px; -fx-text-fill: #ffffff");
         emplsu.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {
              primaryStage.setScene(new SignUpEmployer(new StackPane(),1200,700,primaryStage));
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
            backhb.setAlignment(Pos.BOTTOM_LEFT);
            backhb.setPadding(new Insets(5,5,10,5));
            
        HBox text=new HBox();
        text.getChildren().add(who);
        text.setAlignment(Pos.CENTER);
        text.setPadding(new Insets(50,5,5,5));
        
        HBox logo=new HBox();
        logo.getChildren().add(home);
        logo.setAlignment(Pos.TOP_RIGHT);
        logo.setPadding(new Insets(5,5,5,5));
        
        VBox vb=new VBox();
        vb.getChildren().addAll(logo,text);
        
        VBox btns=new VBox(40);
        btns.getChildren().addAll(empsu,emplsu);
        btns.setAlignment(Pos.TOP_CENTER);
        btns.setPadding(new Insets(50,5,5,5));
        
        BorderPane mypane = new BorderPane();
            mypane.setTop(vb);
            mypane.setCenter(btns);
                      
            Label noacc=new Label("Already have an account ?");
               noacc.setStyle("-fx-text-fill: white;");
              
             Hyperlink login = new Hyperlink("Sign in ");
        login.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {
                primaryStage.setScene(new SignInOptions (new StackPane(),1200,700,primaryStage));
            }
        });
        HBox hyper=new HBox(20);
        hyper.getChildren().addAll(noacc,login);
        hyper.setAlignment(Pos.TOP_CENTER);
        hyper.setPadding(new Insets(0,0,70,0));
        
        mypane.setBottom(hyper);
        mypane.setBottom(backhb);
        
        
          root.getChildren().add(new ImageView(RecruitmentSystem.Background));
          root.getChildren().add(mypane); 

    }
    
  
}
