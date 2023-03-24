/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;
public class Jobs implements Serializable{
    private String profession;
    private String jobName;
    private String Location;
    private String Skill;

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }
    private String Sal;
    private String Experience;
    private String Description;
    private String companyName;
    private ArrayList<Employee> myList = new ArrayList<>();
    public Jobs()
    {
        
    }
    public Jobs(String profession, String jobName, String jobLocation, String skillReq, String salary, String experienceReq, String jobDesc, Employers employer) throws IOException {
        this.profession = profession;
        this.jobName = jobName;
        this.Location = jobLocation;
        this.Skill = skillReq;
        this.Sal = salary;
        this.Experience = experienceReq;
        this.Description = jobDesc;
        this.companyName = employer.getEmail();
    }
    public String getCompanyName() {
        return companyName;
    }
    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }
    public Jobs(Jobs z)throws IOException{
        this.Description =z.Description;
        this.Experience = z.Experience;
        this.Location = z.Location;
        this.Sal = z.Sal;
        this.Skill = z.Skill;
        this.jobName = z.jobName;
    }
    public String getJobName() {
        return jobName;
    }
    public void setJobName(String jobName) {
        this.jobName = jobName;
    }
    public String getLocation() {
        return Location;
    }
    public void setLocation(String Location) {
        this.Location = Location;
    }
    public String getSkill() {
        return Skill;
    }
    public void setSkill(String Skill) {
        this.Skill = Skill;
    }
    public String getSal() {
        return Sal;
    }
    public void setSal(String Sal) {
        this.Sal = Sal;
    }
    public String getExperience() {
        return Experience;
    }
    public void setExperience(String Experience) {
        this.Experience = Experience;
    }
    public String getDescription() {
        return Description;
    }
    public void setDescription(String Description) {
        this.Description = Description;
    }
    @Override
    public String toString() //overriding the toString method to display my items in this format.
    {
        String x;
        x = ("The details for the " + this.getJobName() + " Job are: " + "\n" 
                + "Location: " + this.getLocation() + "\n" 
                + "Skills required: " + this.getSkill() + "\n" 
                + "Salary: " + this.getSal() + "\n"
                + "Experience needed: " + this.getExperience() + "\n"
                + "Description: " + this.getDescription());
        return x;
    }
    public void addUsersApp(Employee employee) throws FileNotFoundException, IOException, ClassNotFoundException
    { //used in the applyForJobs method in the JobCate class to save the jobs the user has applied for in a file with the users name.
        try{
            FileInputStream fis2 = new FileInputStream(employee.getEmail()+ "Apps.ser");
            ObjectInputStream ois2 = new ObjectInputStream(fis2);
            ArrayList<Jobs> myJobList= new ArrayList<Jobs>();
            myJobList = (ArrayList<Jobs>) ois2.readObject();
            ois2.close();
            FileOutputStream fos2 = new FileOutputStream(employee.getEmail()+ "Apps.ser");
            ObjectOutputStream oos2 = new ObjectOutputStream(fos2);
            myJobList.add(this);
            oos2.writeObject(myJobList);
            oos2.close();
        }
        catch(EOFException | FileNotFoundException X) //if file is empty or file isn't found a new file is created.
        {
            FileOutputStream fos2 = new FileOutputStream(employee.getEmail()+ "Apps.ser");
            ObjectOutputStream oos2 = new ObjectOutputStream(fos2);
            ArrayList<Jobs> myJobList= new ArrayList<Jobs>();
            myJobList.add(this);
            oos2.writeObject(myJobList);
            oos2.close();
        }
    }
    public void displayEmployeeApp(Employee employee) throws FileNotFoundException, IOException, ClassNotFoundException
    {
        FileInputStream fis = new FileInputStream(employee.getEmail()+ "Apps.ser");
        ObjectInputStream ois = new ObjectInputStream(fis);
        ArrayList<Jobs> myJobList= new ArrayList<Jobs>();
        myJobList = (ArrayList<Jobs>) ois.readObject();
        for(int i=0;i<myJobList.size();i++)
        {
            System.out.println(i + ": " + myJobList.get(i).getJobName());
        }
        ois.close();
    }
    public static void displayUsersApps(String filename) throws FileNotFoundException, IOException, ClassNotFoundException // For the employers
    {
        //FileInputStream fis = new FileInputStream(this.jobName + ".ser");
        FileInputStream fis = new FileInputStream(filename);
        ObjectInputStream ois = new ObjectInputStream(fis);
        ArrayList<Employee> test = new ArrayList<> ();
        test = (ArrayList<Employee>) ois.readObject();
        ois.close();
        Scanner Sr = new Scanner(System.in);
        System.out.println("Pick a user to display their CV: ");
        for(int i=0;i<test.size();i++)
        {
            System.out.println(i+ ": " + test.get(i).getfName());
        }
        int num;
        num = Sr.nextInt();
        test.get(num).displayCV();
    }
    public void displayUsers(Employers employer) throws FileNotFoundException, IOException, ClassNotFoundException{
        //this.jobName.ser is a file which stores objects of class Employee which includes each employee which applied for a job.
        FileInputStream fis = new FileInputStream(this.jobName + ".ser");
        ObjectInputStream ois = new ObjectInputStream(fis);
        myList = (ArrayList<Employee>) ois.readObject();
        boolean logout = true;
        while(logout)
        {
        System.out.println("The List of employees that applied for the job:");
        for(int i=0;i<myList.size();i++){
            //displays the names of each employee that applied for the job.
            System.out.println(i + ": " + myList.get(i).getEmail());
        }
        ois.close();
        FileOutputStream fos = new FileOutputStream(this.jobName+ ".ser");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(myList);
        oos.close();
        System.out.println("Do you want to display the CV of a user or accept a user in the job.");
        System.out.println("0: Display CV.");
        System.out.println("1: Accept User.");    
        System.out.println("2: Return.");
        Scanner Sr=new Scanner(System.in);
        int Choice = Sr.nextInt();
            switch (Choice) {
                case 0:
                    {
                        System.out.println("Choose the employee you want to view:");
                        int num;
                        num=Sr.nextInt();
                        myList.get(num).displayCV();
                        break;
                    }
                case 1:
                    {
                        System.out.println("Choose the employee you want to accept:");
                        int num;
                        num = Sr.nextInt();
                        System.out.println("Type out the interview message you want to display to the applicant with date details and location.");
                        //the agency types out an interview message including the date time and location and is then sent to the employee
                        String interviewMessage;
                        Scanner Sr2 = new Scanner(System.in);
                        interviewMessage = Sr2.nextLine();
                        //A new interview is created with message, name of employer and name of employee and then the interview message is sent to both the employer and employee in the Interviews constructor.
                        Interviews newInterview = new Interviews(interviewMessage,employer.getEmail(),myList.get(num).getEmail());
                        break;
                    }
                case 2:
                    logout = false;
                    break;
                default:
                    break;
            }
        }
    }
}
