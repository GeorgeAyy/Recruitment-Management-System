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
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import main.Employee;
import main.Employers;

/**
 *
 * @author fatim
 */
public class EmployeeScreen extends Scene {

    public EmployeeScreen(StackPane root, double d, double d1, Stage primaryStage, Employee employee, int index) {
        super(root, d, d1);
        ImageView homeimage = new ImageView(RecruitmentSystem.Home);

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

        VBox txt = new VBox();
        txt.getChildren().addAll(hb1, hb);

        Button setcv = new Button("Set/edit CV");
        setcv.setStyle("-fx-background-color: cornflowerblue;-fx-cursor: hand; -fx-background-radius: 15px; -fx-text-fill: #ffffff");
        setcv.setMinSize(294, 30);
        setcv.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                primaryStage.setScene(new SetCV(new StackPane(), 1200, 800, primaryStage, employee, index));
            }
        });

        Button searchjob = new Button("Search/apply for a job");
        searchjob.setStyle("-fx-background-color: cornflowerblue;-fx-cursor: hand; -fx-background-radius: 15px; -fx-text-fill: #ffffff");
        searchjob.setMinSize(294, 30);
        searchjob.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                primaryStage.setScene(new searchJobs(new StackPane(), 1200, 700, primaryStage, employee, index));
            }
        });

        Button interview = new Button("Display your interview ");
        interview.setStyle("-fx-background-color: cornflowerblue;-fx-cursor: hand; -fx-background-radius: 15px; -fx-text-fill: #ffffff");
        interview.setMinSize(294, 30);
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
                primaryStage.setScene(new SigninEmployee(new StackPane(), 1200, 700, primaryStage));
            }
        });
        HBox backhb = new HBox(back);
        backhb.setAlignment(Pos.BOTTOM_LEFT);
        backhb.setPadding(new Insets(5, 5, 30, 5));
        Label error = new Label("");
        error.setStyle("-fx-text-fill: red;");
        VBox btns = new VBox(30);
        btns.getChildren().addAll(setcv, searchjob, interview, logout, error);
        btns.setAlignment(Pos.TOP_CENTER);
        btns.setPadding(new Insets(70, 5, 5, 20));
        BorderPane mypane = new BorderPane();
        mypane.setTop(txt);
        mypane.setCenter(btns);
        mypane.setBottom(back);
        interview.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                primaryStage.setScene(new DisplayInterviews(new StackPane(), 1200, 700, primaryStage, employee, index));
            }
        });

        root.getChildren().add(new ImageView(RecruitmentSystem.Background));
        root.getChildren().add(mypane);

    }

}
