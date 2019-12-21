package WordCount;


import java.io.*;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author leannekim
 */
public class Main {
    public static void main(String[] args){
        File wordCount = new File("source.txt");
        FileReader in;
        BufferedReader readFile;
        
        int numWords = 0;
        int numChar = 0;
        int avgWordLength;
        
        try {
            in = new FileReader(wordCount);
            readFile = new BufferedReader(in);
            
            String currentLine = readFile.readLine();
            while (currentLine != null){
                String[] words = currentLine.split(" ");    // getting number of letters in current line
                numWords += words.length;   // update number of words
                
                for (String word : words){
                    numChar += word.length();
                }
                currentLine = readFile.readLine();
            }
            avgWordLength = numChar / numWords;
            System.out.println("Average word length: " + avgWordLength);
            in.close();
            readFile.close();
        } catch (IOException e){
            System.out.println("IOException: " + e.getMessage());
        }
    }
}
