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
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;
public class Employee extends User implements Serializable{
    public String email;
    public String Password;
    public String fName = "";
    public String lName = "";
    public LocalDate DoB;
    public String gender = "";
    public String pNum = "";
    public String cvEmail = "";
    public String WorkField = "";
    public String skills = ""; 
    public String education = "";
    public String languages = "";
    public String Profession = "";
    public String experience = "";
    public ArrayList<Employee>emp=new ArrayList<>();
   

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getlName() {
        return lName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    public LocalDate getDoB() {
        return DoB;
    }

    public void setDoB(LocalDate DoB) {
        this.DoB = DoB;
    }

    
    public String getpNum() {
        return pNum;
    }

    public void setpNum(String pNum) {
        this.pNum = pNum;
    }

    public String getCvEmail() {
        return cvEmail;
    }

    public void setCvEmail(String cvEmail) {
        this.cvEmail = cvEmail;
    }

    public String getWorkField() {
        return WorkField;
    }

    public void setWorkField(String WorkField) {
        this.WorkField = WorkField;
    }

    public String getProfession() {
        return Profession;
    }

    public void setProfession(String Profession) {
        this.Profession = Profession;
    }

    public String getExperience() {
        return experience;
    }

    public void setExperience(String experience) {
        this.experience = experience;
    }

    public ArrayList<Employee> getEmp() {
        return emp;
    }

    public void setEmp(ArrayList<Employee> emp) {
        this.emp = emp;
    }

    
    public String getSkills() {
        return skills;
    }
    public void setSkills(String skills) {
        this.skills = skills;
    }
    public String getEducation() {
        return education;
    }
    public void setEducation(String education) {
        this.education = education;
    }
    public String getLanguages() {
        return languages;
    }
    public void setLanguages(String languages) {
        this.languages = languages;
    }
    public Employee() {
    }
    public Employee(String email, String Password) {
        this.email = email;
        this.Password = Password;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    @Override
    public String getPassword() {
        return Password;
    }
    @Override
    public void setPassword(String Password) {
        this.Password = Password;
    }
    public void setCV()
    {
        Scanner myScanner = new Scanner(System.in);
        String myString;
        System.out.println("Enter your name: ");
        System.out.println("Enter Date of birth in (Day/Month/Year) Format: ");
        System.out.println("Enter your gender: ");
        myString = myScanner.nextLine();
        this.gender = myString;
        System.out.println("Enter your phone number: ");
        System.out.println("What is your experience of work in this field: ");
        System.out.println("What skills do you offer: ");
        myString = myScanner.nextLine();
        this.skills = myString;
        System.out.println("Where did you get educated: ");
        myString = myScanner.nextLine();
        this.education = myString;
        System.out.println("What languages do you speak: ");
        myString = myScanner.nextLine();
        this.languages = myString;
        System.out.println("What certifications do you have: ");
        System.out.println("Your CV has been set.");
    }
    public void guiSetCV(String fName, String lName, LocalDate DoB, String gender, String pNum, String email, String WorkField, String skills, String education, String languages, String Profession, String experience)
    {
        this.fName = fName;
        this.lName = lName;
        this.DoB = DoB;
        this.gender = gender;
        this.pNum = pNum;
        this.cvEmail = email;
        this.WorkField = WorkField;
        this.skills = skills;
        this.education = education;
        this.languages = languages;
        this.Profession = Profession;
        this.experience = experience;
    }
    public void displayCV()
    {
      //  System.out.println("Name: " +  );
       // System.out.println("Date of birth: " + DateOfBirth);
        System.out.println("Gender: " + gender);
       // System.out.println("PhoneNumber: " + phoneNumber);
       // System.out.println("Work Experience: " + workingExperience);
        System.out.println("Skills: " + skills);
        System.out.println("Education: " + education);
        System.out.println("Languages: " + languages);
       // System.out.println("Certifications: " + certification);
    }
    public void setInterviews(String Interview) throws IOException
     {
         FileWriter Fw=new FileWriter(this.getEmail()+ "Interviews.txt",true); //appending so when you login once more you can search for if username and password match or not
         BufferedWriter Brw=new BufferedWriter(Fw);
         PrintWriter input2=new PrintWriter(Brw);
         input2.write(Interview);
         input2.close();
     }
    public static void employeeScreen(String mail,String password) throws FileNotFoundException, IOException, ClassNotFoundException{
        ObjectInputStream ois=new ObjectInputStream(new FileInputStream("Users.ser"));
        ArrayList<Employee>emp1=new ArrayList<>();
        emp1=(ArrayList<Employee>) ois.readObject();
        ois.close();
        int index;
        for(int j=0;j<emp1.size();j++){
        if(emp1.get(j).getEmail().equals(mail)&&emp1.get(j).getPassword().equals(password)){
          index=j;
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
              
                System.out.println(index);
                emp1.get(index).setCV(); //invokes the setCV function in the employee class
                FileOutputStream fos=new FileOutputStream("Users.ser");
                ObjectOutputStream oos=new ObjectOutputStream(fos);
                oos.writeObject(emp1);
                oos.close();
                break;
            }
  
            case 1:
            {
                
                System.out.println(index);
                emp1.get(index).displayCV(); //invokes the displayCV function in the employee class
                FileOutputStream fos=new FileOutputStream("Users.ser");
                ObjectOutputStream oos=new ObjectOutputStream(fos);
                oos.writeObject(emp1);
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
                categories[newNum].applyForJob(emp1.get(index));
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
              
                //reads the file which includes all the jobs the user applied to which was created in the addusersapp method called in Jobs.
                FileInputStream fis2 = new FileInputStream(emp1.get(index).getEmail()+ "Apps.ser"); 
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
                emp1.get(index).checkInterviews(); //invokes the checkInterview method in the Employee class
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
        
        
        
         
        
    }
    
    public void editCv(){
        System.out.println("");
    }
     public void checkInterviews() throws FileNotFoundException, IOException
     {
         File x = new File(this.getEmail()+ "Interviews.txt");
         BufferedReader br = new BufferedReader(new FileReader(x));
         if (br.readLine() == null) 
         {
            System.out.println("File is empty");
         }
         else 
         {
         FileReader in = new FileReader(this.getEmail() + "Interviews.txt");
         Scanner Sr = new Scanner(in);
         int count = 0;
         while(Sr.hasNextLine())
         {
             System.out.println(count + ": " + Sr.nextLine());
             count++;
         }
         }
     }
}