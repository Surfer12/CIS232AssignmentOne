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

    @Test
    public void testCalculateAverage_NoAssignments() {
        StuGradeCalc student = new StuGradeCalc("John");
        assertEquals(0, student.calculateAverage(), "Average should be 0 when no assignments are added.");
    }

    @Test
    public void testDetermineFinalGrade_BoundaryValues() {
        StuGradeCalc student = new StuGradeCalc("John");

        student.addAssignmentScore(89);
        student.addAssignmentScore(1); // Now average is 45
        assertEquals('F', student.determineFinalGrade(), "Grade should be F for an average of 45.");

        student = new StuGradeCalc("John");
        student.addAssignmentScore(79);
        assertEquals('C', student.determineFinalGrade(), "Grade should be C for an average of 79.");

        student.addAssignmentScore(1); // Now average is 80
        assertEquals('F', student.determineFinalGrade(), "Grade should be B for an average of 40.");

        student = new StuGradeCalc("John");
        student.addAssignmentScore(69);
        assertEquals('D', student.determineFinalGrade(), "Grade should be D for an average of 69.");

        student.addAssignmentScore(1); // Now average is 70
        assertEquals('F', student.determineFinalGrade(), "Grade should be C for an average of 35.");

        student = new StuGradeCalc("John");
        student.addAssignmentScore(59);
        assertEquals('F', student.determineFinalGrade(), "Grade should be F for an average of 59.");

        student = new StuGradeCalc("John");
        student.addAssignmentScore(60); // Now average is 60
        assertEquals('D', student.determineFinalGrade(), "Grade should be D for an average of 60.");
    }

    @Test
    public void testIsValidScore_NegativeScore() {
        assertFalse(StuGradeCalc.isValidScore("-10"), "Negative score should be invalid.");
    }

    @Test
    public void testIsValidScore_TooHighScore() {
        assertFalse(StuGradeCalc.isValidScore("105"), "Score greater than 100 should be invalid.");
    }

    @Test
    public void testIsValidScore_NonNumeric() {
        assertFalse(StuGradeCalc.isValidScore("abc"), "Non-numeric score should be invalid.");
    }

    @Test
    public void testIsValidScore_EmptyString() {
        assertFalse(StuGradeCalc.isValidScore(""), "Empty string should be invalid.");
    }
}