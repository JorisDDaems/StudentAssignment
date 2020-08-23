package be.intecbrussel;

import java.util.Scanner;

public class StudentApp {
    private static Scanner kbd = new Scanner(System.in);

    public static void main(String[] args) {

        StudentService s = new StudentService();
        String name;
        String lastName;
        int length;
        int choice = 0;
        int id;

        System.out.println("Welcome"+ "\n" + "-".repeat(8));
        do {
            System.out.println("How many students do you want to save in the list?");
            length = validateNumber();
        } while (length <= 0);

        s.setLengthOfArray(length);

        for (int i = 0; i < s.getLengthOfArray(); i++) {
            System.out.printf("%nEnter name of student %d:%n", i + 1);
            do {
                name = kbd.nextLine();
            } while (!s.isValidName(name));

            System.out.printf("Enter last name of student %d:%n", i + 1);
            do {
                lastName = kbd.nextLine();
            } while (!s.isValidLastName(lastName));

            Student student = new Student(name, lastName);
            s.addStudents(student);
            System.out.printf("Student with id %d has been added%n", student.getId());
        }

        while (choice != 3) {

            do {
                menu();
                choice = validateNumber();
            } while (choice <= 0);

            switch (choice) {
                case 1:
                    do {
                        System.out.println("Enter id:");
                        id = validateNumber();
                    } while (!s.isCorrectId(id));

                    System.out.println("Enter last name");
                    do {
                        lastName = kbd.nextLine();
                    } while (!s.isValidLastName(lastName));

                    s.editLastName(id, lastName);
                    s.printStudents();
                    break;
                case 2:
                    s.sort();
                    s.printStudents();
                    break;
                case 3:
                    kbd.close();
                    break;
                default:
                    System.out.println("Wrong input! Try again");
            }
        }

    }

    private static int validateNumber() {
        int number = 0;
        if (!kbd.hasNextInt()) {
            kbd.next();
        } else {
            number = kbd.nextInt();
            kbd.nextLine();
        }
        return number;
    }

    private static void menu() {
        System.out.println("\nMake a choice to go further?");
        System.out.println("1. Edit last name of student");
        System.out.println("2. Sort and display students");
        System.out.println("3. Exit");
    }
}
