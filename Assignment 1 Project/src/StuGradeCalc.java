import java.util.NoSuchElementException;
import java.util.Scanner;
import java.lang.IllegalStateException;

public class StuGradeCalc {
    private String name;
    private int totalScore;
    private int numAssignments;
    private static final int MIN_SCORE = 0;
    private static final int MAX_SCORE = 100;
    private static final char AVERAGE_GRADE_A = 'A';
    private static final char AVERAGE_GRADE_B = 'B';
    private static final char AVERAGE_GRADE_C = 'C';
    private static final char AVERAGE_GRADE_D = 'D';
    private static final char AVERAGE_GRADE_F = 'F';

    public StuGradeCalc(String name) {
        this.name = name;
        this.totalScore = 0;
        this.numAssignments = 0;
    }

    public static String getStudentName(Scanner scanner) {
        String input;
        try {
            do {
                System.out.print("Enter student's name: ");
                input = scanner.nextLine();
                if (!isValidName(input)) {
                    input = "";
                }
            } while (input.isEmpty());
        } catch (NoSuchElementException | IllegalStateException e) {
            System.out.println("An error occurred while reading input: " + e.getMessage());
            input = "";
        }
        return input;
    }

    public static boolean isValidScore(String input) {
        try {
            int score = Integer.parseInt(input);
            if (score < MIN_SCORE || score > MAX_SCORE) {
                System.out.println("Please enter a valid score between " + MIN_SCORE + " and " + MAX_SCORE + ".");
                return false;
            }
            return true;
        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Please enter a numeric score.");
            return false;
        }
    }

    public static boolean isValidName(String input) {
        if (input.trim().isEmpty()) {
            System.out.println("Invalid input. Please enter a name.");
            return false;
        }
        return true;
    }

    public void addAssignmentScore(int score) {
        this.totalScore += score;
        this.numAssignments++;
    }

    public double calculateAverage() {
        if (numAssignments == 0) {
            return 0;
        }
        return (double) totalScore / numAssignments;
    }

    public char determineFinalGrade() {
        double average = calculateAverage();
        if (average >= 90)
            return AVERAGE_GRADE_A;
        if (average >= 80)
            return AVERAGE_GRADE_B;
        if (average >= 70)
            return AVERAGE_GRADE_C;
        if (average >= 60)
            return AVERAGE_GRADE_D;
        return AVERAGE_GRADE_F;
    }

    public String getName() {
        return name;
    }

    public void displayResults() {
        double average = calculateAverage();
        char grade = determineFinalGrade();
        System.out.println("Student: " + getName());
        System.out.printf("Average Score: %.2f%n", average);
        System.out.println("Final Grade: " + grade);
    }

    public void enterAssignmentScores(Scanner scanner) {
        while (true) {
            System.out.print("Enter assignment score (or type 'STOP' to finish inputting scores): ");
            String input = scanner.nextLine();
            if (input.equalsIgnoreCase("STOP")) {
                break;
            }
            if (isValidScore(input)) {
                addAssignmentScore(Integer.parseInt(input));
            }
        }
    }
}