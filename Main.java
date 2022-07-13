package tracker;

import java.util.Objects;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String input;
        System.out.println("Learning Progress Tracker");

        while (true) {
            input = sc.nextLine();

            if (input.equals("back")) {
                System.out.println("Enter 'exit' to exit the program.");
            } else if (input.isBlank()) {
                System.out.println("No input.");
            } else if (input.equals("add students")) {
                checkStudent(sc);
            } else if (Objects.equals(input, "exit")) {
                System.out.println("Bye!");
                break;
            } else {
                System.out.println("Error: unknown command!");
            }
        }
        sc.close();
    }

    private static void checkStudent(Scanner sc) {

        String fullInf;
        String[] fullInfArr;
        String firstName_regex = "[^'-]\\w*['|-]?\\w*[^'-]";
        String lastName_regex = "([^'-](\\w*['|-]?\\w*[^'-])+ )+";
        String email_regex = "[a-z\\d._-]+@[a-z\\d]+\\.[a-z\\d]+";
        String firstName;
        String lastName;
        String email;
        int counter = 0;

        System.out.println("Enter student credentials or 'back' to return:");
        while (true) {
            fullInf = sc.nextLine();
            fullInfArr = fullInf.split(" ");

            if (fullInf.equals("back")) {
                System.out.printf("Total %d students have been added.", counter);
                break;
            } else if (fullInfArr.length < 3) {
                System.out.println("Incorrect credentials.");
                continue;
            }

            firstName = fullInfArr[0];
            email = fullInfArr[fullInfArr.length - 1];
            lastName = fullInf.substring(firstName.length() + 1, fullInf.length() - email.length());

            if (!firstName.matches(firstName_regex)) {
                System.out.println("Incorrect first name.");
            } else if (!lastName.matches(lastName_regex) || !lastName.matches("([\\w|'|-]+\\s? )+")) {
                System.out.println("Incorrect last name.");
            } else if (!email.matches(email_regex)) {
                System.out.println("Incorrect email.");
            } else {
                System.out.println("The student has been added.");
                counter += 1;
            }
        }
    }


}
