public class InputValidator {
    private static final int MIN_SCORE = 0;
    private static final int MAX_SCORE = 100;

    public static boolean isValidScore(String input) {
        if (input.trim().isEmpty()) {
            System.out.println("Invalid input. Please enter a score.");
            return false;
        }
        if (input.matches(".*[!@#$%^&*(),.?\":{}|<>a-zA-Z].*")) {
            System.out.println("Invalid input. Score cannot contain special characters.");
            return false;
        }
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
        if (input.matches(".*[!@#$%^&*(),.?\":{}|<>].*")) {
            System.out.println("Invalid input. Name cannot contain special characters.");
            return false;
        }
        try {
            Double.parseDouble(input);
            System.out.println("Invalid input. Name cannot be a number.");
            return false;
        } catch (NumberFormatException e) {
            System.out.println("Valid name entry.");
        }
        return true;
    }
}