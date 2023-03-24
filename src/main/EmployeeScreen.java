/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Scanner;
public class EmployeeScreen {
    private String email;
    private String password;
    private int Index;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getIndex() {
        return Index;
    }

    public void setIndex(int Index) {
        this.Index = Index;
    }
    
    private static ArrayList<Employee> myEmployees = new ArrayList<>();

    public EmployeeScreen(String email, String password) throws FileNotFoundException, IOException, ClassNotFoundException {
        this.email = email;
        this.password = password;
        FileInputStream fis= new FileInputStream("users.ser"); 
        ObjectInputStream ois = new ObjectInputStream(fis);
        myEmployees = (ArrayList<Employee>) ois.readObject();
        ois.close();
        for(int i=0;i<myEmployees.size();i++)
        {
            if(myEmployees.get(i).getEmail().equalsIgnoreCase(email) && myEmployees.get(i).getPassword().equalsIgnoreCase(password))
            {
                this.Index = i;
            }
        }
    }
    public void display() throws IOException, ClassNotFoundException
    {
//        myEmployees = new ArrayList<Employee>();
//        FileInputStream fis= new FileInputStream("users.ser"); 
//        ObjectInputStream ois = new ObjectInputStream(fis);
//        myEmployees = (ArrayList<Employee>) ois.readObject();
//        ois.close();
//        myEmployees.get(0).setCV();
        boolean exit=true;
        while(exit){
        Scanner Sr = new Scanner(System.in);
        System.out.println("Pick one of the following options: ");
        System.out.println("0: Set CV.");
        System.out.println("1: Display Current CV");
        System.out.println("2: Search for job.");
        System.out.println("3: Apply for a job.");
        System.out.println("4: Display the jobs you've applied for: ");
        System.out.println("5: Display your interviews.");
        System.out.println("6: Logout");
        int num;
        num = Sr.nextInt();
        switch(num)
        {
            case 0:
            {
                myEmployees = new ArrayList<Employee>();
                FileInputStream fis= new FileInputStream("users.ser"); 
                ObjectInputStream ois = new ObjectInputStream(fis);
                myEmployees = (ArrayList<Employee>) ois.readObject();
                ois.close();
                System.out.println(Index);
                myEmployees.get(Index).setCV(); //invokes the setCV function in the employee class
                FileOutputStream fos=new FileOutputStream("users.ser");
                ObjectOutputStream oos=new ObjectOutputStream(fos);
                oos.writeObject(myEmployees);
                oos.close();
                break;
            }
  
            case 1:
            {
                myEmployees = new ArrayList<Employee>();
                FileInputStream fis= new FileInputStream("users.ser"); 
                ObjectInputStream ois = new ObjectInputStream(fis);
                myEmployees = (ArrayList<Employee>) ois.readObject();
                ois.close();
                System.out.println(Index);
                myEmployees.get(Index).displayCV(); //invokes the displayCV function in the employee class
                FileOutputStream fos=new FileOutputStream("users.ser");
                ObjectOutputStream oos=new ObjectOutputStream(fos);
                oos.writeObject(myEmployees);
                oos.close();
                break;
            }
            case 2:
            {
                JobCate[] categories= new JobCate[4];
                categories[0] = new JobCate();
                categories[1] = new JobCate();
                categories[2] = new JobCate();
                categories[3] = new JobCate();
                categories[0].setCategory("Professional");
                categories[1].setCategory("Highly Skilled");
                categories[2].setCategory("Skilled");
                categories[3].setCategory("Semi-Skilled");
                System.out.println("Enter the index of the category you wish to search for a job in: ");
                for(int i=0;i<categories.length;i++)
                {
                    System.out.println(i + ": " + categories[i].getCategory());
                }
                int newNum;
                newNum = Sr.nextInt();
                categories[newNum].displayJobInfo();
                break;
                
            }
            case 3: 
            {
                JobCate[] categories= new JobCate[4];
                categories[0] = new JobCate();
                categories[1] = new JobCate();
                categories[2] = new JobCate();
                categories[3] = new JobCate();
                categories[0].setCategory("Professional");
                categories[1].setCategory("Highly Skilled");
                categories[2].setCategory("Skilled");
                categories[3].setCategory("Semi-Skilled");
                System.out.println("Enter the index of the category you wish to apply for a job in: ");
                for(int i=0;i<categories.length;i++)
                {
                    System.out.println(i + ": " + categories[i].getCategory());
                }
                int newNum;
                newNum = Sr.nextInt();
                categories[newNum].applyForJob(myEmployees.get(Index));
                break;
            }
            case 4:
            {
//                JobCate[] categories= new JobCate[4];
//                categories[0] = new JobCate();
//                categories[1] = new JobCate();
//                categories[2] = new JobCate();2
//                categories[3] = new JobCate();
//                categories[0].setCategory("Professional");
//                categories[1].setCategory("Highly Skilled");
//                categories[2].setCategory("Skilled");
//                categories[3].setCategory("Semi-Skilled");
//                System.out.println("Enter the index of the category you wish to look for the jobs you've applied for: ");
//                for(int i=0;i<categories.length;i++)
//                {
//                    System.out.println(i + ": " + categories[i].getCategory());
//                }
//                int newNum;
//                newNum = Sr.nextInt();
                myEmployees = new ArrayList<Employee>();
                FileInputStream fis= new FileInputStream("users.ser"); 
                ObjectInputStream ois = new ObjectInputStream(fis);
                myEmployees = (ArrayList<Employee>) ois.readObject();
                ois.close();
                //reads the file which includes all the jobs the user applied to which was created in the addusersapp method called in Jobs.
                FileInputStream fis2 = new FileInputStream(myEmployees.get(Index).getEmail()+ "Apps.ser"); 
                ObjectInputStream ois2 = new ObjectInputStream(fis2);
                ArrayList<Jobs> myJobList= new ArrayList<Jobs>(); //places the jobs the user applied for in an arrayList of jobs.
                myJobList = (ArrayList<Jobs>) ois2.readObject();
                for(int i=0;i<myJobList.size();i++)
                {
                    System.out.println(i + ": " + myJobList.get(i).getJobName());
                }
                ois2.close();
                break;
            }
            case 5:
            {
                myEmployees = new ArrayList<Employee>();
                FileInputStream fis= new FileInputStream("users.ser"); 
                ObjectInputStream ois = new ObjectInputStream(fis);
                myEmployees = (ArrayList<Employee>) ois.readObject();
                ois.close();
                myEmployees.get(Index).checkInterviews(); //invokes the checkInterview method in the Employee class
                break;
            }

            case 6:
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
