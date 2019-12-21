package Roster;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.io.*;
import java.util.*;
/**
 *
 * @author leannekim
 */
public class Roster {
    public static void main(String[] args){
        File stuFile = new File("students.dat");
        Scanner input = new Scanner(System.in);
        int numStudents;
        Student studentName;
        String fName;
        String lName;
        
        try {
            /* write objects */
            FileOutputStream out = new FileOutputStream(stuFile);
            ObjectOutputStream writeStu = new ObjectOutputStream(out);
            
            System.out.print("Number of students: ");
            numStudents = input.nextInt();
            
            for (int i = 0; i < numStudents; i++){
                System.out.print("\nFirst name: ");
                fName = input.next();
                System.out.print("Last name: ");
                lName = input.next();
                writeStu.writeObject(new Student(fName, lName));
            }
            writeStu.close();
            out.close();    // necessary?
            System.out.println("Data written to file.\n");
            
            /* read objects */
            FileInputStream in = new FileInputStream(stuFile);
            ObjectInputStream readStu = new ObjectInputStream(in);
            
            for (int i = 0; i < numStudents; i++){
                Student stu = (Student)readStu.readObject();
                System.out.println(stu);
            }
            readStu.close();
            in.close(); // necessary?
        } catch (FileNotFoundException e){
            System.out.println("File could not be found.");
            System.err.println("FileNotFoundException: " + e.getMessage());
        } catch (IOException e){
            System.out.println("Problem input/output.");
            System.err.println("IOException: " + e.getMessage());
        } catch (ClassNotFoundException e){
            System.out.println("Class could not be used to cast object.");
            System.err.println("ClassNotFoundException: " + e.getMessage());
        }
    }
}
