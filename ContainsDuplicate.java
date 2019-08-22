import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * ContainsDuplicate
 */
public class ContainsDuplicate {

  public static boolean containsDuplicate(int[] nums) {
    Arrays.sort(nums);
    for (int i = 0; i < nums.length - 1; i++) {
      if (nums[i] == nums[i + 1]) {
        return true;
      }
    }
    return false;
  }

  public static boolean containsDuplicateV2(int[] nums) {
    List<Integer> arr = IntStream.of(nums).boxed().collect(Collectors.toList());
    return new HashSet<>(arr).size() != nums.length;
  }

  public static void main(String[] args) {
    int[] nums = {1, 2, 3, 4};
    System.out.println(String.format("Result: %s", containsDuplicateV2(nums)));
  }
}
