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
import java.util.ArrayList;
import java.util.Scanner;
public class JobCate extends Jobs{
    private int CateID;
    private String Category;
    private static ArrayList<Jobs> jobs = new ArrayList<Jobs>();
    private ArrayList<Employee> myList = new ArrayList<>();
    public JobCate() throws IOException
    {
    }
    public void setCateID(int CateID) {
        this.CateID = CateID;
    }

    public void setCategory(String Category) {
        this.Category = Category;
    }

    public int getCateID() {
        return CateID;
    }

    public String getCategory() {
        return Category;
    }
    public void addJob(Employers employer) throws IOException, ClassNotFoundException
    { //takes in the info of the job then adds them in a .ser file named after the category using an ArrayList of jobs.
        String JName,Location,Skill,Sal,Experience,Description;
        Scanner Sr = new Scanner(System.in);
        System.out.println("Enter job Name: ");
        JName = Sr.nextLine();
        System.out.println("Enter Job Location: ");
        Location = Sr.nextLine();
        System.out.println("Enter Skill required: ");
        Skill = Sr.nextLine();
        System.out.println("Enter Salary");
        Sal = Sr.nextLine();
        System.out.println("Enter The amount of experience required: ");
        Experience = Sr.nextLine();
        System.out.println("Give a brief description of the job at hand: ");
        Description = Sr.nextLine();
        Jobs newJob = new Jobs(JName,Location,Skill,Sal,Experience,Description,"hello",employer);
        try{
        FileInputStream fis = new FileInputStream(Category + ".ser");
        ObjectInputStream ois = new ObjectInputStream(fis);
        jobs = new ArrayList<Jobs>();
        jobs = (ArrayList<Jobs>) ois.readObject();
        ois.close();
        FileOutputStream writeData = new FileOutputStream(Category + ".ser");
        ObjectOutputStream writeStream = new ObjectOutputStream(writeData);
        jobs.add(newJob);
        System.out.println(jobs.size());
        writeStream.writeObject(jobs);
        writeStream.close();  
        
      }
        catch(EOFException | FileNotFoundException EX) 
        // if the file is empty or not found the file is created by force writing over it.
        {
        FileOutputStream writeData = new FileOutputStream(Category + ".ser");
        ObjectOutputStream writeStream = new ObjectOutputStream(writeData);
        jobs.add(newJob);
        System.out.println(jobs.size());
        writeStream.writeObject(jobs);
        writeStream.close();   
        }
    }
    public void displayJobs() throws FileNotFoundException, IOException, ClassNotFoundException
    {
        
        FileInputStream fis = new FileInputStream(Category + ".ser");
        ObjectInputStream ois = new ObjectInputStream(fis);
        jobs = new ArrayList<Jobs>();
        jobs = (ArrayList<Jobs>) ois.readObject();
        for(int i =0;i<jobs.size();i++)
        {
            System.out.println(i + ": " + jobs.get(i).getJobName());
        }
        ois.close();
        
    }
    public int jobCounter() throws FileNotFoundException, IOException, ClassNotFoundException
    {
        FileInputStream fis = new FileInputStream(Category + ".ser");
        ObjectInputStream ois = new ObjectInputStream(fis);
        jobs = new ArrayList<Jobs>();
        jobs = (ArrayList<Jobs>) ois.readObject();
        ois.close();
        return jobs.size();
    }
    public void deleteAllJobs() throws IOException 
    {
        FileOutputStream writeData = new FileOutputStream(Category + ".ser");
        ObjectOutputStream writeStream = new ObjectOutputStream(writeData);
        writeStream.writeObject(jobs);
        writeStream.close();  
        System.out.println("The " + Category + " category has been deleted successfully");
    }
    public void displayJobInfo() throws FileNotFoundException, IOException, ClassNotFoundException 
    { //method is used in the EmployeeScreen to show the info of the jobs
        FileInputStream fis = new FileInputStream(Category + ".ser");
        ObjectInputStream ois = new ObjectInputStream(fis);
        jobs = new ArrayList<Jobs>();
        jobs = (ArrayList<Jobs>) ois.readObject();
        ois.close();
        System.out.println("The jobs in the " + Category + " Category are: ");
        for(int i=0;i<jobs.size();i++)
        {
            System.out.println(i+ ": " + jobs.get(i).getJobName());
        }
        System.out.println("Pick a job from the previous list: ");
        int f;
        Scanner Sr = new Scanner(System.in);
        f=Sr.nextInt();
        System.out.println("The details of the jobs you've chosen: ");
        System.out.println(jobs.get(f).toString());
    }
    public void applyForJob(Employee employee) throws FileNotFoundException, IOException, ClassNotFoundException
    { //used in the employee screen so the employee can apply for a job
        FileInputStream fis = new FileInputStream(Category + ".ser");
        ObjectInputStream ois = new ObjectInputStream(fis);
        jobs = new ArrayList<Jobs>();
        jobs = (ArrayList<Jobs>) ois.readObject();
        ois.close();
        System.out.println("The jobs in the " + Category + " Category are: ");
        for(int i=0;i<jobs.size();i++)
        {
            System.out.println(i+ ": " + jobs.get(i).getJobName());
        }
        System.out.println("Pick a job from the previous list to apply for: ");
        int f;
        Scanner Sr = new Scanner(System.in);
        f=Sr.nextInt();
        try{
            FileInputStream newFIS = new FileInputStream(jobs.get(f).getJobName() + ".ser");
            ObjectInputStream newOIS = new ObjectInputStream(newFIS);
            myList = (ArrayList<Employee>) newOIS.readObject();
            myList.add(employee);
            newOIS.close(); 
            FileOutputStream fos = new FileOutputStream(jobs.get(f).getJobName()+ ".ser");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(myList);
            oos.close();
        }
        catch(EOFException | FileNotFoundException EX){
            FileOutputStream fop=new FileOutputStream(jobs.get(f).getJobName() + ".ser");
            ObjectOutputStream oop=new ObjectOutputStream(fop);
            myList.add(employee);
            oop.writeObject(myList);
            oop.close();
       }
        jobs.get(f).addUsersApp(employee); //invokes the addUsersApp method in the Jobs class to save the employees registered for each job in a different file.
    }
    public static void guiApplyForJob(Employee emp, Jobs job) throws IOException, ClassNotFoundException
    {
        ArrayList myList = new ArrayList<Employee>();
        try{
            FileInputStream newFIS = new FileInputStream(job.getJobName() + ".ser");
            ObjectInputStream newOIS = new ObjectInputStream(newFIS);
            myList = (ArrayList<Employee>) newOIS.readObject();
            myList.add(emp);
            newOIS.close(); 
            FileOutputStream fos = new FileOutputStream(job.getJobName()+ ".ser");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(myList);
            oos.close();
        }
        catch(EOFException | FileNotFoundException EX){
            FileOutputStream fop=new FileOutputStream(job.getJobName() + ".ser");
            ObjectOutputStream oop=new ObjectOutputStream(fop);
            myList.add(emp);
            oop.writeObject(myList);
            oop.close();
       }
       job.addUsersApp(emp);
    }
    public void displayApplicationsInJobs(Employers employer) throws FileNotFoundException, IOException, ClassNotFoundException
    {
        try{
        FileInputStream fis = new FileInputStream(Category + ".ser");
        ObjectInputStream ois = new ObjectInputStream(fis);
        jobs = new ArrayList<Jobs>();
        jobs = (ArrayList<Jobs>) ois.readObject();
        ois.close();
        System.out.println("Your jobs in the " + Category + " Category are: ");
        ArrayList<Integer> myNumList = new ArrayList<Integer>();
        for(int i=0;i<jobs.size();i++)
        {
            if(jobs.get(i).getCompanyName().equalsIgnoreCase(employer.getEmail()))
            {
            System.out.println(i + ": "+ jobs.get(i).getJobName());
            myNumList.add(i);
            }
        }
        System.out.println("Pick one of the previous jobs to show it's applicants:");
        Scanner Sr = new Scanner(System.in);
        int num;
        num = Sr.nextInt();
        if(myNumList.contains(num))
        {
        jobs.get(num).displayUsers(employer); 
        // invokes the displayUsers function in jobs to show and list of users and then the employer can either
        // show the users CV or Accept the user and send him an interview date.
        }
        }
        catch(FileNotFoundException EX)
        {
            System.out.println("Category is empty.");
        }
    }
    public void displayUserAppsInJobs(Employee employee) throws FileNotFoundException, IOException, ClassNotFoundException
    {
        FileInputStream fis = new FileInputStream(Category + ".ser");
        ObjectInputStream ois = new ObjectInputStream(fis);
        jobs = new ArrayList<Jobs>();
        jobs = (ArrayList<Jobs>) ois.readObject();
        ois.close();
    }
    public void deleteJob() throws FileNotFoundException, IOException, ClassNotFoundException
    {
        System.out.println("This is the list of jobs to delete: ");
        displayJobs();
        System.out.println("Enter the index of the job you wish to delete: ");
        int numToDelete;
        Scanner Sr = new Scanner(System.in);
        numToDelete = Sr.nextInt();
        jobs.remove(numToDelete);
        FileOutputStream writeData = new FileOutputStream(Category + ".ser");
        ObjectOutputStream writeStream = new ObjectOutputStream(writeData);
        writeStream.writeObject(jobs);
        writeStream.close();  
    }
    
}
