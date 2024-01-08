import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class PlusOne {
    public int[] plusOne(int[] digits) {
        List<Integer> result = new ArrayList<>();
        boolean addFromPrevious = true;

        for (int i = digits.length - 1; i >= 0; i--) {
            if (i == 0 && addFromPrevious) {
                if (digits[i] + 1 == 10) {
                    result.add(0, 0);
                    result.add(0, 1);
                } else {
                    result.add(0, digits[i] + 1);
                }
                break;
            }

            if (addFromPrevious) {
                if (digits[i] + 1 == 10) {
                    result.add(0,0);
                } else {
                    result.add(0, digits[i] + 1);
                    addFromPrevious = false;
                }
            } else {
                result.add(0, digits[i]);
            }
        }

        return result.stream().mapToInt(x -> x).toArray();
    }
}
