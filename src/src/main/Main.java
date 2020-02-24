package main;

import defination.SinglyLinkedList;
import person.Person;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> list1 = new ArrayList<>();
        ArrayList<String> list2 = new ArrayList<>();
        SinglyLinkedList<Person> list = new SinglyLinkedList<>();
        boolean flag = true;
        do {
            System.out.println("Welcome to Mukul Agrawal's Contact List App\n" +
                    "Press 1 to add a new contact\n" +
                    "Press 2 to view all contacts\n" +
                    "Press 3 to search for a contact\n" +
                    "Press 4 to delete a contact\n" +
                    "Press 5 to exit program ");
            int choices = scanner.nextInt();
            scanner.nextLine();
            switch (choices) {
                case 1:
                    addContact(list, list1, list2);
                    break;
                case 2:
                    list.sort();
                    list.print();
                    break;
                case 3:
                    searchContact(list, list2);
                    break;
                case 4:
                    removeContact(list, list1, list2);
                    break;
                case 5:
                    flag = false;
                    break;
            }
        } while (flag);

    }

    public static SinglyLinkedList addContact(SinglyLinkedList list, ArrayList list1, ArrayList list2) {
        Scanner scanner = new Scanner(System.in);
        Person person = new Person();
        String s;
        System.out.print("You have chosen to add a new contact: \n" +
                "Please enter the name of the Person\n" +
                "First Name:");
        String fName = scanner.nextLine();
        person.setfName(fName);
        list2.add(fName);
        System.out.println("Last Name");
        String lName = scanner.nextLine();
        person.setlName(lName);
        list1.add(fName + " " + lName);
        System.out.println("Contact Number: ");
        long phoneNumber = scanner.nextLong();
        person.setPhoneNumber(phoneNumber);
        scanner.nextLine();
        do {
            System.out.print("Would you like to add another contact number? (y/n):");
            s = scanner.next();
            if (s.equalsIgnoreCase("y")) {
                System.out.println("Contact Number: ");
                long phoneNumber1 = scanner.nextLong();
                person.setPhoneNumber(phoneNumber1);
            }
        } while (s.equalsIgnoreCase("y"));
        scanner.nextLine();
        System.out.println("Would you like to add email address? (y/n):");
        s = scanner.next();
        scanner.nextLine();
        if (s.equalsIgnoreCase("y")) {
            System.out.println("Email Address: ");
            String email = scanner.nextLine();
            person.setEmail(email);
        }
        list.add(person);
        Collections.sort(list1);
        Collections.sort(list2);
        return list;
    }

    public static SinglyLinkedList removeContact(SinglyLinkedList list, ArrayList list1, ArrayList list2) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Here are all your contacts:");
        int k = 1;
        for (int i = 0; i < list1.size(); i++) {
            System.out.println(i + 1 + "." + list1.get(i));
            k++;
        }
        System.out.print("Press the number against the contact to delete it:");
        int i = scanner.nextInt();
        list.remove(i);
        System.out.println(list1.get(i - 1) + "'s contact deleted from list!");
        list1.remove(i - 1);
        list2.remove(i - 1);
        return list;
    }

    public static SinglyLinkedList searchContact(SinglyLinkedList list, ArrayList list2) {
        System.out.println("You could search for a contact from their first names:");
        Scanner scanner = new Scanner(System.in);
        String fName = scanner.nextLine();
        int k = 0;
        for (int i = 0; i < list2.size(); i++) {
            if (fName.equals(list2.get(i))) {
                k++;
            }
        }
        if (k == 0) {
            System.out.println("NO RESULTS FOUND!");
        } else {
            System.out.println(k + " match found!");
            for (int i = 0; i < list2.size(); i++) {
                if (fName.equals(list2.get(i))) {
                    list.print(i + 1);
                }
            }
        }
        return list;
    }

}

