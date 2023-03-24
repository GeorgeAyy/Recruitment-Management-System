/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMain.java to edit this template
 */
package GUI;
import java.io.IOException;
import javafx.application.Application;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
public class RecruitmentSystem extends Application{
    public static String Home= "C:\\Users\\georg\\OneDrive\\Documents\\New Folder\\RecruitmentSystem\\resize-16706778341884050739downloadremovebgpreview-removebg-preview.png";
    public static String Background ="C:\\Users\\georg\\OneDrive\\Documents\\New Folder\\RecruitmentSystem\\background new.png";
    public static String BackBtn = "C:\\Users\\georg\\OneDrive\\Documents\\New Folder\\RecruitmentSystem\\93634.png";
    @Override
    public void start(Stage primaryStage) throws IOException, ClassNotFoundException {
        primaryStage.setTitle("Hello World!");
        primaryStage.setResizable(false);
        primaryStage.setScene(new MainLogin(new StackPane(),1200,700,primaryStage)); //MainLogin
        primaryStage.show();
    }
    public static void main(String[] args) {
        launch(args);
    }
}
    
  
