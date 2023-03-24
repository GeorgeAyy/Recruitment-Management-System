/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;

import com.sun.security.auth.module.JndiLoginModule;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Optional;
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
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import main.Employers;
import main.Jobs;

/**
 *
 * @author fatim
 */
public class Addjobs extends Scene {
    
    public Addjobs(StackPane root, double d, double d1,Stage primaryStage,Employers employer,int index) {
        super(root, d, d1);
        ImageView homeimage = new ImageView(RecruitmentSystem.Home);
            homeimage.minHeight(10);
            homeimage.minWidth(10);
            Button home=new Button("",homeimage);
            home.setStyle("-fx-background-color: cornflowerblue; -fx-cursor: hand;-fx-background-radius: 15px; -fx-text-fill: #ffffff");
            home.setOnAction(new EventHandler<ActionEvent>(){
                @Override
                public void handle(ActionEvent event) {
                  primaryStage.setScene(new MainLogin(new StackPane(),1200,700,primaryStage));
                }
            });
            HBox homehb =new HBox();
            homehb.setAlignment(Pos.TOP_RIGHT);
            homehb.setPadding(new Insets(5,5,0,0));
            homehb.getChildren().add(home);
            
            Label text=new Label("Add job");
            text.setStyle("-fx-text-fill: white;");
            text.setFont(Font.font("Eelephant",20));
                 
            HBox texthb=new HBox();
             texthb.getChildren().addAll(text);
             texthb.setAlignment(Pos.CENTER);
            
            //top vertical box that holds home button and the name of the page
            VBox top=new VBox(20);
            top.getChildren().addAll(homehb,texthb);
            top.setAlignment(Pos.CENTER);
           
          
            Label cat=new Label("category:");
              cat.setStyle("-fx-text-fill: white;");
            //options is the HBox that has both the categories and their choices
            HBox options=new HBox(10);
        ObservableList<String> items = FXCollections.observableArrayList(
                "Professional",
                "Highly Skilled",
                "Skilled",
                "Semi-Skilled");
           
           ComboBox comboBox = new ComboBox(items);
           options.getChildren().addAll(cat,comboBox);
           
           //Jntxtbx is the job name Hbox that holds the text field and job name 
           
           Label Jn=new Label("Job Name:");
           Jn.setStyle("-fx-text-fill: white;");
           HBox hb = new HBox();
           TextField Jn1=new TextField();
           hb.getChildren().add(Jn1);
           
             //JLtxtbx is the job name Hbox that holds the text field and job name 
            Label JL=new Label("Job Locations:");
            JL.setStyle("-fx-text-fill: white;");
           TextField JL1=new TextField();
           HBox hb2 = new HBox(JL1);
            Label SR=new Label("Skill required:");
            SR.setStyle("-fx-text-fill: white;");
           TextField SR1=new TextField();        
           HBox hb3 = new HBox(SR1);
           Label Salary=new Label("Salary:");
           Salary.setStyle("-fx-text-fill: white;");
           TextField Salary1=new TextField();        
           Salary1.textProperty().addListener((ObservableValue<? extends String> observable, String oldValue, String newValue) -> {
           if (!newValue.matches("\\d*")) {
               Salary1.setText(newValue.replaceAll("[^\\d]", ""));
           }
           });
           HBox hb4 = new HBox(Salary1);
            Label ER=new Label("Experience required:  ");
            ER.setStyle("-fx-text-fill: white;");
           TextField ER1=new TextField();
           HBox hb5 = new HBox(ER1);
           Label JD=new Label("Job description:");
           JD.setStyle("-fx-text-fill: white;");
           TextArea JD1=new TextArea();
           HBox hb6 = new HBox(JD1);
           VBox vb=new VBox();
         //  vb.getChildren().addAll(top,Jntxtbx,JLtxtbx,SRtxtbx,Salarytxtbx,ERtxtbx,JDtxtbx);
           
            ImageView backimage = new ImageView(RecruitmentSystem.BackBtn);
            Button back=new Button("",backimage);
            back.setStyle("-fx-background-color: cornflowerblue; -fx-cursor: hand;-fx-background-radius: 15px; -fx-text-fill: #ffffff");
            back.setOnAction(new EventHandler<ActionEvent>(){
                @Override
                public void handle(ActionEvent event) {
                  primaryStage.setScene(new EmployerScreen(new StackPane(),1200,700,primaryStage,employer,index));
                }
            });
            HBox backhb=new HBox(back);
            backhb.setAlignment(Pos.BOTTOM_LEFT);
            backhb.setPadding(new Insets(5,5,20,5));
            Button save = new Button("Save");
            
            
            GridPane pane = new GridPane();
            pane.setAlignment(Pos.CENTER);
            pane.addColumn(0,cat,Jn,JL,SR,Salary,ER,JD);
            pane.add(comboBox, 1, 0);
            pane.add(hb, 1, 1);
            pane.add(hb2, 1, 2);
            pane.add(hb3, 1, 3);
            pane.add(hb4, 1, 4);
            pane.add(hb5, 1, 5);
            pane.add(hb6, 1, 6);
            pane.add(save, 2, 7);
            save.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {
                if(Jn1.getText().isEmpty()|| 
                        JL1.getText().isEmpty()||
                        SR1.getText().isEmpty()||
                        Salary1.getText().isEmpty()||
                        ER1.getText().isEmpty()||
                        JD1.getText().isEmpty()||
                        comboBox.getValue()==null)
                {
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Input fields empty");
                    alert.setContentText("Please fill all input fields");
                    alert.showAndWait(); 
                }
                else
                {
                    try{
                        String profession = (String) comboBox.getValue();
                        String jobName = Jn1.getText();
                        String jobLocation = JL1.getText();
                        String skill = SR1.getText();
                        String salary = Salary1.getText();
                        String experience = ER1.getText();
                        String jobDescription = JD1.getText();
                        Jobs newJob;
                        newJob = new Jobs(profession,jobName,jobLocation,skill,salary,experience,jobDescription,employer);
                        try{
                            FileInputStream fis = new FileInputStream(profession+".ser");
                            ObjectInputStream ois = new ObjectInputStream(fis);
                            ArrayList<Jobs> jobList= new ArrayList<>();
                            jobList = (ArrayList<Jobs>) ois.readObject();
                            jobList.add(newJob);
                            FileOutputStream fos = new FileOutputStream(profession+".ser");
                            ObjectOutputStream oos = new ObjectOutputStream(fos);
                            oos.writeObject(jobList);
                        }
                        catch(IOException | ClassNotFoundException ex)
                        {
                            ArrayList<Jobs> jobList= new ArrayList<>();
                            jobList.add(newJob);
                            FileOutputStream fos = new FileOutputStream(profession+".ser");
                            ObjectOutputStream oos = new ObjectOutputStream(fos);
                            oos.writeObject(jobList);
                        }
                        Alert alert2=new Alert(Alert.AlertType.CONFIRMATION);
                        alert2.setTitle("Confirmation Dialog");
                        alert2.setHeaderText(" Saved Sucessfully! ");
                        Optional<ButtonType> result = alert2.showAndWait();
                        ButtonType button = result.orElse(ButtonType.CANCEL);
                        
                        if (button == ButtonType.OK) {
                            primaryStage.setScene(new EmployerScreen(new StackPane(),1200,700,primaryStage, employer,index));
                        }
                    }
                    catch(IOException ex)
                    {
                        Logger.getLogger(Addjobs.class.getName()).log(Level.SEVERE, null, ex);
                        
                    }
                }
            }
            });
            
            pane.setVgap(20);
            BorderPane mypane = new BorderPane();
        
            mypane.setTop(top);
           
            mypane.setCenter(pane);
            mypane.setBottom(backhb);
            root.getChildren().add(new ImageView(RecruitmentSystem.Background));
            root.getChildren().add(mypane);
    
    }
    
}
