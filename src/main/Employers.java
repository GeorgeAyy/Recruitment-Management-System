/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.PrintWriter;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;
public class Employers extends User implements Serializable {
    private String email = "";
    private String password = "";

    public Employers() {
    }
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public void setPassword(String password) {
        this.password = password;
    }

    public Employers(String email, String password) {
        this.email = email;
        this.password = password;
    }
     public void addInterviews(String Interview) throws IOException
     {
         FileWriter Fw=new FileWriter(email + "Interviews.txt",true); //appending so when you login once more you can search for if username and password match or not
         BufferedWriter Brw=new BufferedWriter(Fw);
         PrintWriter input2=new PrintWriter(Brw);
         input2.write(Interview);
         input2.close();
     }
     public static void employerScreen(String mail,String pass) throws FileNotFoundException, IOException, ClassNotFoundException{
     ObjectInputStream ois=new ObjectInputStream(new FileInputStream("employers.ser"));
     ArrayList<Employers>empl1=new ArrayList<Employers>();
     empl1=(ArrayList<Employers>) ois.readObject();
     ois.close();
     int index;
     for(int j=0;j<empl1.size();j++){
     if(empl1.get(j).getEmail().equals(mail)&&empl1.get(j).getPassword().equals(pass)){
         index=j;
         boolean exit = true;
        while(exit){
    Scanner Sr=new Scanner(System.in);
        System.out.println("Select one of the following options:");
        System.out.println("0: Add job.");
        System.out.println("1: Show job applications.");
        System.out.println("2: Logout.");
        int num;
        num=Sr.nextInt();
        
        switch(num){
            case 0:
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
                System.out.println("Enter the index of the category you wish to add a job in: ");
                for(int i=0;i<categories.length;i++)
                {
                    System.out.println(i + ": " + categories[i].getCategory());
                }
                int newNum;
                newNum = Sr.nextInt();
                categories[newNum].addJob(empl1.get(index));
                //invokes the add job in the jobCate class which adds jobs to each category
                break;
            }
            case 1:
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
                System.out.println("Enter the index of the category you wish to search for applicants or accept applicants in: ");
                for(int i=0;i<categories.length;i++)
                {
                    System.out.println(i + ": " + categories[i].getCategory());
                }
                int newNum;
                newNum = Sr.nextInt();
                
                categories[newNum].displayApplicationsInJobs(empl1.get(index));
                // calls the displayApplicationsInJobs method in the jobCate class.
                break;
            
            }
            case 2:
            {
                exit = false; 
                break;
            }
        }
      }
    }
     }
     }
     
     
     public void checkInterviews() throws FileNotFoundException, IOException
     {   
         File x = new File(email + "Interviews.txt");
         BufferedReader br = new BufferedReader(new FileReader(x));
         if (br.readLine() == null) 
         {
            System.out.println("File is empty");
         }
         else 
         {
         FileReader in = new FileReader(email + "Interviews.txt");
         Scanner Sr = new Scanner(in);
         int count = 0;
         while(Sr.hasNext())
            {
                System.out.println(count + ": " + Sr.nextLine());
                count++;
            }
         }
     }   
}
