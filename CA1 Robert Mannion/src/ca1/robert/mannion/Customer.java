/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */



// https://github.com/R-Mannion/CA-1---RobertMannion-sba24221
//Link to GitHub repo




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
    
public String getFullName() {
    return firstName + " " + lastName; //method for getting customers full name by combining first and last names
}


//Class 1 discounts = 30%, 20%, 10% depending on year of last purchase
//Class 2 discounts = 15%, 13%, 5% depending on year of last purchase
//Class 3 discounts = 3%, 0% depending on year of last purchase

public double calculateFinalCost() {
    double discountRate = 0.0;
    int currentYear = 2024; 
    int yearsSinceLastPurchase = currentYear - lastPurchaseYear;

    if (customerClass == 1) {
        if (lastPurchaseYear == 2024) {
        discountRate = 0.30;
        } else if (yearsSinceLastPurchase <= 5){
        discountRate = 0.20;
        } else {
           discountRate = 0.10; 
        }
    } else if (customerClass == 2) {
        if (lastPurchaseYear == 2024) {
            discountRate = 0.15; 
        } else if (yearsSinceLastPurchase <= 5) {
            discountRate = 0.13; 
        } else {
            discountRate = 0.05; 
        }
    } else if (customerClass == 3) {
        if (lastPurchaseYear == 2024) {
            discountRate = 0.03; 
        } else if (yearsSinceLastPurchase > 5) {
            discountRate = 0.00; 
        }
        
    } 
            
            
            
            
    double discount = amountSpent * discountRate;
    return amountSpent - discount;
        
        
        
    
    




    
}
    




    private static boolean isValidFirstName(String firstName) {
    return firstName.matches("[a-zA-Z]+"); //defines isValidFirstName //only allows for letters in firstName
    }
    
    private static boolean isValidLastName(String lastName) {
    return lastName.matches("[a-zA-Z0-9]+");//defines isValidLastName //allows letters and numbers in lastname
    }
    
    
    
    public static void main(String[] args) {
        String inputFilePath = "C:/Users/manni/Desktop/Prog&Maths CA1/CA-1---RobertMannion-sba24221/CA1 Robert Mannion/src/ca1/robert/mannion/customers.txt"; //input file path
        String outputFilePath = "C:\\Users\\manni\\Desktop\\Prog&Maths CA1\\CA-1---RobertMannion-sba24221\\CA1 Robert Mannion\\src\\ca1\\robert\\mannion\\customerdiscount.txt";  //output file path
        
        try (BufferedReader br = new BufferedReader(new FileReader(inputFilePath));
         BufferedWriter bw = new BufferedWriter(new FileWriter(outputFilePath))) {
        
        String line;
        while ((line = br.readLine()) != null){
            String[] nameParts = line.trim().split(" ");//Split first lin einto first and second name variables
            if (nameParts.length < 2){
                bw.write("Error: Invalid name format: " + line); //error message if name format is incorrect
                bw.newLine();//moves to next line
                continue; //moves onto next customer
                }
        
     String firstName = nameParts[0];
                String lastName = String.join(" ", java.util.Arrays.copyOfRange(nameParts, 1, nameParts.length));
                String amountSpentStr = br.readLine().trim(); 
                String customerClassStr = br.readLine().trim(); 
                String lastPurchaseYearStr = br.readLine().trim();
        
        if (!isValidFirstName(firstName)) {
            bw.write("Error: Invalid customer first name: " + lastName);//error message for invalid customer first name
            bw.newLine();//moves to next line
            continue;
        }
        
        if (!isValidLastName(lastName)) {
            bw.write("Error: Invalid customer last name: " + firstName); //error message for invalid customer last name
            bw.newLine();//moves to next line
            continue;
        }
        
        
        double amountSpent; 
        try {
            amountSpent = Double.parseDouble(amountSpentStr);//convert from string to double
        } catch (NumberFormatException e){
            bw.write("Error: Invalid amount entered for customer: " + firstName + " " + lastName); //catch error and output error message
            bw.newLine();//moves to next line
            continue; //program moves on and skip rest current customers loop
            }
        
        int customerClass;
        try {
            customerClass = Integer.parseInt(customerClassStr); //converts variable to an integer
            if (customerClass < 1 || customerClass > 3){ //checks if class is between 1 and 3
            bw.write("Error: Class must be between 1 and 3 for customer: " + firstName + " " + lastName); //error message if class falls outside the range
            bw.newLine();//moves to next line
            continue;
            }
        
        } catch (NumberFormatException e){ //catch if input is not a number
            bw.write("Error: Invalid class for customer: " + firstName + " " + lastName); //error message if class is input is not a number
            bw.newLine();//moves to next line
            continue;
        }
        
        int lastPurchaseYear;
        try {
            lastPurchaseYear = Integer.parseInt(lastPurchaseYearStr); //converts the year of the customers last purchase from a string to an integer
        if (lastPurchaseYear > 2024) { //checks to make sure the year given is not a future year
            bw.write("Error: Invalid year of last purchase for customer: " + firstName + " " + lastName); //error message if the year gievn is after the current year
            bw.newLine();//moves to next line
            continue;
        }
        
        
        } catch (NumberFormatException e) {
            bw.write("Error: Invalid year for customer: " + firstName + " " + lastName); //error message if the year inputted is invalid
            bw.newLine();//moves to next line
            continue;
        }
        
        Customer customer = new Customer(firstName, lastName, amountSpent, customerClass, lastPurchaseYear);
        double finalCost = customer.calculateFinalCost();
            bw.write(customer.getFullName());
            bw.newLine();//moves to next line
            bw.write(Double.toString(finalCost)); 
            bw.newLine();//moves to next line
        }
        
        } catch (IOException e) {
        e.printStackTrace(); //To catch when there is an IOException
        }       
        
    }
    
}

