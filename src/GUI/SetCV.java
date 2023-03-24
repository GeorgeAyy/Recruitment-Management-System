/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;

import static GUI.RecruitmentSystem.BackBtn;
import static GUI.RecruitmentSystem.Background;
import static GUI.RecruitmentSystem.Home;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Optional;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import static javafx.geometry.Pos.BASELINE_LEFT;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
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

/**
 *
 * @author georg
 */
public class SetCV extends Scene{

    public SetCV(StackPane root, double d, double d1,Stage primaryStage,Employee emp,int index) {
        super(root, d, d1);
        primaryStage.setTitle("CV form");
        
        
        Label text=new Label("Set CV");
        text.setStyle("-fx-text-fill: white;");
        text.setAlignment(Pos.CENTER);
        text.setFont(Font.font("Lucida Calligraphy",30));
        HBox txt=new HBox(20);
        txt.getChildren().add(text);
        txt.setAlignment(Pos.TOP_CENTER);
        txt.setPadding(new Insets(10,5,5,5));
       
        
        VBox components=new VBox();
        Label fn = new Label("firstname:");
        fn.setStyle("-fx-text-fill: white;");
        TextField fn1=new TextField(emp.getfName()); 
         
        HBox fnhb=new HBox(5);
        fnhb.getChildren().addAll(fn,fn1);
       
       
        Label ln = new Label("Lastname:");
        ln.setStyle("-fx-text-fill: white;");
        TextField ln1=new TextField(emp.getlName());
        HBox lnhb=new HBox(5);
        lnhb.getChildren().addAll(ln,ln1);
  
        Label db = new Label("Dateofbirth:");
        db.setStyle("-fx-text-fill: white;");
        DatePicker db1=new DatePicker(emp.getDoB());
        db1.setEditable(false);
        HBox dbhb=new HBox(5);
        dbhb.getChildren().addAll(db,db1);
        
        
        Label gndr= new Label("Gender:");
        gndr.setStyle("-fx-text-fill: white;");
        //pane.add(fc,0,4);
       final ToggleGroup radioGroup =new ToggleGroup();
       RadioButton g=new RadioButton("Male");
       g.setStyle("-fx-text-fill:white;");
       g.setToggleGroup(radioGroup);
       RadioButton g2=new RadioButton("Female");
       g2.setStyle("-fx-text-fill:white;");
       g2.setToggleGroup(radioGroup);
       if(emp.getGender().equals("Female"))
       {
           g2.setSelected(true);
       }
       else
       {
           g.setSelected(true);
       }
       HBox gndrhb=new HBox(5);
        gndrhb.getChildren().addAll(gndr,g,g2);
        
       
       Label pn= new Label("Phone number:");
        pn.setStyle("-fx-text-fill: white;");
       TextField pn1=new TextField(emp.getpNum());
       pn1.textProperty().addListener((ObservableValue<? extends String> observable, String oldValue, String newValue) -> {
           if (!newValue.matches("\\d*")) {
               pn1.setText(newValue.replaceAll("[^\\d]", ""));
           }
        });
       HBox pnhb=new HBox(5);
        pnhb.getChildren().addAll(pn,pn1);
        
       Label email = new Label("Email:");
        email.setStyle("-fx-text-fill: white;");
       TextField email1=new TextField(emp.getCvEmail());
       HBox emailhb=new HBox(5);
        emailhb.getChildren().addAll(email,email1);
        
       Label wf = new Label("Workfield:");
        wf.setStyle("-fx-text-fill: white;");
       TextField wf1=new TextField(emp.getWorkField());
       HBox wfhb=new HBox(5);
        wfhb.getChildren().addAll(wf,wf1);
        
       Label skills= new Label("skills:");
        skills.setStyle("-fx-text-fill: white;");
       TextField skills1=new TextField(emp.getSkills());
       HBox skillshb=new HBox(5);
        skillshb.getChildren().addAll(skills,skills1);
        
       Label edu= new Label("Education:");
        edu.setStyle("-fx-text-fill: white;");
       TextField edu1=new TextField(emp.getEducation());
       HBox eduhb=new HBox(5);
        eduhb.getChildren().addAll(edu,edu1);
        
       Label lang= new Label("Languages:");
        lang.setStyle("-fx-text-fill: white;");
       TextField lang1=new TextField(emp.getLanguages());
       HBox langhb=new HBox(5);
        langhb.getChildren().addAll(lang,lang1);
        
       VBox hb=new VBox();
       ObservableList<String>options=FXCollections.observableArrayList(
       "Professional",
       "Highly Skilled",
       "Skilled",
       "Semi-Skilled");
       Label prof = new Label("profession:");
       
        prof.setStyle("-fx-text-fill: white;");
       ComboBox combobox=new ComboBox(options);
       if(emp.getProfession().equals("Professional"))
       {
           combobox.getSelectionModel().select(0);
       }
       else if(emp.getProfession().equals("Highly Skilled"))
       {
           combobox.getSelectionModel().select(1);
       }
       else if(emp.getProfession().equals("Skilled"))
       {
           combobox.getSelectionModel().select(2);
       }
       else if(emp.getProfession().equals("Semi-Skilled"))
       {
           combobox.getSelectionModel().select(3);
       }
       else
       {
           combobox.getSelectionModel().select(0);
       }
       hb.getChildren().add(combobox);
       HBox profhb=new HBox(5);
        profhb.getChildren().addAll(prof,combobox);
       Label exp= new Label("Experience:");
        exp.setStyle("-fx-text-fill: white;");
       TextArea exp1=new TextArea(emp.getExperience());
       exp1.setMinWidth(2);
       HBox exphb=new HBox(5);
        exphb.getChildren().addAll(exp,exp1);
      Button bt =new Button("    save");
      bt.setStyle("-fx-background-color: cornflowerblue;-fx-cursor: hand; -fx-background-radius: 15px; -fx-text-fill: #ffffff");
      bt.setMinSize(70, 15);
      bt.setAlignment(BASELINE_LEFT); 
      bt.setOnAction((ActionEvent event) -> {
          if((fn1.getText().isEmpty())||
             (ln1.getText().isEmpty())||
             (pn1.getText().isEmpty())||
             (db.getText().isEmpty())||
             (email1.getText().isEmpty())||
             (wf1.getText().isEmpty())||
             (skills1.getText().isEmpty())||
             (edu1.getText().isEmpty())||
             (lang1.getText().isEmpty())||
             (combobox.getValue()==null)||
             (exp1.getText().isEmpty()))      
          {
           Alert alert = new Alert(Alert.AlertType.INFORMATION);
           alert.setTitle("Input fields empty");
           alert.setContentText("Please fill all input fields");

           alert.showAndWait();   
          }
          
      else{
              try{
                ArrayList<Employee> myEmployees = new ArrayList<Employee>();
                FileInputStream fis= new FileInputStream("Users.ser"); 
                ObjectInputStream ois = new ObjectInputStream(fis);
                myEmployees = (ArrayList<Employee>) ois.readObject();
                ois.close();
                String firstName = fn1.getText();
                String lastName = ln1.getText();
                String pNum = pn1.getText();
                LocalDate dob = db1.getValue();
                String gender;
                if(radioGroup.getSelectedToggle().equals(g))
                {
                    gender = "Male";
                }
                else
                {
                    gender = "Female";
                }
                String cvEmail = email1.getText();
                String workField = wf1.getText();
                String cvSkills = skills1.getText();
                String education = edu1.getText();
                String languages = lang1.getText();
                String profession = (String) combobox.getValue();
                String experience = exp1.getText();
                System.out.println(firstName + lastName + dob + gender + pNum + cvEmail + workField + cvSkills + education + languages + profession + experience);
                emp.guiSetCV(firstName,lastName,dob,gender,pNum,cvEmail,workField,cvSkills,education,languages,profession,experience);
                System.out.println(index + "HELLO");
                for(int i=0;i<myEmployees.size();i++)
                {
                    if(myEmployees.get(i).getEmail().equals(emp.getEmail())){
                        myEmployees.get(i).guiSetCV(firstName,lastName,dob,gender,pNum,cvEmail,workField,cvSkills,education,languages,profession,experience);
                    }
                }
                FileOutputStream fos = new FileOutputStream("Users.ser");
                ObjectOutputStream oos = new ObjectOutputStream(fos);
                oos.writeObject(myEmployees);
                oos.close();
              }
              catch(IOException | ClassNotFoundException ex)
              {
                  
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
      });
   
      
       ImageView backimage = new ImageView(BackBtn);
            Button back=new Button("",backimage);
            back.setStyle("-fx-background-color: cornflowerblue; -fx-cursor: hand;-fx-background-radius: 15px; -fx-text-fill: #ffffff");
            Employee employee=new Employee();
          
     HBox backhb=new HBox(back);
     backhb.setAlignment(Pos.BOTTOM_LEFT);
      backhb.setPadding(new Insets(5,5,30,5));
      back.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {
                primaryStage.setScene(new EmployeeScreen(new StackPane(),1200,700,primaryStage,emp,index));
            }
        });

      HBox homz=new HBox();
      ImageView homeimage = new ImageView(Home);
      homeimage.minHeight(10);
      homeimage.minWidth(10);
      Button home=new Button("",homeimage);
      home.setStyle("-fx-background-color: cornflowerblue;-fx-cursor: hand; -fx-background-radius: 15px; -fx-text-fill: #ffffff");
    
      home.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {
                primaryStage.setScene(new MainLogin(new StackPane(),1200,700,primaryStage));
            }
        });
      homz.getChildren().add(home);
      homz.setAlignment(Pos.TOP_RIGHT);
       GridPane pane=new GridPane();
        pane.setAlignment(Pos.CENTER);
        pane.addColumn(0,fn,ln,db,gndr,pn,email,wf,skills,edu,lang,prof,exp);
        pane.addColumn(1,fnhb,lnhb,dbhb,gndrhb,pnhb,emailhb,wfhb,skillshb,eduhb,langhb,profhb,exphb);
        pane.add(bt, 100, 13);
        pane.setPadding(new Insets(11.5, 12.5,13.5, 14.5));
        pane.setVgap(5.5);
        BorderPane bp=new BorderPane();
       VBox vb=new VBox();
       vb.getChildren().addAll(homz,txt);
        bp.setTop(vb);
        bp.setCenter(pane);
        bp.setBottom(backhb);
       root.getChildren().add(new ImageView(Background));
       root.getChildren().addAll(bp);
    }
}
