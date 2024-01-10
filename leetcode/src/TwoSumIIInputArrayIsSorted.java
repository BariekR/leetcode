public class TwoSumIIInputArrayIsSorted {
    public int[] twoSum(int[] numbers, int target) {
        int i = 0;
        int j = numbers.length - 1;
        while (true) {
            int left = numbers[i];
            int right = numbers[j];
            if (left + right == target) {
                return new int[]{i + 1, j + 1};
            }
            if (target - left < right) {
                j--;
                continue;
            }
            if (target - right > left) {
                i++;
            }
        }
    }
}
