package MergeFiles;

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
        File file1 = new File("file1.txt");
        File file2 = new File("file2.txt");
        File file3 = new File("file3.txt");
        
        FileReader in, in2;
        BufferedReader readFile, readFile2;
        FileWriter out;
        BufferedWriter writeFile;
        
        String line;
        String[] array, array2;
        
        ArrayList<Integer> combined = new ArrayList<>();
        
        try {
            in = new FileReader(file1);
            readFile = new BufferedReader(in);
            
            in2 = new FileReader(file2);
            readFile2 = new BufferedReader(in2);
            
            out = new FileWriter(file3);
            writeFile = new BufferedWriter(out);
            
            /* read first file and add to arrayList */
            while ((line = readFile.readLine()) != null){
                array = line.split(" ");
                int[] intArray = new int[array.length];
                for (int i = 0; i < intArray.length; i++){
                    intArray[i] = Integer.parseInt(array[i]);
                    combined.add(intArray[i]);
                }
            }
            
            /* read second file and add to arrayList */
            while ((line = readFile2.readLine()) != null){
                array2 = line.split(" ");
                int[] intArray2 = new int[array2.length];
                for (int i = 0; i < intArray2.length; i++){
                    intArray2[i] = Integer.parseInt(array2[i]);
                    combined.add(intArray2[i]);
                }
            }
            
            Collections.sort(combined); // sort in ascending order

            for (int i = 0; i < combined.size(); i++){
                String str = combined.get(i).toString();
                writeFile.write(str);
                writeFile.newLine();
                System.out.print(combined.get(i) + " ");
            }

            in.close(); readFile.close(); 
            in2.close(); readFile2.close(); 
            writeFile.close();  
        } catch (FileNotFoundException e){
            System.out.println("File does not exist or could not be found.");
            System.err.println("FileNotFoundException: " + e.getMessage());
        } catch (IOException e){
            System.out.println("Problem reading file");
            System.err.println("IOException: " + e.getMessage());
        }
    }
}
