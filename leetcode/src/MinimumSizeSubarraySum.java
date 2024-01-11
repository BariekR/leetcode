import java.util.Arrays;
import java.util.stream.IntStream;

public class MinimumSizeSubarraySum {
    public int minSubArrayLen(int target, int[] nums) {
        int window = 0;
        while (window < nums.length) {
            int i = 0;
            int j = window++;

            while (j < nums.length) {
                int sum = 0;
                for (int k = i; k <= j; k++) {
                    sum += nums[k];
                }
                if (sum >= target) {
                    return j - i + 1;
                }
                i++;
                j++;
            }
        }
        return 0;
    }
}
