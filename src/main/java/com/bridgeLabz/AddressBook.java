package com.bridgeLabz;

import java.util.Scanner;

public class AddressBook {
    Scanner scanner = new Scanner(System.in);
    //UC1 creating contact
    public String first_Name;
    public String last_Name;
    public String city;
    public String state;
    public String address;
    public String phoneNumber;
    public String zip;
    public String email;

    //UC2 - Add contact details
    private void addContact() {
        System.out.println("Enter First Name:");
        first_Name = scanner.next();
        System.out.println("Enter Last Name:");
        last_Name = scanner.next();
        System.out.println("Enter City Name:");
        city = scanner.next();
        System.out.println("Enter State Name:");
        state = scanner.next();
        System.out.println("Enter Address:");
        address = scanner.next();
        System.out.println("Enter Phone Number:");
        phoneNumber = scanner.next();
        System.out.println("Enter Zip:");
        zip = scanner.next();
        System.out.println("Enter Email:");
        email = scanner.next();

        System.out.println(first_Name+", "+last_Name+", "+city+", "+state+", "+address+", "+phoneNumber+", "+zip+", "+email);
    }

    //UC3 - Edit Contact
    private void editContact() {
        System.out.println("Enter name of the person to edit details:");
        String editName = scanner.next();
        if(editName.equalsIgnoreCase(first_Name)){
            System.out.println("Edit First Name:");
            first_Name = scanner.next();
            System.out.println("Edit Last Name:");
            last_Name = scanner.next();
            System.out.println("Edit City Name:");
            city = scanner.next();
            System.out.println("Edit State Name:");
            state = scanner.next();
            System.out.println("Edit Address:");
            address = scanner.next();
            System.out.println("Edit Phone Number:");
            phoneNumber = scanner.next();
            System.out.println("Edit Zip:");
            zip = scanner.next();
            System.out.println("Edit Email:");
            email = scanner.next();

            System.out.println(first_Name+", "+last_Name+", "+city+", "+state+", "+address+", "+phoneNumber+", "+zip+", "+email);
        }else {
            System.out.println("Invalid Name...!");
            editContact();
        }

    }

    public static void main(String[] args) {
        AddressBook addressBook = new AddressBook();
        addressBook.addContact();
        addressBook.editContact();
    }

}
