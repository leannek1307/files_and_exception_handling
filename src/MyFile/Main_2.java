package MyFile;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.*;
import java.io.*;
/**
 *
 * @author leannekim
 */

/* This class creates the "zzz.txt" file then prompts the user if they want to keep or delete the file. */
public class Main_2 {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        String prompt;
        
        File textFile = new File("zzz.txt");
        if (textFile.exists()){
            System.out.println("file exists");
        } else {
            /* create new file. if can't, print IOException error message. */
            try{
                textFile.createNewFile();
                System.out.println("New file created");
            } catch (IOException e){
                System.out.println("File could not be created.");
                System.err.println("IOException: " + e.getMessage());
            }
        }
        
        System.out.print("(d)elete file OR (k)eep file: ");
        prompt = input.nextLine();
        
        /* either delete or keep file. */
        if ("d".equals(prompt)){
            textFile.delete();
            System.out.println("File has been deleted.");
        } else {
            System.out.println("File has been kept.");
        }
    }
}
