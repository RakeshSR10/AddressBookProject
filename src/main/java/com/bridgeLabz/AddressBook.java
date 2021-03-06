package com.bridgeLabz;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.Comparator;


public class AddressBook {
    static Scanner scanner = new Scanner(System.in);

    //UC5 - Add multiple person contact using Collection
    static ArrayList<String> contact = new ArrayList<String>();

    //UC1 creating contact
    protected static String first_Name;
    protected static String last_Name;
    protected static String city;
    protected static String state;
    protected static String address;
    protected static String phoneNumber;
    protected static String zip;
    protected static String email;

    //UC6 - Adding multiple AddressBooks
    protected static Map<String,AddressBook> multipleAddressBook = new HashMap<String,AddressBook>();

    //UC2 - Add contact details
    private static void addContact() {
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

    //UC3 - Edit Contact using name
    private static void editContact() {
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
    private static void deleteContact() {
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

    private static void userOptions(AddressBook book){
        System.out.println("Enter your choice from below option:");
        while(true)
        {
            System.out.println("1)Add person contact\n2)Show person contact\n3)Delete person contact\n4)Edit person contact\n" +
                               "5)Goto other AddressBook\n6)Search person in city\n7)Search person in state\n" +
                               "8)Count the person by city\n9)Sort person by name\n10)Sort By City\n11)Sort by state\n12)Sort by zip\n13)Exit");

            int select = scanner.nextInt();

            switch(select)
            {
                case 1:
                    book.setDetails();
                    break;

                case 2:
                    book.showDetails();
                    break;

                case 3:
                    book.deleteDetails();
                    break;

                case 4:
                    book.editDetails();
                    break;

                case 5:
                    setMultipleBook();
                    break;

                case 6:
                    searchPersonIncity();
                    break;

                case 7:
                    searchPersonInState();
                    break;

                case 8:
                    countPersonsByCity();
                    break;

                case 9:
                    sortByName();
                    break;

                case 10:
                    sortPersonsByCity();
                    break;

                case 11:
                    sortPersonsByState();
                    break;

                case 12:
                    sortPersonsByZipCode();
                    break;

                case 13:
                    System.exit(0);
                    break;

                default :
                    System.out.println("Invalid Input");

            }
        }
    }

    // Add Multiple Address Books
    public static void setMultipleBook(){
        Scanner user = new Scanner(System.in);
        System.out.println("List of Address Books: ");
        for(Map.Entry m :multipleAddressBook.entrySet()){
            System.out.println(m.getKey());
        }
        while(true){
            System.out.println("Enter key of AddressBook which you have to access ");
            String key = user.nextLine();
            if(multipleAddressBook.containsKey(key)){
                userOptions(multipleAddressBook.get(key));
                break;
            }
            else
                System.out.println("Invalid Key Enter Correct key");
        }
    }

    //UC7 - Ability to check duplicate entries of person
    public static boolean checkIsDuplicate(String personName){
        if(first_Name.contains(personName))
            return true;
        else
            return false;
    }

    //UC8 search person using city across multiple AddressBooks
    public static void searchPersonIncity(){
        Scanner userInput=new Scanner(System.in);
        System.out.print("Enter city name :");
        int flag=0;
        String cityName=userInput.nextLine();
        for(Map.Entry m : multipleAddressBook.entrySet()){
            AddressBook addressbook=(AddressBook) m.getValue();
            for(String city : addressbook.city) {
                if(city.equalsIgnoreCase(cityName)) {
                    flag=1;
                    System.out.println(first_Name+" "+last_Name);
                }
            }
        }
        if(flag==0)
            System.out.println("This City does not exists!");
    }

    //UC9 search person using state
    public static void searchPersonInState(){
        Scanner user = new Scanner(System.in);
        System.out.print("Enter State name :");
        int flag=0;
        String stateName=user.nextLine();
        for(Map.Entry m : multipleAddressBook.entrySet()){
            AddressBook addressbook=(AddressBook) m.getValue();
            for(String state : addressbook.state) {
                if(state.equalsIgnoreCase(stateName)) {
                    flag=1;
                    System.out.println(first_Name);
                }
            }
        }
        if(flag==0)
            System.out.println("This state does not exists!");
    }

    //UC10 - Count person by city
    public static void countPersonsByCity(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the city name ");
        String cityName= sc.nextLine();
        List<Contact>personsInCity=getPersonsByCity(cityName);
        if(personsInCity.isEmpty())
            System.out.println("City "+cityName+" Does Not Exists !");
        else
            System.out.println("Total No. Of Persons Found In "+cityName.toUpperCase()+" Are :"+personsInCity.stream().count());
    }

    public static List<Contact> getPersonsByCity(String cityName) {
        List<Contact> list = personsInCity.entrySet()
                                          .stream()
                                          .filter(city->city.getValue().equalsIgnoreCase(cityName))
                                          .map(personInCity->personInCity.getKey())
                                          .collect(Collectors.toList());
        return list;
    }

    //UC11 Ability sort person by using name
    public static void sortByName(){
        first_Name.stream().sorted().forEach(System.out::println);
    }

    //UC12 Ability sort by city,state and zip
    public static void sortPersonsByCity() {
        List<String> cityName = city.stream().sorted().
                collect(Collectors.toList());
        System.out.println("Sorted list by city");
        cityName.forEach(System.out::println);

    }

    //by state
    public static void sortPersonsByState() {
        List<String> stateName = state.stream().sorted().
                collect(Collectors.toList());
        System.out.println("Sorted list by state");
        stateName.forEach(System.out::println);

    }

    //by zip
    public static void sortPersonsByZipCode() {
        List<String> zipcode = zip.stream().sorted().
                collect(Collectors.toList());
        System.out.println("Sorted list by zipcode");
        zipcode.forEach(System.out::println);
    }

    //show person details
    private static void showContact() {
        System.out.println(contact);
    }

    //main
    public static void main(String[] args) {
        AddressBook AddressBook1 = new AddressBook();
        AddressBook AddressBook2 = new AddressBook();
        multipleAddressBook.put("AddressBook1",AddressBook1);
        multipleAddressBook.put("AddressBook2",AddressBook2);

        setMultipleBook();
    }
}
