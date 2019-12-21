package Stats_2;

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

/* This class allows the user to enter the names and greades of the students, then display the lowest, highest, average score. */
    // note that the application will "OVERWRITE" the "test1.dat" file each time that it is run.
public class Main {
    public static void main(String[] args){
        File scoresFile = new File("test1.dat");
        Scanner input = new Scanner(System.in);
        
        FileReader in;
        BufferedReader readFile;
        String student;
        
        FileWriter out;
        BufferedWriter writeFile;
        String inputName;
        double inputScore;

        double avgScore;
        double totalScores = 0;
        int numScores = 0;
        
        double highestScore = -1;
        double lowestScore = 101;
        
        try {
            /* create pointers */
            in = new FileReader(scoresFile);
            readFile = new BufferedReader(in);
            out = new FileWriter(scoresFile);
            writeFile = new BufferedWriter(out);
            
            /* user enter 5 student's names and scores */
            for (int i = 0; i < 5; i++){
                System.out.print("Enter student name: ");
                inputName = input.next();
                System.out.print("Enter test score: ");
                inputScore = input.nextDouble();
                writeFile.write(inputName);
                writeFile.newLine();
                writeFile.write(String.valueOf(inputScore));
                writeFile.newLine();
            }
            writeFile.close();
            out.close();
            System.out.println("Data written to file.");
            
            /* Read data file and checks if it is so far the lowest/highest score. */
            while ((student = readFile.readLine()) != null){    
                System.out.print(student + ": ");  // name of student
                student = readFile.readLine();  // score of that student
                
                numScores += 1;
                System.out.println(student);
                totalScores += Double.parseDouble(student);
                
                if (Double.parseDouble(student) > highestScore){
                    highestScore = Double.parseDouble(student);
                }
                if (Double.parseDouble(student) < lowestScore){
                    lowestScore = Double.parseDouble(student);
                }
            }
            System.out.println("\nLowest Score: " + lowestScore);
            System.out.println("Highest Score " + highestScore);
            
            avgScore = totalScores / numScores;
            System.out.println("Average: " + avgScore);
            readFile.close();
            in.close();
        } catch (FileNotFoundException e){
            System.out.println("File does not exist or could not be found.");
            System.err.println("FileNotFoundException: " + e.getMessage());
        } catch (IOException e){
            System.out.println("Problem reading file");
            System.err.println("IOException: " + e.getMessage());
        }
        
    }
}
