import java.util.Arrays;

public class SquaresOfASortedArray {
    public int[] sortedSquares(int[] nums) {
        return Arrays.stream(nums).map(x -> x * x).sorted().toArray();
    }
}
