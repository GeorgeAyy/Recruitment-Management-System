/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.Scanner;
public class EmployerScreen {
private String email;
private String password;
private int index;
private ArrayList<Employers>myEmployers=new ArrayList<>();
    public EmployerScreen(String email,String password) throws IOException, ClassNotFoundException {
        this.email = email;
        this.password = password;
        FileInputStream fis= new FileInputStream("employers.ser"); 
        ObjectInputStream ois = new ObjectInputStream(fis);
        myEmployers = (ArrayList<Employers>) ois.readObject();
        ois.close();
        for(int i=0;i<myEmployers.size();i++)
        {
            if(myEmployers.get(i).getEmail().equalsIgnoreCase(email) && myEmployers.get(i).getPassword().equalsIgnoreCase(password))
            {
                this.index = i;
            }
        }
    }
    public void display() throws IOException, ClassNotFoundException{
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
                FileInputStream fis= new FileInputStream("employers.ser"); 
                ObjectInputStream ois = new ObjectInputStream(fis);
                myEmployers = (ArrayList<Employers>) ois.readObject();
                ois.close();
                categories[newNum].addJob(myEmployers.get(index));
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
                FileInputStream fis= new FileInputStream("employers.ser"); 
                ObjectInputStream ois = new ObjectInputStream(fis);
                myEmployers = (ArrayList<Employers>) ois.readObject();
                ois.close();
                categories[newNum].displayApplicationsInJobs(myEmployers.get(index));
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
