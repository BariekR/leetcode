import java.util.Arrays;
import java.util.stream.IntStream;

public class MinimumSizeSubarraySum {
    public int minSubArrayLen(int target, int[] nums) {
        int min = nums.length + 1;
        int sum = nums[0];
        int i = 0, j = 0;

        while (true) {
            if (sum < target) {
                if (j == nums.length - 1) {
                    break;
                }
                sum += nums[++j];
            } else {
                if (j - i + 1 < min) {
                    min = j - i + 1;
                }
                sum -= nums[i];
                i++;
            }
            if (i == nums.length && j == nums.length - 1) {
                break;
            }
        }

        return min == nums.length + 1 ? 0 : min;
    }
}
