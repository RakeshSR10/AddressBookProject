package com.bridgeLabz;

import java.util.ArrayList;
import java.util.Scanner;

public class AddressBook {
    Scanner scanner = new Scanner(System.in);

    //UC5 - Add multiple person contact using Collection
    ArrayList<String> contact = new ArrayList<String>();

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
        contact.add(first_Name = scanner.next());
        System.out.println("Enter Last Name:");
        contact.add(last_Name = scanner.next());
        System.out.println("Enter City Name:");
        contact.add(city = scanner.next());
        System.out.println("Enter State Name:");
        contact.add(state = scanner.next());
        System.out.println("Enter Address:");
        contact.add(address = scanner.next());
        System.out.println("Enter Phone Number:");
        contact.add(phoneNumber = scanner.next());
        System.out.println("Enter Zip:");
        contact.add(zip = scanner.next());
        System.out.println("Enter Email:");
        contact.add(email = scanner.next());

        System.out.println(contact);
    }

    //UC3 - Edit Contact
    private void editContact() {
        System.out.println("Enter name of the person to edit details:");
        String editName = scanner.next();
        int position = first_Name.indexOf(editName);

        if(first_Name.equalsIgnoreCase(editName)){
            System.out.println("Edit First Name:");
            contact.set(position,first_Name = scanner.next());
            System.out.println("Edit Last Name:");
            contact.set(position,last_Name = scanner.next());
            System.out.println("Edit City Name:");
            contact.set(position,city = scanner.next());
            System.out.println("Edit State Name:");
            contact.set(position,state = scanner.next());
            System.out.println("Edit Address:");
            contact.set(position,address = scanner.next());
            System.out.println("Edit Phone Number:");
            contact.set(position,phoneNumber = scanner.next());
            System.out.println("Edit Zip:");
            contact.set(position,zip = scanner.next());
            System.out.println("Edit Email:");
            contact.set(position,email = scanner.next());

            System.out.println(first_Name+", "+last_Name+", "+city+", "+state+", "+address+", "+phoneNumber+", "+zip+", "+email);
        }else {
            System.out.println("Invalid Name...!");
            editContact();
        }

    }

    //UC4 - Delete Contact
    private void deleteContact() {
        System.out.println("Enter name of the person to delete details:");
        String deleteName = scanner.next();
        if(deleteName.equalsIgnoreCase(first_Name)){
            contact.remove(first_Name);
            contact.remove(last_Name);
            contact.remove(city);
            contact.remove(state);
            contact.remove(address);
            contact.remove(phoneNumber);
            contact.remove(zip);
            contact.remove(email);
            System.out.println(contact);
        }else{
            System.out.println("Invalid Name...!");
            deleteContact();
        }
    }

    private void userOptions(){
        while(true)
        {
            System.out.println("1)Add person contact\n2)Show details of person\n3)Delete person contact\n4)Edit person contact\n5)Exit");
            int select = scanner.nextInt();
            switch(select)
            {
                case 1:
                    addContact();
                    break;

                case 2:
                    showContact();
                    break;

                case 3:
                    deleteContact();
                    break;

                case 4:
                    editContact();
                    break;

                case 5:
                    System.exit(0);
                    break;
                default :
                    System.out.println("Invalid Input");
            }
        }
    }
    //show person details
    private void showContact() {
        System.out.println(contact);
    }

    //main
    public static void main(String[] args) {
        AddressBook addressBook = new AddressBook();
        addressBook.userOptions();
    }
}
