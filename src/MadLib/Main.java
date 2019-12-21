package MadLib;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.io.*;
import java.lang.*;
/**
 *
 * @author leannekim
 */
public class Main {
    public static void main(String[] args){
        File story = new File("story.txt");
        File verbs = new File("verbs.txt");
        File nouns = new File("nouns.txt");
        FileReader in, inVerb, inNoun;
        BufferedReader readFile, readFileVerb, readFileNoun;
        String line, lineVerb, lineNoun;
        String[] array;
        int randomInt = 0;
        
        try {
            in = new FileReader(story);
            readFile = new BufferedReader(in);
            
            inVerb = new FileReader(verbs);
            readFileVerb = new BufferedReader(inVerb);
            
            inNoun = new FileReader(nouns);
            readFileNoun = new BufferedReader(inNoun);
            
            while ((line = readFile.readLine()) != null){
                array = line.split(" ");
                for (int i = 0; i < array.length; i++){
                    if (array[i].equals("%")){  // verb
                        randomInt = (int)(Math.random() * 4) + 0;
                        for (int j = 0; j < randomInt; j++){
                            lineVerb = readFileVerb.readLine();
                            array[i] = lineVerb;
                        }
                    } else if (array[i].equals("#") || array[i].equals("#s")){   // noun
                        randomInt = (int)(Math.random() * 4) + 0;
                        for (int j = 0; j < randomInt; j++){
                            lineNoun = readFileNoun.readLine();
                            array[i] = lineNoun;
                        }
                    }
                }
                for (String array1 : array) {
                    System.out.print(array1 + " ");
                }
                System.out.println();
            }   
            in.close();
            readFile.close();
            inVerb.close();
            readFileVerb.close();
            inNoun.close();
            readFileNoun.close();
        }catch (IOException e){
            System.out.println("IOException: " + e.getMessage());
        }
    }
}
