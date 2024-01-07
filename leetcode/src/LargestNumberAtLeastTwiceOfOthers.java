public class LargestNumberAtLeastTwiceOfOthers {
    public int dominantIndex(int[] nums) {
        int max = nums[0];
        int indexOfMax = 0;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > max) {
                max = nums[i];
                indexOfMax = i;
            }
        }

        for (int i = 0; i < nums.length; i++) {
            if (i == indexOfMax) continue;
            if (nums[i] * 2 > max) return -1;
        }

        return indexOfMax;
    }
}
