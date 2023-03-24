/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;

import static GUI.RecruitmentSystem.Background;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
//import javafx.scene.control.ComboBox;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
//import javafx.scene.control.ScrollPane;
//import javafx.scene.control.TableColumn;
//import javafx.scene.control.TableView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import main.Employers;
import main.Jobs;

/**
 *
 * @author georg
 */
public class ShowJobs extends Scene{
    
    public ShowJobs(StackPane root, double d, double d1,Stage primaryStage,Employers employer, int index) throws IOException, ClassNotFoundException {
        super(root, d, d1);
        
        
         BorderPane bp=new BorderPane();
        Label text=new Label("The job's you want to filter applicants according to ");
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
        
        String[] jobNames = {"Professional","Skilled","Highly Skilled","Semi-Skilled"};
        ArrayList<Jobs> jobs = new ArrayList<Jobs>();
//        FileInputStream fis = new FileInputStream("Professional" + ".ser");
//            ObjectInputStream ois = new ObjectInputStream(fis);
//            jobs=  (ArrayList<Jobs>) ois.readObject();
//            fis.close();
            
        for(int i=0;i<jobNames.length;i++)
        {
            try{
                File file = new File(jobNames[i] + ".ser");
                if(file.exists())
                {
                    FileInputStream fis2 = new FileInputStream(file);
                    ObjectInputStream ois2 = new ObjectInputStream(fis2);
                    jobs.addAll((ArrayList<Jobs>) ois2.readObject());
                    fis2.close();
                }
            }
            catch(ClassCastException | IOException ex)
            {
                ex.printStackTrace();
            }
        }
        ArrayList<String> namesList = new ArrayList<String>();
        
        for(int i=0;i<jobs.size();i++)
        {
            if((jobs.get(i).getCompanyName().equals(employer.getEmail())))
            {
                namesList.add(jobs.get(i).getJobName());
            }
            
        }
        final ObservableList<String> data = FXCollections.observableList(namesList);
        cb.setItems(data);//a sadasdasdas
        Button viewJob = new Button("View Applicants");
        Label error = new Label("");
        error.setStyle("-fx-text-fill: red;");
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
                        try{
                        primaryStage.setScene(new ShowEmployeeApps(new StackPane(),1200,700,primaryStage,jobs.get(i),employer,index));
                        }
                        catch(IOException | ClassNotFoundException ex)
                        {
                            error.setText("No applications found");
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
                  primaryStage.setScene(new EmployerScreen(new StackPane(),1200,700,primaryStage,employer,index));
                }
            });
        
        
        HBox btn=new HBox(10);
        btn.getChildren().addAll(cb,viewJob);
        btn.setAlignment(Pos.CENTER);
        VBox vb2 = new VBox();
        vb2.getChildren().addAll(error,btn);
        vb2.setAlignment(Pos.CENTER);
        bp.setTop(vb);
        bp.setCenter(vb2);
        bp.setBottom(backhb);
        root.getChildren().add(new ImageView(RecruitmentSystem.Background));
             root.getChildren().add(bp); 
    }
    
}
