import java.util.Arrays;

public class HeightChecker {
    public int heightChecker(int[] heights) {
        int[] expected = Arrays.stream(heights)
                .sorted()
                .toArray();
        int count = 0;

        for (int i = 0; i < heights.length; i++) {
            if (expected[i] != heights[i]) {
                count++;
            }
        }

        return count;
    }
}
