/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import main.Register;

/**
 *
 * @author fatim
 */
public class SignUpEmployer extends Scene {
     public SignUpEmployer(StackPane root, double d, double d1, Stage primaryStage) {
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
          
        
        VBox all=new VBox();    
        HBox hb3=new HBox (home);
        hb3.setAlignment(Pos.TOP_RIGHT);
        hb3.setPadding(new Insets(5,5,0,0));
        all.getChildren().addAll(hb3);
        Label signin = new Label("Sign Up as an Employer");
        signin.setStyle("-fx-text-fill: white;");
        signin.setFont(Font.font("Elephant",16));
        VBox vb2 = new VBox(30);
        vb2.setAlignment(Pos.TOP_CENTER);
        vb2.setPadding(new Insets(30,0,0,0));
        Label Username = new Label("Enter corporate name");
        Username.setStyle("-fx-text-fill: white;");
        
        Label Password = new Label("Password");
        Password.setStyle("-fx-text-fill: white;");
        PasswordField enterpass = new PasswordField();
        CheckBox showPass = new CheckBox("Show Password");
        showPass.setStyle("-fx-text-fill: white;");
        TextField shownpass = new TextField();
        shownpass.setVisible(false);
        shownpass.managedProperty().bind(showPass.selectedProperty());
        shownpass.visibleProperty().bind(showPass.selectedProperty());
        enterpass.managedProperty().bind(showPass.selectedProperty().not());
        enterpass.visibleProperty().bind(showPass.selectedProperty().not());
        // Bind the shownpass and enterpass text values bidirectionally.
        shownpass.textProperty().bindBidirectional(enterpass.textProperty());
        
        
         Label Passwordcheck = new Label("enter Password again ");
        Passwordcheck.setStyle("-fx-text-fill: white;");
        PasswordField enterpass2 = new PasswordField();
        CheckBox showPass2 = new CheckBox("Show Password");
        showPass2.setStyle("-fx-text-fill: white;");
        TextField shownpass2 = new TextField();
        shownpass2.setVisible(false);
        shownpass2.managedProperty().bind(showPass2.selectedProperty());
        shownpass2.visibleProperty().bind(showPass2.selectedProperty());
        enterpass2.managedProperty().bind(showPass2.selectedProperty().not());
        enterpass2.visibleProperty().bind(showPass2.selectedProperty().not());
        shownpass2.textProperty().bindBidirectional(enterpass2.textProperty());
        
        
        Button SignInBtn = new Button("Sign Up");
        TextField enteruser = new TextField();
        enteruser.setPrefColumnCount(15);
          
        
          ImageView backimage = new ImageView(RecruitmentSystem.BackBtn);
            Button back=new Button("",backimage);
            back.setStyle("-fx-background-color: cornflowerblue; -fx-cursor: hand;-fx-background-radius: 15px; -fx-text-fill: #ffffff");
            back.setOnAction(new EventHandler<ActionEvent>(){
                @Override
                public void handle(ActionEvent event) {
                  primaryStage.setScene(new SignUpOptions(new StackPane(),1200,700,primaryStage));
                }
            });
            HBox backhb=new HBox(back);
            backhb.setAlignment(Pos.BOTTOM_LEFT);
            backhb.setPadding(new Insets(5,5,20,5));
        
        
        GridPane pane = new GridPane();
        pane.setAlignment(Pos.CENTER);
        pane.addColumn(0, Username,enteruser,Password,enterpass);
        pane.add(shownpass,0,3);
        pane.add(showPass, 1, 3);
        pane.add(Passwordcheck, 0, 4);
        pane.add(shownpass2, 0, 5);
        pane.add(enterpass2,0,5);
        pane.add(showPass2, 1, 5);
        SignInBtn.setMinSize(294, 30);
        SignInBtn.setStyle("-fx-background-color: cornflowerblue; -fx-cursor: hand;-fx-background-radius: 15px; -fx-text-fill: #ffffff");
        Label newpal = new Label("Already a user?");
        newpal.setStyle("-fx-text-fill: white;");
        Hyperlink hl = new Hyperlink("Click here!");
        hl.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {
               primaryStage.setScene(new SignInEmployer(new StackPane(),1200,700,primaryStage));
            }
        
        });
        HBox hb = new HBox(5);
        hb.setAlignment(Pos.CENTER);
        hb.getChildren().addAll(newpal,hl);
        VBox vb3 = new VBox();
        Label error = new Label("");
        error.setStyle("-fx-text-fill: red;");
        vb3.getChildren().addAll(hb,error);
        vb3.setAlignment(Pos.TOP_CENTER);
        vb2.getChildren().addAll(signin,pane,SignInBtn,vb3);
        pane.setVgap(10);
        pane.setHgap(5);
        BorderPane mypane = new BorderPane();
        //root.setStyle("-fx-background-color: floralwhite;");
        mypane.setTop(all);
        mypane.setCenter(vb2);
        mypane.setBottom(backhb);
        root.getChildren().add(new ImageView(RecruitmentSystem.Background));
        root.getChildren().add(mypane);
        SignInBtn.setOnAction(new EventHandler<ActionEvent> (){
            @Override
            public void handle(ActionEvent event) {
                try{
                String user = enteruser.getText();
                String pass = enterpass.getText();
                String confirmedpass = enterpass2.getText();
                Register reg = new Register();
                if(pass.equals(confirmedpass))
                {
                    if(reg.checkemployer(user, pass) == false)
                    {
                        reg.regAsEmployer(user, pass);
                        primaryStage.setScene(new SignInEmployer(new StackPane(),1200,700, primaryStage));
                    }
                    else
                    {
                        error.setText("Username already taken");
                    }
                }
                else
                {
                    error.setText("Password Mismatch");
                }
                }
                catch(IOException ex)
                {
                    System.out.println(ex);
                }
            }
        });
    }
    
}
