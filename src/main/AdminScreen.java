/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
public class AdminScreen {
    private String email;
    private String password;
    private int index;
    Admin a =new Admin();
    public AdminScreen(String email, String password) throws IOException, ClassNotFoundException {
        FileReader in1;
        in1=new FileReader("admindata.txt");
        BufferedReader br1=new BufferedReader(in1);
        Scanner Sr6=new Scanner(in1);
        this.email = email;
        this.password = password;
    
    }
    public void display() throws IOException, ClassNotFoundException{
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
