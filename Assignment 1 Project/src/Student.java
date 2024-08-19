public class Student {
    private String name;
    private int totalScore;
    private int numAssignments;

    public Student(String name) {
        this.name = name;
        this.totalScore = 0;
        this.numAssignments = 0;
    }

    public String getName() {
        return name;
    }

    public void addAssignmentScore(int score) {
        this.totalScore += score;
        this.numAssignments++;
    }

    public int getTotalScore() {
        return totalScore;
    }

    public int getNumAssignments() {
        return numAssignments;
    }
}