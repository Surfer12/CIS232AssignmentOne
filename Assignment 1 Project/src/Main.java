import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String name = InputReaders.getStudentName(scanner);

        Student student = new Student(name);
        GradeCalculator gradeCalculator = new GradeCalculator();
        ResultDisplayer resultDisplayer = new ResultDisplayer();
        InputReaders inputReader = new InputReaders();

        inputReader.readAssignmentScores(scanner, student);

        double average = gradeCalculator.calculateAverage(student);
        char grade = gradeCalculator.determineFinalGrade(average);
        resultDisplayer.displayResults(student, average, grade);
    }
}