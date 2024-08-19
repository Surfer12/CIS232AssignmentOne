import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class StuGradeCalcTest {

    @Test
    public void testGetName_ValidName() {
        String input = "John Doe\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        Scanner scanner = new Scanner(System.in);
        StuGradeCalc student = new StuGradeCalc("John Doe");
        String name = student.getName();
        assertEquals("John Doe", name);
    }

    @Test
    public void testIsValidScore_ValidScore() {
        assertTrue(StuGradeCalc.isValidScore("85"));
    }

    @Test
    public void testIsValidScore_InvalidScore() {
        assertFalse(StuGradeCalc.isValidScore("105"));
    }

    @Test
    public void testIsValidName_ValidName() {
        assertTrue(StuGradeCalc.isValidName("Jane"));
    }

    @Test
    public void testIsValidName_InvalidName() {
        assertFalse(StuGradeCalc.isValidName(""));
    }

    @Test
    public void testAddAssignmentScore() {
        StuGradeCalc student = new StuGradeCalc("John");
        student.addAssignmentScore(90);
        assertEquals(90, student.calculateAverage());
    }

    @Test
    public void testCalculateAverage() {
        StuGradeCalc student = new StuGradeCalc("John");
        student.addAssignmentScore(90);
        student.addAssignmentScore(80);
        assertEquals(85.0, student.calculateAverage());
    }

    @Test
    public void testDetermineFinalGrade() {
        StuGradeCalc student = new StuGradeCalc("John");
        student.addAssignmentScore(90);
        student.addAssignmentScore(80);
        assertEquals('B', student.determineFinalGrade());
    }

    @Test
    public void testGetName() {
        StuGradeCalc student = new StuGradeCalc("John");
        assertEquals("John", student.getName());
    }

    @Test
    public void testDisplayResults() {
        StuGradeCalc student = new StuGradeCalc("John");
        student.addAssignmentScore(90);
        student.addAssignmentScore(80);
        student.displayResults();
        // This test is for manual verification as it prints to the console
    }

    @Test
    public void testEnterAssignmentScores() {
        String input = "90\n80\nstop\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        Scanner scanner = new Scanner(System.in);
        StuGradeCalc student = new StuGradeCalc("John");
        student.enterAssignmentScores(scanner);
        assertEquals(85.0, student.calculateAverage());
    }
}