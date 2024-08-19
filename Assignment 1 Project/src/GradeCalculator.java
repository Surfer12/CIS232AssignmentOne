public class GradeCalculator {
    private static final char AVERAGE_GRADE_A = 'A';
    private static final char AVERAGE_GRADE_B = 'B';
    private static final char AVERAGE_GRADE_C = 'C';
    private static final char AVERAGE_GRADE_D = 'D';
    private static final char AVERAGE_GRADE_F = 'F';

    public double calculateAverage(Student student) {
        if (student.getNumAssignments() == 0) {
            return 0;
        }
        return (double) student.getTotalScore() / student.getNumAssignments();
    }

    public char determineFinalGrade(double average) {
        if (average >= 90) return AVERAGE_GRADE_A;
        if (average >= 80) return AVERAGE_GRADE_B;
        if (average >= 70) return AVERAGE_GRADE_C;
        if (average >= 60) return AVERAGE_GRADE_D;
        return AVERAGE_GRADE_F;
    }
}