package WordStats;

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
    public static void main(String[] args){
        File wordStats = new File("source.txt");
        FileReader in;
        BufferedReader readFile;
        int index = 0;
        int the = 0;
        int and = 0;
        int zoo = 0;
        
        try {
            in = new FileReader(wordStats);
            readFile = new BufferedReader(in);
            
            String currentLine = readFile.readLine();
            while (currentLine != null){
                String[] words = currentLine.split(" ");    // getting number of letters in current line
                
                for (int i = 0; i < words.length; i++){
                    if (words[i].equals("the")){
                        the++;
                    } else if (words[i].equals("and")){
                        and++;
                    } else if (words[i].equals("zoo")){
                        zoo++;
                    }
                }
                
                currentLine = readFile.readLine();
            }
            
            System.out.format("%-10s %-15s \n", "WORD", "OCCURENCES");
            System.out.format("%-10s %-15s \n", "the", the);
            System.out.format("%-10s %-15s \n", "and", and);
            System.out.format("%-10s %-15s \n", "zoo", zoo);
            in.close();
            readFile.close();
        } catch (IOException e){
            System.out.println("IOException: " + e.getMessage());
        }
    }
}
