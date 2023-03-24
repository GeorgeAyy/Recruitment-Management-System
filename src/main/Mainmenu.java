/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;
import java.io.IOException;
import java.util.Scanner;
public class Mainmenu{
   public Mainmenu(){
   
   }
   public void display() throws IOException, ClassNotFoundException{
       Scanner sr=new Scanner(System.in);
       Boolean b = true; //to keep looping until user clicks on 5 to exit.
       while(b){
           System.out.println("---Welcome to CareerPal!---");
           System.out.println("Select one of the following:");
           System.out.println("0: Register as an Employee.");
           System.out.println("1: Register as an Agency.");
           System.out.println("2: Login as an Employee.");
           System.out.println("3: Login as an Agency.");
           System.out.println("4: Login as an Admin.");
           System.out.println("5: Exit.");
           System.out.println("---------------------------");
           int num;
           Register Reg = new Register();
           num=sr.nextInt();
           switch(num){
               case 0:
               {
                   String username;
                   String password;
                   Scanner sr2 = new Scanner(System.in);
                   System.out.println("Enter username: ");
                   username=sr2.nextLine();
                   System.out.println("Enter password: ");
                   password=sr2.nextLine();
                   if(Reg.checkemployee(username, password)==false)
                   {
                       Reg.regAsEmployee(username, password);
                       System.out.println("Done");
                   }
                   else
                   {
                       System.out.println("Username or password already exist!");
                   }
                   break;
               }
               case 1:
               {
                    String username;
                   String password;
                   Scanner sr2 = new Scanner(System.in);
                   System.out.println("Enter company Name: ");
                   username=sr2.nextLine();
                   System.out.println("Enter password: ");
                   password=sr2.nextLine();
                   if(Reg.checkemployer(username, password)==false)
                   {
                       Reg.regAsEmployer(username, password);
                       System.out.println("Done");
                   }
                   else
                   {
                       System.out.println("Company name or password already exist!");
                   }
                   break;
               }
               case 2:
               {
                    String username;
                   String password;
                   Scanner sr2 = new Scanner(System.in);
                   System.out.println("Enter username: ");
                   username=sr2.nextLine();
                   System.out.println("Enter password: ");
                   password=sr2.nextLine();
                   if(Reg.checkemployee(username, password)==true)
                   {
                       int index=0;
                       if(Reg.loginAsEmployee(username, password,index)==true)
                       {
                           Employee.employeeScreen(username,password);
                       }
                   }
                   else
                   {
                       System.out.println("Username or password already exist!");
                   }
                   break;
               }
               case 3:
               {
                   String username;
                   String password;
                   Scanner sr2 = new Scanner(System.in);
                   System.out.println("Enter username: ");
                   username=sr2.nextLine();
                   System.out.println("Enter password: ");
                   password=sr2.nextLine();
                   int index = 0;
                   if(Reg.checkemployer(username, password)==true)
                   {
                       if(Reg.loginAsEmployer(username, password,index)==true)
                       {
                           Employers.employerScreen(password, password);
                       }
                   }
                   else
                   {
                       System.out.println("Username or password already exist!");
                   }
               break;
               }
               case 4:
               {
               Reg.Adminlogin();
               break;
               }
               case 5:
               {
                   System.exit(0);
               }
               case -1:
               {
                   b = false;
                   break;
               }
               default:{
                   System.out.println("invalid input");
                   break;
               }   
           }
       }
   }
}
