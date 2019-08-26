/**
 * ValidAnagram
 * 
 * Given two strings s and t , write a function to determine if t is an anagram of s.
 * 
 * Example 1:
 * 
 * Input: s = "anagram", t = "nagaram" Output: true
 * 
 * Example 2:
 * 
 * Input: s = "rat", t = "car" Output: false Note: You may assume the string contains only lowercase
 * alphabets.
 * 
 * Follow up: What if the inputs contain unicode characters? How would you adapt your solution to
 * such case?
 */
public class ValidAnagram {

  public static boolean isAnagram(String s, String t) {
    String sortedS = s.chars().sorted()
        .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
        .toString();
    System.out.println(String.format("S: %s", sortedS));

    String sortedT = t.chars().sorted()
        .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
        .toString();
    System.out.println(String.format("T: %s", sortedT));

    return sortedS.equals(sortedT);
  }

  public static void main(String[] args) {
    String s = "rat";
    String t = "car";

    boolean result = isAnagram(s, t);
    System.out.println(String.format("Is Anagram: %s", result));
  }
}
