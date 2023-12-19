import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class FindAllNumbersDisappearedInAnArray {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        Set<Integer> rangeSet = IntStream.rangeClosed(1, nums.length).boxed().collect(Collectors.toSet());
        Set<Integer> numsSet = Arrays.stream(nums).boxed().collect(Collectors.toSet());
        rangeSet.removeAll(numsSet);
        return new ArrayList<>(rangeSet);
    }
}
