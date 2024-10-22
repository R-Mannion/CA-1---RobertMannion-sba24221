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
         BufferedWriter bw = new BufferedWriter(new FileWriter(outputFilePath))) {
        
        String line;
        while ((line = br.readLine()) != nul){
        String[] nameParts = line.trim().split(" ");//Split first lin einto first and second name variables
        if (nameParts.length < 2){
        bw.write("Error: Invalid name format: " + line); //error message if name format is incorrect
        bw.newLine();
        continue; //moves onto next customer
        }
        
        String firstName = nameParts[0]; //first name (1st line)
        String lastName = String.join(" ", java.util.Arrays.copyOfRange(nameParts, 1, nameParts.length));//second name (1st line)
        String amountSpentStr = br.readLine().trim(); //Amount customer is spending (2nd line)
        String customerClassStr = br.readLine().trim(); //Class customer is in (3rd line)
        String lastPurchaseYearStr = br.readLine().trim(); //Year of customers last purchase (4th line)
        
        if (!isValidFirstName(firstName)) {
            bw.write("Error: Invalid customer first name: " + lastName);//error message for invalid customer first name
            bw.newLine();
            continue;
        }
        
        if (!isValidLastName(lastName)) {
            bw.write("Error: Invalid customer last name: " + firstName); //error message for invalid customer last name
            bw.newLine();
            continue;
        }
        
        
        }
        
        }       
        
        
    }
    
    
    
}
