import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/*
 * Given a non-empty array of integers, return the k most frequent elements.
 * 
 * Example 1:
 * 
 * Input: nums = [1,1,1,2,2,3], k = 2 Output: [1,2]
 * 
 * Example 2:
 * 
 * Input: nums = [1], k = 1 Output: [1]
 */

/**
 * TopKFrequentElements
 */
public class TopKFrequentElements {

  public static List<Integer> topKFrequent(int[] nums, int k) {
    List<Integer> results;

    /*
     * Solution 1
     *
     * 1. Count occurrence of each elements
     * 
     * 2. Sort result
     */
    Map<Integer, Integer> count = new HashMap<>();

    for (int i = 0; i < nums.length; i++) {
      count.computeIfPresent(nums[i], (key, val) -> val + 1);
      count.computeIfAbsent(nums[i], key -> 1);
    }

    System.out.println(String.format("Count: %s",
        count.entrySet().stream().map(m -> String.format("[%d, %d]", m.getKey(), m.getValue()))
            .collect(Collectors.joining(", "))));

    results =
        count.entrySet().stream().sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
            .limit(k).map(Map.Entry::getKey).collect(Collectors.toList());
    return results;
  }

  public static void main(String[] args) {
    // Test case 1
    int[] nums = new int[] {1, 1, 1, 2, 2, 3};
    int k = 2;

    List<Integer> results = topKFrequent(nums, k); // Arrays.asList(1, 2, 3);
    System.out.println(String.format("Results: %s",
        String.join(", ", results.stream().map(Object::toString).collect(Collectors.toList()))));

    // Test case 2
    int[] nums2 = new int[] {1};
    int k2 = 1;

    List<Integer> results2 = topKFrequent(nums2, k2); // Arrays.asList(1, 2, 3);
    System.out.println(String.format("Results: %s",
        String.join(", ", results2.stream().map(Object::toString).collect(Collectors.toList()))));
  }
}
