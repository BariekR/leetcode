import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class RotateArray {
    public static void main(String[] args) {

    }
    public void rotate(int[] nums, int k) {
        if (k == 0) {
            return;
        }
        int[] arr = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            int index = (k + i) / nums.length > 0 ? (k + i) % nums.length : (k + i);
            arr[index] = nums[i];
        }
        for (int i = 0; i < nums.length; i++) {
            nums[i] = arr[i];
        }
    }
}
