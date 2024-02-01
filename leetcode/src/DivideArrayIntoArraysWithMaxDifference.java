import java.util.Arrays;

public class DivideArrayIntoArraysWithMaxDifference {
    public int[][] divideArray(int[] nums, int k) {
        int[][] res = new int[nums.length/3][3];
        Arrays.sort(nums);

        int index = 0;
        for (int i = 0; i < res.length; i++) {
            for (int j = 0; j < 3; j++) {
                int number = nums[index];
                res[i][j] = number;
                if (j == 1 && Math.abs(number - res[i][0]) > k) {
                    return new int[0][0];
                }
                if (j == 2 && (Math.abs(number - res[i][0]) > k
                        || Math.abs(number - res[i][1]) > k)) {
                    return new int[0][0];
                }
                index++;
            }
        }
        return res;
    }
}
