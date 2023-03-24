/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
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
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import main.Employee;

/**
 *
 * @author fatim
 */
public class DeleteEmployee extends Scene {
   

    public DeleteEmployee(StackPane root, double d, double d1,Stage primaryStage) throws FileNotFoundException, IOException, ClassNotFoundException {
        super(root, d, d1);
         ImageView homeimage=new ImageView(RecruitmentSystem.Home);
         Button home=new Button("",homeimage);
         home.setStyle("-fx-background-color: cornflowerblue; -fx-cursor: hand;-fx-background-radius: 15px; -fx-text-fill: #ffffff");
          home.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {
                primaryStage.setScene(new MainLogin(new StackPane(),1200,700,primaryStage));
            }
        });
          HBox homehb=new HBox();
          homehb.getChildren().add(home);
          homehb.setAlignment(Pos.TOP_RIGHT);
          Label text =new Label("Delete Employee");
           text.setFont(Font.font("Elephant",20)); 
            text.setStyle("-fx-text-fill: white;");
            
            HBox txt=new HBox();
            txt.getChildren().add(text);
           txt.setAlignment(Pos.CENTER);
           
           VBox vb=new VBox();
           vb.getChildren().addAll(homehb,txt);
           
          
          ComboBox cb = new ComboBox();
          ArrayList<Employee> emp = new ArrayList<Employee>();
          FileInputStream fis=new FileInputStream("Users.ser");
          ObjectInputStream Ois=new ObjectInputStream(fis);
          emp=(ArrayList<Employee>) Ois.readObject();
          fis.close();
          
          
          
          ArrayList<String> names= new ArrayList<>();
          for(int i=0;i<emp.size();i++){
           
              names.add(emp.get(i).getEmail());
          
          }
          
          final ObservableList<String> empdata=FXCollections.observableList(names);
          cb.setItems(empdata);
         
          Button delete=new Button("delete employee");
          delete.setStyle("-fx-background-color: cornflowerblue; -fx-cursor: hand;-fx-background-radius: 15px; -fx-text-fill: #ffffff");
          delete.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {
                if(cb.getValue()!=null)
                {
                try{
                    ArrayList<Employee> emp = new ArrayList<Employee>();
                   FileInputStream fis=new FileInputStream("Users.ser");
                     ObjectInputStream Ois=new ObjectInputStream(fis);
                   emp=(ArrayList<Employee>) Ois.readObject();
                  fis.close();
               int index = cb.getSelectionModel().getSelectedIndex();
               emp.remove(index);
               names.remove(index);
               FileOutputStream fos = new FileOutputStream("Users.ser");
               ObjectOutputStream oos = new ObjectOutputStream(fos);
               oos.writeObject(emp);
               final ObservableList<String> empdata=FXCollections.observableList(names);
                cb.setItems(empdata);
                }
                catch(IOException | ClassNotFoundException ex)
                {
                    
                }
                
                }
            }
        });
          HBox hb=new HBox(10);
          hb.getChildren().addAll(cb,delete);
          hb.setAlignment(Pos.CENTER);
          
          ImageView backbtn=new ImageView(RecruitmentSystem.BackBtn);
          Button back=new Button("",backbtn);
          back.setStyle("-fx-background-color: cornflowerblue; -fx-cursor: hand;-fx-background-radius: 15px; -fx-text-fill: #ffffff");
          back.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {
                primaryStage.setScene(new AdminScreen(new StackPane(),1200,700,primaryStage));
            }
          
          });
         
          HBox backhb= new HBox(back);
          backhb.setAlignment(Pos.BASELINE_LEFT);
          
          BorderPane bp=new BorderPane();
           bp.setCenter(hb);
           bp.setTop(vb);
           bp.setBottom(back);
            root.getChildren().add(new ImageView(RecruitmentSystem.Background));
            root.getChildren().add(bp); 
            
            
          
         
          
    }
   
}
