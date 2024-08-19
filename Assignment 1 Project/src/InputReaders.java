import java.util.Scanner;
import java.util.NoSuchElementException;
import java.lang.IllegalStateException;

public class InputReaders {
    public static String getStudentName(Scanner scanner) {
        String input;
        try {
            do {
                System.out.print("Enter student's name: ");
                input = scanner.nextLine();
                if (!InputValidator.isValidName(input)) {
                    input = "";
                }
            } while (input.isEmpty());
        } catch (NoSuchElementException | IllegalStateException e) {
            System.out.println("An error occurred while reading input: " + e.getMessage());
            input = "";
        }
        return input;
    }

    public void readAssignmentScores(Scanner scanner, Student student) {
        System.out.print("Enter assignment score (or type 'STOP' to finish inputting scores): ");
        while (scanner.hasNextLine()) {
            String input = scanner.nextLine();
            if (input.equalsIgnoreCase("STOP")) {
                break;
            }
            if (InputValidator.isValidScore(input)) {
                student.addAssignmentScore(Integer.parseInt(input));
            }
            System.out.print("Enter assignment score (or type 'STOP' to finish inputting scores): ");
        }
    }
}