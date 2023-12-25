import java.util.HashMap;

public class ClimbingStairs {
    HashMap<Integer, Integer> cache = new HashMap<Integer, Integer>();

    public int climbStairs(int n) {
        if (cache.containsKey(n)) {
            return cache.get(n);
        }

        if (n == 0) {
            return 1;
        }

        int number = 0;
        number += climbStairs(n - 1);
        if (n - 2 >= 0) {
            number += climbStairs(n - 2);
        }

        cache.put(n, number);
        return number;
    }
}
