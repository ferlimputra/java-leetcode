import java.lang.reflect.Array;
import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.stream.IntStream;

/*
 * Given nums = [2, 7, 11, 15], target = 9,
 * 
 * Because nums[0] + nums[1] = 2 + 7 = 9, return [0, 1].
 */
class Solution {
  public static int[] twoSum(int[] nums, int target) {
    int[] results = new int[2];

    IntStream.range(0, nums.length).forEach(a -> {
      int match = IntStream.range(a + 1, nums.length).filter(b -> nums[a] + nums[b] == target)
          .findFirst().orElse(-1);

      if (match != -1) {
        results[0] = a;
        results[1] = match;
      }
    });
    return results;
  }

  public static int[] twoSumV2(int[] nums, int target) {
    for (int a = 0; a < nums.length; a++) {
      for (int b = a + 1; b < nums.length; b++) {
        if (nums[a] + nums[b] == target) {
          return new int[] {a, b};
        }
      }
    }
    throw new IllegalArgumentException(
        String.format("%d cannot be obtained with provided nums.", target));
  }

  public static int[] twoSumV3(int[] nums, int target) {
    Map<Integer, Integer> map = new HashMap<>();
    for (int a = 0; a < nums.length; a++) {
      int complement = target - nums[a];
      if (map.containsKey(complement)) {
        return new int[] {map.get(complement), a};
      }
      map.put(nums[a], a);
    }
    throw new IllegalArgumentException(
        String.format("%d cannot be obtained with provided nums.", target));
  }
}


public class TwoSum {
  public static void main(String[] args) {
    int[] nums = {2, 7, 11, 15};
    int target = 22;
    Instant start, end;

    start = Instant.now();
    System.out.println(String.format("Solution 1: %s",
        String.join(", ", Arrays.toString(Solution.twoSum(nums, target)))));
    end = Instant.now();
    System.out.println(String.format("Time elapsed: %ds", Duration.between(start, end).toMillis()));

    start = Instant.now();
    System.out.println(String.format("Solution 2: %s",
        String.join(", ", Arrays.toString(Solution.twoSumV2(nums, target)))));
    end = Instant.now();
    System.out.println(String.format("Time elapsed: %ds", Duration.between(start, end).toMillis()));

    start = Instant.now();
    System.out.println(String.format("Solution 3: %s",
        String.join(", ", Arrays.toString(Solution.twoSumV3(nums, target)))));
    end = Instant.now();
    System.out.println(String.format("Time elapsed: %ds", Duration.between(start, end).toMillis()));

  }
}
