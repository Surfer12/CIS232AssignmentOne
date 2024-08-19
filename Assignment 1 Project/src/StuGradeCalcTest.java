import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Scanner;

public class StuGradeCalcTest{
   @Test
   public void testCalculateAverage() {
      Student student = new Student("John Doe");
      student.addAssignmentScore(90);
      student.addAssignmentScore(80);
      GradeCalculator gradeCalculator = new GradeCalculator();
      assertEquals(85.0, gradeCalculator.calculateAverage(student), 0.01);
   }

   @Test
   public void testDetermineFinalGrade() {
      GradeCalculator gradeCalculator = new GradeCalculator();
      assertEquals('A', gradeCalculator.determineFinalGrade(95));
      assertEquals('B', gradeCalculator.determineFinalGrade(85));
      assertEquals('C', gradeCalculator.determineFinalGrade(75));
      assertEquals('D', gradeCalculator.determineFinalGrade(65));
      assertEquals('F', gradeCalculator.determineFinalGrade(55));
   }

   @Test
   public void testIsValidScore() {
      assertTrue(InputValidator.isValidScore("85"));
      assertFalse(InputValidator.isValidScore("105"));
      assertFalse(InputValidator.isValidScore("abc"));
   }

   @Test
   public void testIsValidName() {
      assertTrue(InputValidator.isValidName("John Doe"));
      assertFalse(InputValidator.isValidName("12345"));
      assertFalse(InputValidator.isValidName("!@#$%"));
   }

   @Test
   public void testGetStudentName() {
      InputStream in = new ByteArrayInputStream("John Doe\n".getBytes());
      System.setIn(in);
      Scanner scanner = new Scanner(System.in);
      assertEquals("John Doe", InputReaders.getStudentName(scanner));
   }

   @Test
   public void testEnterAssignmentScores() {
      InputStream in = new ByteArrayInputStream("90\n80\nSTOP\n".getBytes());
      System.setIn(in);
      Scanner scanner = new Scanner(System.in);
      Student student = new Student("John Doe");
      InputReaders enterScores = new InputReaders();
      enterScores.readAssignmentScores(scanner, student);
      assertEquals(170, student.getTotalScore());
      assertEquals(2, student.getNumAssignments());
   }
}