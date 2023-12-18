import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ThirdMaximumNumber {
    public int thirdMax(int[] nums) {
        List<Integer> sortedNums = IntStream.of(nums).distinct().sorted().boxed().collect(Collectors.toList());
        Collections.reverse(sortedNums);
        if (sortedNums.size() > 2) {
            return sortedNums.get(2);
        } else {
            return sortedNums.get(0);
        }
    }
}
