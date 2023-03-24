/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.*;

public class Register {

    private ArrayList<Employee> userlist = new ArrayList<>();
    private ArrayList<Employers> employerlist = new ArrayList<>();
    public ArrayList<String> emails = new ArrayList<>();

    public Register() {
    }

    public boolean checkemployee(String Username, String Password) {
        try {
            FileInputStream fis = new FileInputStream("users.ser");
            ObjectInputStream ois = new ObjectInputStream(fis);
            userlist = (ArrayList<Employee>) ois.readObject();
            ois.close();
            for (int i = 0; i < userlist.size(); i++) {
                if (userlist.get(i).getEmail().equals(Username)) {
                    return true;
                }
            }
            return false;
        } catch (IOException | ClassNotFoundException ex) {
            return false;
        }
    }

    public boolean checkemployer(String Username, String Password) {
        try {
            FileInputStream fis = new FileInputStream("employers.ser");
            ObjectInputStream ois = new ObjectInputStream(fis);
            employerlist = (ArrayList<Employers>) ois.readObject();
            ois.close();
            for (int i = 0; i < employerlist.size(); i++) {
                if (employerlist.get(i).getEmail().equals(Username)) {
                    return true;
                }
            }
            return false;
        } catch (IOException | ClassNotFoundException ex) {
            return false;
        }
    }

    public Employers getEmployer(String Username) {
        try {
            FileInputStream fis = new FileInputStream("employers.ser");
            ObjectInputStream ois = new ObjectInputStream(fis);
            employerlist = (ArrayList<Employers>) ois.readObject();
            ois.close();
            for (int i = 0; i < employerlist.size(); i++) {
                if (employerlist.get(i).getEmail().equals(Username)) {
                    return employerlist.get(i);
                }
            }
            return null;
        } catch (IOException | ClassNotFoundException ex) {
            return null;
        }
    }

    public Employee getEmployee(String Username) {
        try {
            FileInputStream fis = new FileInputStream("users.ser");
            ObjectInputStream ois = new ObjectInputStream(fis);
            userlist = (ArrayList<Employee>) ois.readObject();
            ois.close();
            for (int i = 0; i < userlist.size(); i++) {
                if (userlist.get(i).getEmail().equals(Username)) {
                    return userlist.get(i);
                }
            }
            return null;
        } catch (IOException | ClassNotFoundException ex) {
            return null;
        }
    }

    public void regAsEmployer(String Username, String Password) throws FileNotFoundException, IOException {
        try {
            FileInputStream fis = new FileInputStream("employers.ser");
            ObjectInputStream ois = new ObjectInputStream(fis);
            employerlist = (ArrayList<Employers>) ois.readObject();
            ois.close();
            Employers emp = new Employers(Username, Password);
            employerlist.add(emp);
            FileOutputStream fos = new FileOutputStream("employers.ser");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(employerlist);
            System.out.println("Your employee account has been created with username: " + Username + " and Password: " + Password);

        } catch (ClassNotFoundException | IOException ex) {
            FileOutputStream fos = new FileOutputStream("employers.ser");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            Employers emp = new Employers(Username, Password);
            employerlist.add(emp);
            oos.writeObject(employerlist);
            System.out.println("Your employee account has been created with username: " + Username + " and Password: " + Password);
        }
    }

    public boolean loginAsEmployee(String Username, String Password, int index) throws FileNotFoundException, IOException {
        try {
            FileInputStream fis = new FileInputStream("users.ser");
            ObjectInputStream ois = new ObjectInputStream(fis);
            userlist = (ArrayList<Employee>) ois.readObject();
            ois.close();
            for (int i = 0; i < userlist.size(); i++) {
                if (userlist.get(i).getEmail().equals(Username) && userlist.get(i).getPassword().equals(Password)) {
                    index = i;
                    return true;
                }
            }
            return false;
        } catch (ClassNotFoundException | IOException ex) {
            return false;
        }
    }

    public boolean loginAsEmployer(String Username, String Password, int index) throws FileNotFoundException, IOException {
        try {
            FileInputStream fis = new FileInputStream("employers.ser");
            ObjectInputStream ois = new ObjectInputStream(fis);
            employerlist = (ArrayList<Employers>) ois.readObject();
            ois.close();
            for (int i = 0; i < employerlist.size(); i++) {
                if (employerlist.get(i).getEmail().equals(Username) && employerlist.get(i).getPassword().equals(Password)) {
                    index = i;
                    return true;
                }
            }
            return false;
        } catch (ClassNotFoundException | IOException ex) {
            return false;
        }
    }

    public boolean loginAsAdmin(String Username, String Password) {
        try {
            FileReader in1 = new FileReader("admindata.txt");
            Scanner Sr6 = new Scanner(in1);
            while (Sr6.hasNext()) {
                if (Sr6.nextLine().equals(Username) && Sr6.nextLine().equals(Password)) { //checks whether the username in nextline matches with the inputted email and if the password in the line after matches the inputted password
                    return true;
                }
            }
            return false;
        } catch (IOException ex) {
            return false;
        }
    }

    public void regAsEmployee(String Username, String Password) throws FileNotFoundException, IOException {
        try {
            FileInputStream fis = new FileInputStream("users.ser");
            ObjectInputStream ois = new ObjectInputStream(fis);
            userlist = (ArrayList<Employee>) ois.readObject();
            ois.close();
            Employee emp = new Employee(Username, Password);
            userlist.add(emp);
            FileOutputStream fos = new FileOutputStream("Users.ser");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(userlist);
        } catch (ClassNotFoundException | IOException ex) {
            FileOutputStream fos = new FileOutputStream("Users.ser");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            Employee emp = new Employee(Username, Password);
            userlist.add(emp);
            oos.writeObject(userlist);
        }
    }

    public void Adminlogin() throws ClassNotFoundException {
        FileReader in1;
        try {
            in1 = new FileReader("admindata.txt");
            BufferedReader br1 = new BufferedReader(in1);
            Scanner Sr6 = new Scanner(in1);
            Scanner keyboard = new Scanner(System.in);
            System.out.println("email:");
            String mail = keyboard.nextLine();
            System.out.println("Password:");
            String Pass = keyboard.nextLine();
            while (Sr6.hasNext()) {
                if (Sr6.nextLine().equals(mail) && Sr6.nextLine().equals(Pass)) { //checks whether the username in nextline matches with the inputted email and if the password in the line after matches the inputted password
                    AdminScreen admScreen = new AdminScreen(mail, Pass);
                    admScreen.display();
                }
            }
        } catch (IOException ex) {
        }
    }
}
