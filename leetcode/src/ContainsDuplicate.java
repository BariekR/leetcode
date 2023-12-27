import java.util.Arrays;

public class ContainsDuplicate {
    public boolean containsDuplicate(int[] nums) {
        return Arrays.stream(nums).distinct().toArray().length != nums.length;
    }
}
