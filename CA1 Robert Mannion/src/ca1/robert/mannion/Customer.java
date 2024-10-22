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

public class Customer {
    private String firstName;
    private String lastName;
    private double amountSpent;
    private int customerClass;
    private int lastPurchaseYear;


    


public Customer(String firstName, String lastName, double amountSpent, int customerClass, int lastPurchaseYear) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.amountSpent = amountSpent;
        this.customerClass = customerClass;
        this.lastPurchaseYear = lastPurchaseYear;
}
    
    private static boolean isValidFirstName(String firstName) {
    return firstName.matches("[a-zA-Z]+"); //defines isValidFirstName //only allows for letters in firstName
    }
    
    private static boolean isValidLastName(String lastName) {
    return lastName.matches("[a-zA-Z0-9]+");//defines isValidLastName //allows letters and numbers in lastname
    }
    
    
    
    public static void main(String[] args) {
        String inputFilePath = "testCustomers.txt"; //input file path
        String outputFilePath = "testcustomerdiscount.txt";  //output file path
        
        try (BufferedReader br = new BufferedReader(new FileReader(inputFilePath));
         BufferedWriter bw = new BufferedWriter(new FileWriter(outputFilePath))) {
        
        String line;
        while ((line = br.readLine()) != null){
        String[] nameParts = line.trim().split(" ");//Split first lin einto first and second name variables
        if (nameParts.length < 2){
        bw.write("Error: Invalid name format: " + line); //error message if name format is incorrect
        bw.newLine();
        continue; //moves onto next customer
        }
        
     
        
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
        
        
        double amountSpent; 
        try {
            amountSpent = Double.parseDouble(amountSpentStr);//convert from string to double
        } catch (NumberFormatException e){
        bw.write("Error: Invalid amount entered for customer: " + firstName + " " + lastName); //catch error and output error message
        bw.newLine();
        continue; //program moves on and skip rest current customers loop
        }
        
        int customerClass;
        try {
            customerClass = Integer.parseInt(customerClass); //converts variable to an integer
            if (customerClass < 1 || customerClass > 3){ //checks if class is between 1 and 3
            bw.write("Error: Class must be between 1 and 3 for customer: " + firstName + " " + lastName); //error message if class falls outside the range
            bw.newLine();
            continue;
            }
        
 
        } catch (NumberFormatException e){ //catch if input is not a number
            bw.write("Error: Invalid class for customer: " + firstName + " " + lastName); //error message if class is input is not a number
            bw.newLine();
            continue;
        
        }
        
        int lastPurchaseYear;
        try {
        lastPurchaseYear = Integer.parseInt(lastPurchaseYearStr); //converts the year of the customers last purchase from a string to an integer
        if (lastPurchaseYear > 2024) { //checks to make sure the year given is not a future year
        bw.write("Error: Invalid year of last purchase for customer: " + firstName + " " + lastName); //error message if the year gievn is after the current year
        bw.newLine();
        continue;
        }
        
        
        } catch (NumberFormatException e) {
        bw.write("Error: Invalid year for customer: " + firstName + " " + lastName); //error message if the year inputted is invalid
        bw.newLine();
        continue;
        }
        
        Customer customer = new Customer(firstName, lastName, amountSpent, customerClass, lastPurchaseYear);
        double finalCost = customer.calculateFinalCost();
        bw.write(customer.getFullName() + " " + finalCost);
        bw.newLine();
        }
        
        } catch (IOException e) {
        e.printStackTrace(); //To catch when there is an IOException
        }       
        
    }
    
}

