import java.util.Stack;

public class BracketValidator {

    // Method called checkValidParentheses that returns a boolean indicating whether a string of brackets is valid or not.
    public static boolean checkValidParentheses(String expression) {

        if (expression == null || expression.isEmpty()) {
            return true;
        }

        String[] brackets = expression.split("");
        Stack<String> stack = new Stack<>();

        for (String b : brackets) {
            String reversedBracket = getReversedBracket(b);

            if (isLeftBracket(b)) {
                stack.push(b);
            } else {
                if (stack.isEmpty() || !stack.pop().equals(reversedBracket)) {
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }

    // Private helper method called isLeftBracket that returns a boolean value to indicate whether the bracket is a left (opening) bracket.
    private static boolean isLeftBracket(String bracket) {
        return bracket.equals("(") || bracket.equals("[") || bracket.equals("{");
    }

    // Private helper method called getReversedBracket that returns a String which is the reverse version of the bracket passed to the method.
    private static String getReversedBracket(String bracket) {
        return switch (bracket) {
            case ")" -> "(";
            case "]" -> "[";
            case "}" -> "{";
            default -> ""; // Invalid bracket
        };
    }
}