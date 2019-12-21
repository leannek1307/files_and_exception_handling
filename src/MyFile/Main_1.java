package MyFile;

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
public class Main_1 {
    public static void main(String[] args){
        File textFile = new File("/Users/leannekim/Downloads/icons8-plug-70.png");
        if (textFile.exists()){
            System.out.println("file exists");
        } else {
            System.out.println("file does not exist");
        }
    }
}
