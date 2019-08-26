import java.util.Stack;

/**
 * ValidParenthesis
 * 
 * Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the
 * input string is valid.
 * 
 * An input string is valid if:
 * 
 * Open brackets must be closed by the same type of brackets. Open brackets must be closed in the
 * correct order. Note that an empty string is also considered valid.
 * 
 * Example 1: Input: "()" Output: true
 * 
 * Example 2: Input: "()[]{}" Output: true
 * 
 * Example 3: Input: "(]" Output: false
 * 
 * Example 4: Input: "([)]" Output: false
 * 
 * Example 5: Input: "{[]}" Output: true
 */
public class ValidParenthesis {

  public static boolean isOpenParenthesis(char c) {
    return c == '{' || c == '(' || c == '[';
  }

  public static char getOpenParenthesis(char c) {
    switch (c) {
      case '}':
        return '{';

      case ']':
        return '[';

      case ')':
        return '(';

      default:
        throw new IllegalArgumentException(
            String.format("No valid open parenthesis found for argument %s", c));
    }
  }

  public static boolean isValid(String s) {
    // Valid if empty
    if (s.isEmpty()) {
      return true;
    }

    Stack<Character> bracketStacks = new Stack<>();

    for (int i = 0; i < s.length(); i++) {
      char c = s.charAt(i);

      if (isOpenParenthesis(c)) {
        bracketStacks.add(c);
      } else {
        char top = bracketStacks.isEmpty() ? '#' : bracketStacks.pop();

        if (top != getOpenParenthesis(c)) {
          return false;
        }
      }
    }
    return bracketStacks.isEmpty();
  }

  // public static boolean isValid(String s) {
  // // Valid if empty
  // if (s.isEmpty()) {
  // return true;
  // }

  // Map<Character, Integer> openBrackets = new HashMap<>();
  // for (int i = 0; i < s.length(); i++) {
  // char c = s.charAt(i);
  // // If it's open, collect to map
  // if (isOpenParenthesis(c)) {
  // openBrackets.computeIfPresent(c, (k, v) -> v + 1);
  // openBrackets.putIfAbsent(c, 1);
  // } else {
  // // Find it's matching open bracket
  // char open = getOpenParenthesis(c);
  // // If it's closing bracket and no matching open is found, then it's invalid
  // if (!openBrackets.containsKey(open)) {
  // return false;
  // } else {
  // // Else reduce the open bracket count and remove it from map if 0
  // openBrackets.computeIfPresent(open, (k, v) -> v - 1);
  // openBrackets.remove(open, 0);
  // }
  // }
  // }
  // return openBrackets.isEmpty();
  // }

  public static void main(String[] args) {
    String s = "([])";

    System.out.println(String.format("Valid: %s", isValid(s)));
  }
}
