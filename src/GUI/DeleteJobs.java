/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import main.Employee;
import main.Jobs;

/**
 *
 * @author fatim
 */
public class DeleteJobs extends Scene {

    public DeleteJobs(StackPane root, double d, double d1, Stage primaryStage) throws ClassNotFoundException {
        super(root, d, d1);

        ImageView homeimage = new ImageView(RecruitmentSystem.Home);
        Button home = new Button("", homeimage);
        home.setStyle("-fx-background-color: cornflowerblue; -fx-cursor: hand;-fx-background-radius: 15px; -fx-text-fill: #ffffff");
        home.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                primaryStage.setScene(new MainLogin(new StackPane(), 1200, 700, primaryStage));
            }
        });

        HBox homehb = new HBox();
        homehb.getChildren().add(home);
        homehb.setAlignment(Pos.TOP_RIGHT);
        Label text = new Label("Delete Jobs");
        text.setFont(Font.font("Elephant", 20));
        text.setStyle("-fx-text-fill: white;");

        HBox txt = new HBox();
        txt.getChildren().add(text);
        txt.setAlignment(Pos.CENTER);

        VBox vb = new VBox();
        vb.getChildren().addAll(homehb, txt);

        ComboBox cb = new ComboBox();
        ComboBox cb1 = new ComboBox();
        ComboBox cb2 = new ComboBox();
        ComboBox cb3 = new ComboBox();
        ArrayList<Jobs> professionalJob = new ArrayList<Jobs>();
        ArrayList<Jobs> skilledJob = new ArrayList<Jobs>();
        ArrayList<Jobs> highlySkilledJob = new ArrayList<Jobs>();
        ArrayList<Jobs> semiSkilledJob = new ArrayList<Jobs>();
        String[] jobNames = {"Professional", "Skilled", "Highly Skilled", "Semi-Skilled"};

        try {
            File file = new File(jobNames[0] + ".ser");
            if (file.exists()) {
                FileInputStream fis2 = new FileInputStream(file);
                ObjectInputStream ois2 = new ObjectInputStream(fis2);
                professionalJob.addAll((ArrayList<Jobs>) ois2.readObject());
                fis2.close();
            }
        } catch (ClassCastException | IOException ex) {
            ex.printStackTrace();
        }
        try {
            File file = new File(jobNames[1] + ".ser");
            if (file.exists()) {
                FileInputStream fis2 = new FileInputStream(file);
                ObjectInputStream ois2 = new ObjectInputStream(fis2);
                skilledJob.addAll((ArrayList<Jobs>) ois2.readObject());
                fis2.close();
            }
        } catch (ClassCastException | IOException ex) {
            ex.printStackTrace();
        }
        try {
            File file = new File(jobNames[2] + ".ser");
            if (file.exists()) {
                FileInputStream fis2 = new FileInputStream(file);
                ObjectInputStream ois2 = new ObjectInputStream(fis2);
                highlySkilledJob.addAll((ArrayList<Jobs>) ois2.readObject());
                fis2.close();
            }
        } catch (ClassCastException | IOException ex) {
            ex.printStackTrace();
        }
        try {
            File file = new File(jobNames[3] + ".ser");
            if (file.exists()) {
                FileInputStream fis2 = new FileInputStream(file);
                ObjectInputStream ois2 = new ObjectInputStream(fis2);
                semiSkilledJob.addAll((ArrayList<Jobs>) ois2.readObject());
                fis2.close();
            }
        } catch (ClassCastException | IOException ex) {
            ex.printStackTrace();
        }
        ArrayList<String> professionalNamesList = new ArrayList<String>();
        ArrayList<String> skilledNamesList = new ArrayList<String>();
        ArrayList<String> highlySkilledNamesList = new ArrayList<String>();
        ArrayList<String> semiSkilledNamesList = new ArrayList<String>();
        for (int i = 0; i < professionalJob.size(); i++) {
            professionalNamesList.add(professionalJob.get(i).getJobName());
        }
        for (int i = 0; i < skilledJob.size(); i++) {
            skilledNamesList.add(skilledJob.get(i).getJobName());
        }
        for (int i = 0; i < highlySkilledJob.size(); i++) {
            highlySkilledNamesList.add(highlySkilledJob.get(i).getJobName());
        }
        for (int i = 0; i < semiSkilledJob.size(); i++) {
            semiSkilledNamesList.add(semiSkilledJob.get(i).getJobName());
        }
        final ObservableList<String> professionaldata = FXCollections.observableList(professionalNamesList);
        final ObservableList<String> skilleddata = FXCollections.observableList(skilledNamesList);
        final ObservableList<String> highlyskilleddata = FXCollections.observableList(highlySkilledNamesList);
        final ObservableList<String> semiskilleddata = FXCollections.observableList(semiSkilledNamesList);
        cb.setItems(professionaldata);
        cb1.setItems(skilleddata);
        cb2.setItems(highlyskilleddata);
        cb3.setItems(semiskilleddata);

        Button delete = new Button("delete jobs");
        delete.setStyle("-fx-background-color: cornflowerblue; -fx-cursor: hand;-fx-background-radius: 15px; -fx-text-fill: #ffffff");
        delete.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (cb.getValue() != null) {
                    try {
                        ArrayList<Jobs> job = new ArrayList<Jobs>();
                        FileInputStream fis = new FileInputStream("Professional.ser");
                        ObjectInputStream Ois = new ObjectInputStream(fis);
                        job = (ArrayList<Jobs>) Ois.readObject();
                        fis.close();
                        int index = cb.getSelectionModel().getSelectedIndex();
                        job.remove(index);
                        professionalNamesList.remove(index);
                        FileOutputStream fos = new FileOutputStream("Professional.ser");
                        ObjectOutputStream oos = new ObjectOutputStream(fos);
                        oos.writeObject(job);
                        final ObservableList<String> professionaldata = FXCollections.observableList(professionalNamesList);
                        cb.setItems(professionaldata);
                    } catch (IOException | ClassNotFoundException ex) {

                    }

                }

            }

        });

        Button delete1 = new Button("delete jobs");
        delete1.setStyle("-fx-background-color: cornflowerblue; -fx-cursor: hand;-fx-background-radius: 15px; -fx-text-fill: #ffffff");
        delete1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (cb1.getValue() != null) {
                    try {
                        ArrayList<Jobs> job = new ArrayList<Jobs>();
                        FileInputStream fis = new FileInputStream("Skilled.ser");
                        ObjectInputStream Ois = new ObjectInputStream(fis);
                        job = (ArrayList<Jobs>) Ois.readObject();
                        fis.close();
                        int index = cb1.getSelectionModel().getSelectedIndex();
                        job.remove(index);
                        skilledNamesList.remove(index);
                        FileOutputStream fos = new FileOutputStream("Skilled.ser");
                        ObjectOutputStream oos = new ObjectOutputStream(fos);
                        oos.writeObject(job);
                        final ObservableList<String> skilleddata = FXCollections.observableList(skilledNamesList);
                        cb1.setItems(skilleddata);
                    } catch (IOException | ClassNotFoundException ex) {

                    }

                }

            }

        });

        Button delete2 = new Button("delete jobs");
        delete2.setStyle("-fx-background-color: cornflowerblue; -fx-cursor: hand;-fx-background-radius: 15px; -fx-text-fill: #ffffff");
        delete2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (cb2.getValue() != null) {
                    try {
                        ArrayList<Jobs> job = new ArrayList<Jobs>();
                        FileInputStream fis = new FileInputStream("Highly Skilled.ser");
                        ObjectInputStream Ois = new ObjectInputStream(fis);
                        job = (ArrayList<Jobs>) Ois.readObject();
                        fis.close();
                        int index = cb2.getSelectionModel().getSelectedIndex();
                        job.remove(index);
                        highlySkilledNamesList.remove(index);
                        FileOutputStream fos = new FileOutputStream("Highly Skilled.ser");
                        ObjectOutputStream oos = new ObjectOutputStream(fos);
                        oos.writeObject(job);
                        final ObservableList<String> highlyskilleddata = FXCollections.observableList(highlySkilledNamesList);
                        cb2.setItems(highlyskilleddata);
                    } catch (IOException | ClassNotFoundException ex) {

                    }

                }

            }

        });

        Button delete3 = new Button("delete jobs");
        delete3.setStyle("-fx-background-color: cornflowerblue; -fx-cursor: hand;-fx-background-radius: 15px; -fx-text-fill: #ffffff");
        delete3.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (cb3.getValue() != null) {
                    try {
                        ArrayList<Jobs> job = new ArrayList<Jobs>();
                        FileInputStream fis = new FileInputStream("Semi-Skilled.ser");
                        ObjectInputStream Ois = new ObjectInputStream(fis);
                        job = (ArrayList<Jobs>) Ois.readObject();
                        fis.close();
                        int index = cb3.getSelectionModel().getSelectedIndex();
                        job.remove(index);
                        semiSkilledNamesList.remove(index);
                        FileOutputStream fos = new FileOutputStream("Semi-Skilled.ser");
                        ObjectOutputStream oos = new ObjectOutputStream(fos);
                        oos.writeObject(job);
                        final ObservableList<String> semiskilleddata = FXCollections.observableList(semiSkilledNamesList);
                        cb3.setItems(semiskilleddata);
                    } catch (IOException | ClassNotFoundException ex) {

                    }

                }

            }

        });

        Label label = new Label("Professional: ");
        label.setStyle("-fx-text-fill: white;");
        Label label1 = new Label("Skilled: ");
        label1.setStyle("-fx-text-fill: white;");
        Label label2 = new Label("Highly Skilled: ");
        label2.setStyle("-fx-text-fill: white;");
        Label label3 = new Label("Semi-Skilled: ");
        label3.setStyle("-fx-text-fill: white;");

        ImageView backbtn = new ImageView(RecruitmentSystem.BackBtn);
        Button back = new Button("", backbtn);
        back.setStyle("-fx-background-color: cornflowerblue; -fx-cursor: hand;-fx-background-radius: 15px; -fx-text-fill: #ffffff");
        back.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                primaryStage.setScene(new AdminScreen(new StackPane(), 1200, 700, primaryStage));
            }

        });

        HBox backhb = new HBox(back);
        backhb.setAlignment(Pos.BASELINE_LEFT);

        GridPane pane = new GridPane();
        pane.setAlignment(Pos.CENTER);
        pane.addColumn(0, label, label1, label2, label3);
        pane.addColumn(1, cb, cb1, cb2, cb3);
        pane.addColumn(2, delete, delete1, delete2, delete3);
        pane.setHgap(10);
        pane.setVgap(10);
        VBox vb1 = new VBox(10);
        vb1.getChildren().add(pane);
        vb1.setAlignment(Pos.CENTER);
        BorderPane bp = new BorderPane();
        bp.setTop(vb);
        bp.setCenter(vb1);
        bp.setBottom(backhb);
        root.getChildren().add(new ImageView(RecruitmentSystem.Background));
        root.getChildren().add(bp);

    }

}
