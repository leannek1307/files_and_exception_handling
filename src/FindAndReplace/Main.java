package FindAndReplace;

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
public class Main {
    public static void main(String[] args){
        File oCanada = new File ("oCanada.txt");
        FileReader in;
        BufferedReader readFile;
        FileWriter out;
        BufferedWriter writeFile;
        String line, oldText = "";
        Scanner input = new Scanner(System.in);
        
        System.out.print("Find: ");
        String find = input.next();
        find = find.toLowerCase();
        
        System.out.print("\nReplace with: ");
        String replace = input.next();
        replace = replace.toLowerCase();
        
        try {
            in = new FileReader(oCanada);
            readFile = new BufferedReader(in);
            
            while ((line = readFile.readLine()) != null){
                oldText += line + "\r\n"; 
            }
            in.close();

            String newText = oldText.replaceAll(find, replace);
            
            System.out.println(newText);
            
            out = new FileWriter(oCanada);
            out.write(newText);
            
            out.close();
        } catch (IOException e){
            System.out.println("Problem reading file");
            System.err.println("IOException: " + e.getMessage());
        }
    }
}
