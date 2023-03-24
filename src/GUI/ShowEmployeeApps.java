/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Dialog;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import main.Employee;
import main.Employers;
import main.Interviews;
import main.Jobs;

/**
 *
 * @author georg
 */
public class ShowEmployeeApps extends Scene {

    public ShowEmployeeApps(StackPane root, double d, double d1, Stage primaryStage, Jobs job, Employers employer, int index) throws FileNotFoundException, IOException, ClassNotFoundException {
        super(root, d, d1);
        BorderPane bp = new BorderPane();
        Label text = new Label("Employees that applied");
        text.setFont(Font.font("Elephant", 20));
        text.setStyle("-fx-text-fill: white;");
        HBox hb = new HBox();
        hb.getChildren().add(text);
        hb.setAlignment(Pos.CENTER);
        ImageView homeimage = new ImageView(RecruitmentSystem.Home);
        Button home = new Button("", homeimage);
        home.setStyle("-fx-background-color: cornflowerblue;-fx-cursor: hand; -fx-background-radius: 15px; -fx-text-fill: #ffffff");
        home.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                primaryStage.setScene(new MainLogin(new StackPane(), 1200, 700, primaryStage));
            }
        });
        HBox homehb = new HBox();
        homehb.getChildren().add(home);
        homehb.setAlignment(Pos.TOP_RIGHT);

        VBox vb = new VBox();
        vb.getChildren().addAll(homehb, hb);
        vb.setAlignment(Pos.TOP_CENTER);

        Button btn = new Button("show CV");
        btn.setStyle("-fx-background-color: cornflowerblue;-fx-cursor: hand; -fx-background-radius: 15px; -fx-text-fill: #ffffff");
        Button btn2 = new Button("accept");
        btn2.setStyle("-fx-background-color: cornflowerblue;-fx-cursor: hand; -fx-background-radius: 15px; -fx-text-fill: #ffffff");
        ComboBox cb1 = new ComboBox();
        ArrayList<Employee> employeeList = new ArrayList<>();
        Label error = new Label("");
        error.setStyle("-fx-text-fill: red;");
        FileInputStream fis = new FileInputStream(job.getJobName() + ".ser");
        ObjectInputStream ois = new ObjectInputStream(fis);
        employeeList = (ArrayList<Employee>) ois.readObject();
        ArrayList<String> namesList = new ArrayList<>();
        for (int i = 0; i < employeeList.size(); i++) {
            namesList.add(employeeList.get(i).getEmail());
        }
        btn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println(cb1.getValue());
            }
        });

        btn2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (cb1.getValue() != null) {
                    Dialog dialog = new Dialog();
                    dialog.setTitle("Acceptance message");
                    dialog.setHeaderText("Enter the interview details for the employee:");
                    TextArea textArea = new TextArea();
                    textArea.setPrefSize(300, 200);
                    textArea.setWrapText(true);
                    dialog.getDialogPane().setContent(textArea);
                    ButtonType done = new ButtonType("Done", ButtonData.OK_DONE);
                    dialog.getDialogPane().getButtonTypes().setAll(done);
                    Optional<ButtonType> result = dialog.showAndWait();
                    if (result.get() == done && !(textArea.getText().isEmpty())) {
                        try {
                            Interviews newInterview = new Interviews(job.getJobName() + " Acceptance message: " + textArea.getText(), employer.getEmail(), (String) cb1.getValue());
                        } catch (IOException ex) {
                            Logger.getLogger(ShowEmployeeApps.class.getName()).log(Level.SEVERE, null, ex);
                        } catch (ClassNotFoundException ex) {
                            Logger.getLogger(ShowEmployeeApps.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                }
            }
        });
        ImageView backimage = new ImageView(RecruitmentSystem.BackBtn);
        Button back = new Button("", backimage);
        back.setStyle("-fx-background-color: cornflowerblue;-fx-cursor: hand; -fx-background-radius: 15px; -fx-text-fill: #ffffff");
        HBox backhb = new HBox();
        backhb.getChildren().add(back);
        back.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                try {
                    primaryStage.setScene(new ShowJobs(new StackPane(), 1200, 700, primaryStage, employer, index));
                } catch (IOException ex) {
                    Logger.getLogger(ShowEmployeeApps.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(ShowEmployeeApps.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

        });

        HBox hb1 = new HBox(10);
        hb1.getChildren().addAll(cb1, btn, btn2);
        hb1.setAlignment(Pos.CENTER);
        final ObservableList<String> data = FXCollections.observableList(namesList);
        cb1.setItems(data);
        bp.setTop(vb);
        bp.setCenter(hb1);
        bp.setBottom(back);

        root.getChildren().add(new ImageView(RecruitmentSystem.Background));
        root.getChildren().add(bp);
        btn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                try {
                    ArrayList<Employee> employeeList = new ArrayList<>();
                    FileInputStream fis = new FileInputStream(job.getJobName() + ".ser");
                    ObjectInputStream ois = new ObjectInputStream(fis);
                    employeeList = (ArrayList<Employee>) ois.readObject();
                    for (int i = 0; i < namesList.size(); i++) {
                        if (employeeList.get(i).getEmail().equals((String) cb1.getValue())) {
                            primaryStage.setScene(new DisplayCV(new StackPane(), 1200, 700, primaryStage, employeeList.get(i), index, employer, job));
                        }
                    }
                } catch (IOException | ClassNotFoundException ex) {
                    Logger.getLogger(ShowEmployeeApps.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }
}
