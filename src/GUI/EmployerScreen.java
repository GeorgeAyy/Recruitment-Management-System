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
import main.Employers;

/**
 *
 * @author fatim
 */
public class EmployerScreen extends Scene {

    public EmployerScreen(StackPane root, double d, double d1, Stage primaryStage, Employers employer, int index) {
        super(root, d, d1);

        ImageView homeimage = new ImageView(RecruitmentSystem.Home);
        homeimage.minHeight(10);
        homeimage.minWidth(10);
        Button home = new Button("", homeimage);
        home.setStyle("-fx-background-color: cornflowerblue;-fx-cursor: hand; -fx-background-radius: 15px; -fx-text-fill: #ffffff");
        home.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                primaryStage.setScene(new MainLogin(new StackPane(), 1200, 700, primaryStage));
            }
        });
        Label choices = new Label("Pick one of the following choices ");
        choices.setFont(Font.font("Elephant", 20));
        choices.setStyle("-fx-text-fill: white;");
        HBox hb = new HBox();
        hb.getChildren().add(choices);
        hb.setAlignment(Pos.CENTER);
        hb.setPadding(new Insets(50, 5, 5, 5));
        HBox hb1 = new HBox();
        hb1.getChildren().add(home);
        hb1.setAlignment(Pos.TOP_RIGHT);
        hb1.setPadding(new Insets(5, 5, 5, 5));

        VBox txt = new VBox(10);
        txt.getChildren().addAll(hb1, hb);

        Button offers = new Button("Add job offers");
        offers.setStyle("-fx-background-color: cornflowerblue;-fx-cursor: hand; -fx-background-radius: 15px; -fx-text-fill: #ffffff");
        offers.setMinSize(294, 30);
        offers.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                primaryStage.setScene(new Addjobs(new StackPane(), 1200, 700, primaryStage, employer, index));
            }
        });
        Button showjob = new Button("show job applications");
        showjob.setStyle("-fx-background-color: cornflowerblue;-fx-cursor: hand; -fx-background-radius: 15px; -fx-text-fill: #ffffff");
        showjob.setMinSize(294, 30);
        showjob.setOnAction((ActionEvent event) -> {
            try {
                primaryStage.setScene(new ShowJobs(new StackPane(), 1200, 700, primaryStage, employer, index));
            } catch (IOException | ClassNotFoundException ex) {
                ex.printStackTrace();
            }
        });
        Button logout = new Button("logout");
        logout.setStyle("-fx-background-color: cornflowerblue;-fx-cursor: hand; -fx-background-radius: 15px; -fx-text-fill: #ffffff");
        logout.setMinSize(294, 30);
        logout.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                primaryStage.setScene(new MainLogin(new StackPane(), 1200, 700, primaryStage));
            }

        });
        ImageView backimage = new ImageView(RecruitmentSystem.BackBtn);
        Button back = new Button("", backimage);
        back.setStyle("-fx-background-color: cornflowerblue; -fx-cursor: hand;-fx-background-radius: 15px; -fx-text-fill: #ffffff");
        back.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                primaryStage.setScene(new SignInEmployer(new StackPane(), 1200, 700, primaryStage));
            }
        });
        HBox backhb = new HBox(back);
        backhb.setAlignment(Pos.BOTTOM_LEFT);
        backhb.setPadding(new Insets(5, 5, 30, 5));

        VBox btns = new VBox(30);
        btns.getChildren().addAll(offers, showjob, logout);
        btns.setAlignment(Pos.TOP_CENTER);
        btns.setPadding(new Insets(10, 5, 5, 20));
        BorderPane mypane = new BorderPane();
        mypane.setTop(txt);
        mypane.setCenter(btns);
        mypane.setBottom(back);

        root.getChildren().add(new ImageView(RecruitmentSystem.Background));
        root.getChildren().add(mypane);

    }

}
