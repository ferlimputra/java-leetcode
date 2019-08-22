import java.math.BigInteger;
import java.util.Arrays;

/*
 * You are given two non-empty linked lists representing two non-negative integers. The digits are
 * stored in reverse order and each of their nodes contain a single digit. Add the two numbers and
 * return it as a linked list.
 * 
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 * 
 * Example:
 * 
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 
 * Output: 7 -> 0 -> 8
 * 
 * Explanation: 342 + 465 = 807
 */

class ListNode {
  int val;
  ListNode next;

  ListNode(int x, ListNode next) {
    val = x;
    this.next = next;
  }

  public String toString(boolean formatted) {
    String list = String.valueOf(val);

    if (next != null) {
      list = String.format(formatted ? "%s -> " : "%s", next.toString(formatted)) + list;
    }
    return list;
  }
}


class Solution2 {
  public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    BigInteger l1Value = new BigInteger(l1.toString(false));
    BigInteger l2Value = new BigInteger(l2.toString(false));
    BigInteger l3Value = l1Value.add(l2Value);
    System.out.println("L3: " + l3Value);

    int[] l3Nums = String.valueOf(l3Value).chars().map(Character::getNumericValue).toArray();
    return initializeListNodes(l3Nums);
  }

  public static ListNode initializeListNodes(int... nums) {
    return initializeListNode(nums.length - 1, nums);
  }

  public static ListNode initializeListNode(int index, int... nums) {
    return new ListNode(nums[index], index - 1 > -1 ? initializeListNode(index - 1, nums) : null);
  }
}


/**
 * AddTwoNumbers
 */
public class AddTwoNumbers {

  public static void main(String[] args) {
    ListNode l1 = Solution2.initializeListNodes(3, 4, 2);
    ListNode l2 = Solution2.initializeListNodes(4, 6, 5);

    System.out.println(String.format("L1: %s", l1.toString(true)));
    System.out.println(String.format("L2: %s", l2.toString(true)));

    ListNode l3 = Solution2.addTwoNumbers(l1, l2);
    System.out.println(String.format("L3: %s", l3.toString(true)));
  }
}
