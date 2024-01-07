public class FindPivotIndex {
    public int pivotIndex(int[] nums) {
        int[] sumLeft = new int[nums.length];
        int[] sumRight = new int[nums.length];
        int sumRightLastIndex = sumRight.length - 1;
        sumLeft[0] = 0;
        sumRight[sumRightLastIndex] = 0;
        for (int i = 1; i < nums.length; i++) {
            sumLeft[i] = sumLeft[i - 1] + nums[i - 1];
            sumRight[sumRightLastIndex - i] = sumRight[sumRightLastIndex - i + 1] + nums[sumRightLastIndex - i + 1];
        }
        for (int i = 0; i < nums.length; i++) {
            if (sumLeft[i] == sumRight[i]) return i;
        }
        return -1;
    }
}
