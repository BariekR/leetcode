import java.util.Arrays;

public class PartitionArrayForMaximumSum {
    public int maxSumAfterPartitioning(int[] arr, int k) {
        int[] mem = new int[arr.length];
        Arrays.fill(mem, -1);
        return fun(0, arr, k, mem);
    }

    public static int fun(int index, int[] arr, int k, int[] mem) {
        if (index == arr.length) return 0;
        if (mem[index] != -1) return mem[index];
        int len = 0;
        int max = Integer.MIN_VALUE;
        int maxAns = Integer.MIN_VALUE;

        for (int j = index; j < Math.min(index + k, arr.length); j++) {
            len++;
            max = Math.max(max, arr[j]);
            int sum = len * max + fun(j + 1, arr, k, mem);
            maxAns = Math.max(maxAns, sum);
        }
        mem[index] = maxAns;
        return maxAns;
    }
}
