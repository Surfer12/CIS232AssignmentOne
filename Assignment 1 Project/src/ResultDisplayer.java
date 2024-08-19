public class ResultDisplayer {
    public void displayResults(Student student, double average, char grade) {
        System.out.println("Student: " + student.getName());
        System.out.printf("Average Score: %.2f%n", average);
        System.out.println("Final Grade: " + grade);
    }
}