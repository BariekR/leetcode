public class RearrangeArrayElementsBySign {
    public int[] rearrangeArray(int[] nums) {
        int[] pos = new int[nums.length / 2];
        int[] neg = new int[nums.length / 2];

        for (int i = 0, j = 0, k = 0; i < nums.length; i++) {
            int current = nums[i];
            if (current > 0) {
                pos[j++] = current;
            } else {
                neg[k++] = current;
            }
        }

        for (int i = 0, j = 0; i < nums.length / 2; i++) {
            nums[j++] = pos[i];
            nums[j++] = neg[i];
        }

        return nums;
    }
}
