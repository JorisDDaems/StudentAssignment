package be.intecbrussel;

import java.util.Scanner;

public class eigenStudentApp {

    public static void main(String[] args) {

        // what values do I need

        eStudent s = new eStudent();
        String name;
        String surname;
        int idnumber;
        int lengtharray;

        Scanner scan = new Scanner(System.in);

        System.out.println("How many students you want to add?");
        lengtharray = scan.nextInt();

        s.setLengtharray(lengtharray);


        for (int i =0; i<s.getLengtharray(); i++){

            System.out.printf("Fill in name student %d%n: ", i+1);
            do {
                name = scan.nextLine();
            }
            while (!s.symbolCheck(name));
            //methode om symbolen te checken
            // en om die dan in lijst te plaatsen

            System.out.printf("Fill in surname student %d%n: ", i+1);
            do {
                surname = scan.nextLine();
            }
            while (!s.symbolCheck(surname));
            //methode om symbolen te checken
            // en om die dan in lijst te plaatsen

            eeStudent student = new eeStudent(name, surname);
            s.addStudents(student);
            System.out.printf("Student with id number %d has been added", eeStudent.getIdnumber());



        }




    }

}
