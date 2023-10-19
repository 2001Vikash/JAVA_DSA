package com.company;

import javax.swing.plaf.basic.BasicHTML;

// CUSTOM CLASS...
 class Employee{// yaha pr public nhi likh sakte hai.
    int id;
    String name;
    // Method in custom class
    public void  printDetails(){
        System.out.println(id+" "+name);
    }
}
public class CWH_363738_oops_custom_class {
    public static void main(String[] args) {
        System.out.println("This is my custom class ");
        Employee Vikash = new Employee();// Instantiation a new employee object.
        Employee Bhavesh = new Employee();// Instantiation a new employee object.
        // Setting Attributes
       Vikash.id=72;
       Vikash.name="Vikash yadav";
       Bhavesh.id=73;
       Bhavesh.name="Bhavesh Badani";
        // Printing the Attributes with method calling and direct printing.
        Vikash.printDetails();
        Bhavesh.printDetails();
        System.out.println(Vikash.id);
        System.out.println(Vikash.name);
        System.out.println(Bhavesh.id+" "+ Bhavesh.name);
    }
}
