/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ca1.robert.mannion;

import java.io.BufferedReader; //To read text from input file and increase effeciency with file reader
import java.io.BufferedWriter; //To write text in output file
import java.io.FileReader;      //To read text from input file
import java.io.FileWriter;      //To write text for output file
import java.io.IOException;     //To catch errors from input/output

/**
 *
 * @author manni
 */
public class customerClass {
    
    public static void main(String[] args) {
        String inputFilePath = "testCustomers.txt"; //input file path
        String outputFilePath = "testcustomerdiscount.txt";  //output file path
        
        try (BufferedReader br = new BufferedReader(new FileReader(inputFilePath));
         BufferedWriter bw = new BufferedWriter(new FileWriter(OutputFilePath));       
        
        
    }
    
    
    
}
