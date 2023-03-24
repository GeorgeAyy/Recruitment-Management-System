/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Scanner;
public class Admin extends User {
 private String username;
private String password;
public ArrayList<String> Admin=new ArrayList<>();

    private ArrayList<Employee> employee = new ArrayList<>();
    private ArrayList<Employers> employers=new ArrayList<>();
     
     public void deleteJob() throws IOException, FileNotFoundException, ClassNotFoundException 
    {
        Scanner Sr=new Scanner(System.in);
         JobCate[] categories= new JobCate[4];
                categories[0] = new JobCate();
                categories[1] = new JobCate();
                categories[2] = new JobCate();
                categories[3] = new JobCate();
                categories[0].setCategory("Professional");
                categories[1].setCategory("Highly Skilled");
                categories[2].setCategory("Skilled");
                categories[3].setCategory("Semi-Skilled");
       System.out.println("Enter the index of the category you wish to delete: ");
       for(int i=0;i<categories.length;i++)
                {
                    System.out.println(i + ": " + categories[i].getCategory());
                }
                int Num;
                Num = Sr.nextInt();
                categories[Num].deleteJob();
    }
     public void deleteemployees() throws  IOException, ClassNotFoundException{
         String email;
         String password;
         Scanner Sr=new Scanner(System.in);
         FileInputStream fis= new FileInputStream("users.ser"); 
         Scanner Sr6=new Scanner("users.ser");
        ObjectInputStream ois = new ObjectInputStream(fis);
        employee = (ArrayList<Employee>) ois.readObject();
        ois.close();
        FileOutputStream writedata=new FileOutputStream("users.ser");
        ObjectOutputStream WriteStream=new ObjectOutputStream(writedata);
        System.out.println("Enter email of employee you want to delete  ");
        email=Sr.nextLine();
        System.out.println("Enter the password of the employee you want to delete");
        password=Sr.nextLine();
       for(int i=0;i<employee.size();i++){
       if(employee.get(i).getEmail().equalsIgnoreCase(email)&&employee.get(i).getEmail().equalsIgnoreCase(password) )
            {
                employee.remove(i);
                System.out.println("the employee is deleted");
            }
     WriteStream.writeObject(employee);
     WriteStream.close();
         System.out.println("user deleted");
      }
     }

     
     public void deleteemployer() throws  IOException, ClassNotFoundException{
         String email;
         Scanner Sr=new Scanner(System.in);
         FileInputStream fis= new FileInputStream("employers.ser"); 
        ObjectInputStream ois = new ObjectInputStream(fis);
        employers = (ArrayList<Employers>) ois.readObject();
        ois.close();
        FileOutputStream writedata=new FileOutputStream("employers.ser");
        ObjectOutputStream WriteStream=new ObjectOutputStream(writedata);
        System.out.println("Enter email of employee you want to delete  ");
        email=Sr.nextLine();
        System.out.println("Enter the password of the employee you want to delete");
        password=Sr.nextLine();
        System.out.println(employers.size());
      for(int i=0;i<employers.size();i++){  
       if(employers.get(i).getEmail().equalsIgnoreCase(email)&&employers.get(i).getEmail().equalsIgnoreCase(password) )
            {
                employers.remove(i);
                System.out.println("the employee is deleted");
            }
         WriteStream.writeObject(employers);
         WriteStream.close();
         System.out.println("user deleted");
      }
    }
     public static void adminScreen(String mail,String pass) throws FileNotFoundException, IOException, ClassNotFoundException{
     Admin a=new Admin();
    boolean exit=true;
    while(exit){
    Scanner Sr=new Scanner(System.in);
        System.out.println("Select one of the following options:");
        System.out.println("0: delete job.");
        System.out.println("1: delete applicant's register.");
        System.out.println("2: delete employer's register.");
        System.out.println("3: Logout.");
    int num;
    num=Sr.nextInt();
    switch(num){
                case 0:
                {
                    a.deleteJob();
                    break;
                }
                case 1:
                {
                    a.deleteemployees();
                    break;
                }
                case 2:
                {
                    a.deleteemployer();
                    break;
                }
                case 3:
                {
                    exit=false;
                    break;
                }
                default:
                {
                    break;
                }
            }
        }
    }
}

        
     
     
     
