package Stats_1;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.io.*;
/**
 *
 * @author leannekim
 */
public class Main {
    // student name --> that student's test score
    // read and display each name and score
    // after all are displayed, display:
        // lowest score
        // highest score
        // average score
    
    public static void main(String[] args){
        File scoresFile = new File("test1.dat");
        FileReader in;
        BufferedReader readFile;
        
        String student;
        
        double avgScore;
        double totalScores = 0;
        int numScores = 0;
        
        double highestScore = -1;
        double lowestScore = 101;
        
        try {
            in = new FileReader(scoresFile);
            readFile = new BufferedReader(in);
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
