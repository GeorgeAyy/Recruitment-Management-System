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
import javafx.geometry.Side;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import main.Employers;
import main.Register;

/**
 *
 * @author georg
 */
public class SignInEmployer extends Scene {

    public SignInEmployer(StackPane root, double d, double d1, Stage primaryStage) {
        super(root, d, d1);
        Label logo = new Label("CareerPal");
        logo.setStyle("-fx-text-fill: white;");
        ImageView homeimage = new ImageView(RecruitmentSystem.Home);
        homeimage.minHeight(10);
        homeimage.minWidth(10);
        Button home = new Button("", homeimage);
        home.setStyle("-fx-background-color: cornflowerblue; -fx-cursor: hand;-fx-background-radius: 15px; -fx-text-fill: #ffffff");
        home.setOnAction(new EventHandler<ActionEvent>() {
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
                primaryStage.setScene(new SignInOptions(new StackPane(), 1200, 700, primaryStage));
            }
        });
        HBox backhb = new HBox(back);
        backhb.setAlignment(Pos.BOTTOM_LEFT);
        backhb.setPadding(new Insets(5, 5, 30, 5));

        VBox all = new VBox();
        HBox hb3 = new HBox(home);
        hb3.setAlignment(Pos.TOP_RIGHT);
        hb3.setPadding(new Insets(15, 0, 0, 0));
        HBox hb2 = new HBox();
        hb2.getChildren().add(logo);
        hb2.setPadding(new Insets(30, 0, 0, 0));
        hb2.setAlignment(Pos.CENTER);
        logo.setFont(Font.font("Lucida Calligraphy", 26)); //seting font and size
        all.getChildren().addAll(hb3, hb2);
        Label signin = new Label("Sign In as Employer");
        signin.setStyle("-fx-text-fill: white;");
        signin.setFont(Font.font("Elephant", 16));
        VBox vb2 = new VBox(30);
        vb2.setAlignment(Pos.TOP_CENTER);
        vb2.setPadding(new Insets(20, 0, 0, 0));
        Label Username = new Label("Username");
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
        Button SignInBtn = new Button("Sign In");
        TextField enteruser = new TextField();
        enteruser.setPrefColumnCount(15);
        GridPane pane = new GridPane();
        pane.setAlignment(Pos.CENTER);
        pane.addColumn(0, Username, enteruser, Password, enterpass);
        pane.add(shownpass, 0, 3);
        pane.add(showPass, 1, 3);
        SignInBtn.setMinSize(294, 30);
        SignInBtn.setStyle("-fx-background-color: cornflowerblue; -fx-cursor: hand;-fx-background-radius: 15px; -fx-text-fill: #ffffff");
        Label newpal = new Label("New User?");
        newpal.setStyle("-fx-text-fill: white;");
        Hyperlink hl = new Hyperlink("Click here!");
        hl.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                primaryStage.setScene(new SignUpEmployer(new StackPane(), 1200, 700, primaryStage));
            }

        });

        VBox btnhl = new VBox();
        btnhl.getChildren().addAll(hl, backhb);
        btnhl.setAlignment(Pos.TOP_CENTER);

        HBox hb = new HBox(5);
        hb.setAlignment(Pos.TOP_CENTER);
        hb.getChildren().addAll(newpal, hl);
        VBox vb3 = new VBox();
        Label error = new Label("");
        error.setStyle("-fx-text-fill: red;");
        vb3.getChildren().addAll(hb, error);
        vb3.setAlignment(Pos.TOP_CENTER);
        vb2.getChildren().addAll(signin, pane, SignInBtn, vb3);
        pane.setVgap(10);
        pane.setHgap(5);
        BorderPane mypane = new BorderPane();
        //root.setStyle("-fx-background-color: floralwhite;");
        mypane.setTop(all);
        mypane.setCenter(vb2);
        mypane.setBottom(btnhl);
        root.getChildren().add(new ImageView(RecruitmentSystem.Background));
        root.getChildren().add(mypane);
        SignInBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                try {
                    String username = enteruser.getText();
                    String password = enterpass.getText();
                    Register r = new Register();
                    int index = 0;
                    if (r.loginAsEmployer(username, password, index) == true) {
                        primaryStage.setScene(new EmployerScreen(new StackPane(), (double) 1200, (double) 700, primaryStage, r.getEmployer(username), index));
                    } else {
                        error.setText("Username already taken");
                    }
                } catch (IOException e) {
                    error.setText("Error");
                }
            }
        });
    }

}
