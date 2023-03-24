/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;

import java.io.File;
import java.io.FileInputStream;
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
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import main.Employee;
import static main.JobCate.guiApplyForJob;
import main.Jobs;

/**
 *
 * @author georg
 */
public class searchJobs extends Scene{
    
    public searchJobs(StackPane root, double d, double d1,Stage primaryStage,Employee emp, int index) {
        super(root, d, d1);
        BorderPane bp=new BorderPane();
        Label text=new Label("The list of jobs:");
        text.setFont(Font.font("Elephant",20)); 
            text.setStyle("-fx-text-fill: white;");
            HBox hb =new HBox();
            hb.getChildren().add(text);
            hb.setAlignment(Pos.CENTER);
        ImageView homeimage=new ImageView(RecruitmentSystem.Home);
        Button home=new Button("",homeimage);
        home.setStyle("-fx-background-color: cornflowerblue;-fx-cursor: hand; -fx-background-radius: 15px; -fx-text-fill: #ffffff");
        home.setOnAction(new EventHandler<ActionEvent>(){
                @Override
                public void handle(ActionEvent event) {
                  primaryStage.setScene(new MainLogin(new StackPane(),1200,700,primaryStage));
                }
            });
        HBox homehb=new HBox();
        homehb.getChildren().add(home);
        homehb.setAlignment(Pos.TOP_RIGHT);
        VBox vb =new VBox();
        vb.getChildren().addAll(homehb,hb);
        vb.setAlignment(Pos.TOP_CENTER);
          
        ComboBox cb = new ComboBox();
        ArrayList<Jobs> jobs = new ArrayList<Jobs>();
//        FileInputStream fis = new FileInputStream("Professional" + ".ser");
//            ObjectInputStream ois = new ObjectInputStream(fis);
//            jobs=  (ArrayList<Jobs>) ois.readObject();
//            fis.close();
            
        
            try{
                File file = new File(emp.getProfession() + ".ser");
                if(file.exists())
                {
                    FileInputStream fis2 = new FileInputStream(file);
                    ObjectInputStream ois2 = new ObjectInputStream(fis2);
                    jobs.addAll((ArrayList<Jobs>) ois2.readObject());
                    fis2.close();
                }
            }
            catch(ClassCastException | IOException | ClassNotFoundException ex)
            {
                ex.printStackTrace();
            }
        
        ArrayList<String> namesList = new ArrayList<String>();
        
        for(int i=0;i<jobs.size();i++)
        {
            if((jobs.get(i).getProfession().equals(emp.getProfession())))
            {
                namesList.add(jobs.get(i).getJobName());
            }
        }
        final ObservableList<String> data = FXCollections.observableList(namesList);
        cb.setItems(data);//a sadasdasdas
        Button viewJob = new Button("View Job Details");
        viewJob.setStyle("-fx-background-color: cornflowerblue;-fx-cursor: hand; -fx-background-radius: 15px; -fx-text-fill: #ffffff");
        viewJob.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {
                String input;
                input = (String) cb.getValue();
                for(int i=0;i<jobs.size();i++)
                {
                    if(jobs.get(i).getJobName().equals(input))
                    {
                        primaryStage.setScene(new DisplayJob(new StackPane(),1200,700,primaryStage,emp,jobs.get(i),index));
                    }
                }
            }
        });
        Button Apply= new Button("Apply");
        Apply.setStyle("-fx-background-color: cornflowerblue;-fx-cursor: hand; -fx-background-radius: 15px; -fx-text-fill: #ffffff");
        Apply.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {
                String input;
                input = (String) cb.getValue();
                if(cb.getValue()!=null)
                {
                for(int i=0;i<jobs.size();i++)
                {
                    
                    if(jobs.get(i).getJobName().equals(input))
                    {
                        
                        try {
                            
                            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(jobs.get(i).getJobName() + ".ser"));
                            ArrayList<Employee> myList = new ArrayList<>();
                            boolean found = false;
                            for(int j=0;j<myList.size();j++)
                            {
                                if(myList.get(j).getfName().equals(emp.getfName()))
                                {
                                    found = true;
                                    break;
                                }
                            }
                            if(found == false)
                            {
                                System.out.println("Im here");
                               guiApplyForJob(emp,jobs.get(i));
                               Alert alert2=new Alert(Alert.AlertType.CONFIRMATION);
                                alert2.setTitle("Confirmation Dialog");
                                alert2.setHeaderText(" Saved Sucessfully! ");
                                Optional<ButtonType> result = alert2.showAndWait();
                                ButtonType button = result.orElse(ButtonType.CANCEL);
                                if (button == ButtonType.OK) {
                                    primaryStage.setScene(new EmployeeScreen(new StackPane(),1200,700,primaryStage, emp,index));
                                } 
                            }
                        } catch (IOException | ClassNotFoundException ex) {
                            try {
                                System.out.println("Nah bitch im here");
                                guiApplyForJob(emp,jobs.get(i));
                            } catch (IOException ex1) {
                                Logger.getLogger(searchJobs.class.getName()).log(Level.SEVERE, null, ex1);
                            } catch (ClassNotFoundException ex1) {
                                Logger.getLogger(searchJobs.class.getName()).log(Level.SEVERE, null, ex1);
                            }
                               Alert alert2=new Alert(Alert.AlertType.CONFIRMATION);
                                alert2.setTitle("Confirmation Dialog");
                                alert2.setHeaderText(" Saved Sucessfully! ");
                                Optional<ButtonType> result = alert2.showAndWait();
                                ButtonType button = result.orElse(ButtonType.CANCEL);
                                if (button == ButtonType.OK) {
                                    primaryStage.setScene(new EmployeeScreen(new StackPane(),1200,700,primaryStage, emp,index));
                                } 
                        }
                    }
                }
                
                }
            }
        
        });
        ImageView backimage=new ImageView(RecruitmentSystem.BackBtn);
        Button back=new Button("",backimage);
        back.setStyle("-fx-background-color: cornflowerblue;-fx-cursor: hand; -fx-background-radius: 15px; -fx-text-fill: #ffffff");
       
        HBox backhb=new HBox();
        backhb.getChildren().add(back);
        back.setAlignment(Pos.BASELINE_LEFT);
        
       back.setOnAction(new EventHandler<ActionEvent>(){
                @Override
                public void handle(ActionEvent event) {
                  primaryStage.setScene(new EmployeeScreen(new StackPane(),1200,700,primaryStage,emp,index));
                }
            });
        
        
        HBox btn=new HBox(10);
        btn.getChildren().addAll(cb,viewJob,Apply);
        btn.setAlignment(Pos.CENTER);
        bp.setTop(vb);
        bp.setCenter(btn);
        bp.setBottom(backhb);
        root.getChildren().add(new ImageView(RecruitmentSystem.Background));
             root.getChildren().add(bp); 
    }
    
    
}
