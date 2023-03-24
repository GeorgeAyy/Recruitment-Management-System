
package main;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
public class Interviews {
    private String interviewMessage;
    private String employerName;
    private String employeeName;
    private int employeeIndex;
    private int employerIndex;
    public ArrayList<Employers> myEmployerList= new ArrayList<Employers>();
    public ArrayList<Employee> myEmployeeList = new ArrayList<Employee>();

    public Interviews(String interviewMessage, String employerName, String employeeName) throws FileNotFoundException, IOException, ClassNotFoundException {
        this.interviewMessage = interviewMessage;
        this.employerName = employerName;
        this.employeeName = employeeName;
        FileInputStream fis = new FileInputStream("Users.ser");
        ObjectInputStream ois = new ObjectInputStream(fis);
        myEmployeeList = (ArrayList<Employee>) ois.readObject();
        ois.close();
        FileInputStream fis2 = new FileInputStream("employers.ser");
        ObjectInputStream ois2 = new ObjectInputStream(fis2);
        myEmployerList = (ArrayList<Employers>) ois2.readObject();
        ois2.close();
        for(int i=0;i<myEmployeeList.size();i++)
        {
            if(myEmployeeList.get(i).getEmail().equalsIgnoreCase(employeeName))
            {
                this.employeeIndex = i;
            }
        }
        for(int i=0;i<myEmployerList.size();i++)
        {
            if(myEmployerList.get(i).getEmail().equalsIgnoreCase(employerName))
            {
                this.employerIndex = i;
            }
        }
        myEmployeeList.get(employeeIndex).setInterviews(interviewMessage);
        myEmployerList.get(employerIndex).addInterviews(interviewMessage);
        FileOutputStream fos = new FileOutputStream("Users.ser");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(myEmployeeList);
        oos.close();
        FileOutputStream fos2 = new FileOutputStream("employers.ser");
        ObjectOutputStream oos2 = new ObjectOutputStream(fos2);
        oos2.writeObject(myEmployerList);
        oos2.close();
    }
}
