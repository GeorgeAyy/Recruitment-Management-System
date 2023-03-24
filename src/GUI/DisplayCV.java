/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;

import static GUI.RecruitmentSystem.BackBtn;
import static GUI.RecruitmentSystem.Background;
import static GUI.RecruitmentSystem.Home;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.value.ObservableValue;
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
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import main.Employee;
import main.Employers;
import main.Jobs;

/**
 *
 * @author georg
 */
public class DisplayCV extends Scene {

    public DisplayCV(StackPane root, double d, double d1, Stage primaryStage, Employee emp, int index, Employers employer, Jobs job) {
        super(root, d, d1);
        primaryStage.setTitle("CV form");

        Label text = new Label("Display CV");
        text.setStyle("-fx-text-fill: white;");
        text.setAlignment(Pos.CENTER);
        text.setFont(Font.font("Lucida Calligraphy", 30));
        HBox txt = new HBox(20);
        txt.getChildren().add(text);
        txt.setAlignment(Pos.TOP_CENTER);
        txt.setPadding(new Insets(10, 5, 5, 5));

        VBox components = new VBox();
        Label fn = new Label("firstname:");
        fn.setStyle("-fx-text-fill: white;");
        TextField fn1 = new TextField(emp.getfName());
        fn1.setEditable(false);
        HBox fnhb = new HBox(5);
        fnhb.getChildren().addAll(fn, fn1);
        Label ln = new Label("Lastname:");
        ln.setStyle("-fx-text-fill: white;");
        TextField ln1 = new TextField(emp.getlName());
        ln1.setEditable(false);
        HBox lnhb = new HBox(5);
        lnhb.getChildren().addAll(ln, ln1);
        Label db = new Label("Dateofbirth:");
        db.setStyle("-fx-text-fill: white;");
        DatePicker db1 = new DatePicker(emp.getDoB());
        db1.setDisable(true);
        db1.setStyle("-fx-opacity: 1");
        db1.getEditor().setStyle("-fx-opacity: 1");
        HBox dbhb = new HBox(5);
        dbhb.getChildren().addAll(db, db1);
        Label gndr = new Label("Gender:");
        gndr.setStyle("-fx-text-fill: white;");
        //pane.add(fc,0,4);
        final ToggleGroup radioGroup = new ToggleGroup();
        RadioButton g = new RadioButton("Male");
        g.setStyle("-fx-text-fill:white;");
        g.setToggleGroup(radioGroup);
        g.setDisable(true);
        RadioButton g2 = new RadioButton("Female");
        g2.setStyle("-fx-text-fill:white;");
        g2.setToggleGroup(radioGroup);
        g2.setDisable(true);
        if (emp.getGender().equals("Female")) {
            g2.setSelected(true);
        } else {
            g.setSelected(true);
        }
        HBox gndrhb = new HBox(5);
        gndrhb.getChildren().addAll(gndr, g, g2);

        Label pn = new Label("Phone number:");
        pn.setStyle("-fx-text-fill: white;");
        TextField pn1 = new TextField(emp.getpNum());
        pn1.setEditable(false);
        pn1.textProperty().addListener((ObservableValue<? extends String> observable, String oldValue, String newValue) -> {
            if (!newValue.matches("\\d*")) {
                pn1.setText(newValue.replaceAll("[^\\d]", ""));
            }
        });
        HBox pnhb = new HBox(5);
        pnhb.getChildren().addAll(pn, pn1);

        Label email = new Label("Email:");
        email.setStyle("-fx-text-fill: white;");
        TextField email1 = new TextField(emp.getCvEmail());
        email1.setEditable(false);
        HBox emailhb = new HBox(5);
        emailhb.getChildren().addAll(email, email1);

        Label wf = new Label("Workfield:");
        wf.setStyle("-fx-text-fill: white;");
        TextField wf1 = new TextField(emp.getWorkField());
        wf1.setEditable(false);
        HBox wfhb = new HBox(5);
        wfhb.getChildren().addAll(wf, wf1);

        Label skills = new Label("skills:");
        skills.setStyle("-fx-text-fill: white;");
        TextField skills1 = new TextField(emp.getSkills());
        skills1.setEditable(false);
        HBox skillshb = new HBox(5);
        skillshb.getChildren().addAll(skills, skills1);

        Label edu = new Label("Education:");
        edu.setStyle("-fx-text-fill: white;");
        TextField edu1 = new TextField(emp.getEducation());
        edu1.setEditable(false);
        HBox eduhb = new HBox(5);
        eduhb.getChildren().addAll(edu, edu1);

        Label lang = new Label("Languages:");
        lang.setStyle("-fx-text-fill: white;");
        TextField lang1 = new TextField(emp.getLanguages());
        lang1.setEditable(false);
        HBox langhb = new HBox(5);
        langhb.getChildren().addAll(lang, lang1);

        VBox hb = new VBox();

        Label prof = new Label("profession:");

        prof.setStyle("-fx-text-fill: white;");
        ComboBox combobox = new ComboBox();
        if (emp.getProfession().equals("Professional")) {
            combobox.getSelectionModel().select("Professional");
        } else if (emp.getProfession().equals("Highly Skilled")) {
            combobox.getSelectionModel().select("Highly Skilled");
        } else if (emp.getProfession().equals("Skilled")) {
            combobox.getSelectionModel().select("Skilled");
        } else if (emp.getProfession().equals("Semi-Skilled")) {
            combobox.getSelectionModel().select("Semi-Skilled");
        } else {
            combobox.getSelectionModel().select(0);
        }
        combobox.setEditable(false);
        combobox.setDisable(true);
        hb.getChildren().add(combobox);
        HBox profhb = new HBox(5);
        profhb.getChildren().addAll(prof, combobox);
        Label exp = new Label("Experience:");
        exp.setStyle("-fx-text-fill: white;");
        TextArea exp1 = new TextArea(emp.getExperience());
        exp1.setEditable(false);
        exp1.setMinWidth(2);
        HBox exphb = new HBox(5);
        exphb.getChildren().addAll(exp, exp1);
        ImageView backimage = new ImageView(BackBtn);
        Button back = new Button("", backimage);
        back.setStyle("-fx-background-color: cornflowerblue; -fx-cursor: hand;-fx-background-radius: 15px; -fx-text-fill: #ffffff");
        Employee employee = new Employee();

        HBox backhb = new HBox(back);
        backhb.setAlignment(Pos.BOTTOM_LEFT);
        backhb.setPadding(new Insets(5, 5, 30, 5));
        back.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                try {
                    primaryStage.setScene(new ShowEmployeeApps(new StackPane(), 1200, 700, primaryStage, job, employer, index));
                } catch (IOException ex) {
                    Logger.getLogger(DisplayCV.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(DisplayCV.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });

        HBox homz = new HBox();
        ImageView homeimage = new ImageView(Home);
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
        homz.getChildren().add(home);
        homz.setAlignment(Pos.TOP_RIGHT);
        GridPane pane = new GridPane();
        pane.setAlignment(Pos.CENTER);
        pane.addColumn(0, fn, ln, db, gndr, pn, email, wf, skills, edu, lang, prof, exp);
        pane.addColumn(1, fnhb, lnhb, dbhb, gndrhb, pnhb, emailhb, wfhb, skillshb, eduhb, langhb, profhb, exphb);
        pane.setPadding(new Insets(11.5, 12.5, 13.5, 14.5));
        pane.setVgap(5.5);
        BorderPane bp = new BorderPane();
        VBox vb = new VBox();
        vb.getChildren().addAll(homz, txt);
        bp.setTop(vb);
        bp.setCenter(pane);
        bp.setBottom(backhb);
        root.getChildren().add(new ImageView(Background));
        root.getChildren().addAll(bp);
    }
}
