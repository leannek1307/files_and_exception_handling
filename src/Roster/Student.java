package Roster;

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
public class Student implements Serializable{
    private String fName;
    private String lName;
    
    /**
     * constructor
     * pre: none
     * post: A Student object has been created. 
     * Student data has been initialized with parameters.
     */
    public Student(String fName, String lName){
        this.fName = fName;
        this.lName = lName;
    }
    
    public String toString(){
        String stuString;
        stuString = fName + " " + lName;
        return stuString;
    }
}
