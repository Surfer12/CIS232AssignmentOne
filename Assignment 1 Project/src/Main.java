import java.util.Scanner;

public class Main {
   public static void main(String[] args) {
      Scanner scanner = new Scanner(System.in);
      try {
         String studentName = StuGradeCalc.getStudentName(scanner);
         StuGradeCalc student = new StuGradeCalc(studentName);
         student.enterAssignmentScores(scanner);
         student.displayResults();
      } finally {
         scanner.close();
      }
   }
}