import java.util.Map;
import java.util.TreeMap;
import java.util.function.Function;
import java.util.stream.Collectors;

public class MinimumWindowSubstring {
    public String minWindowOld(String s, String t) {
        TreeMap<Integer, String> results = new TreeMap<>();
        int lMin = Integer.MAX_VALUE;

        for (int i = 0; i < s.length(); i++) {
            Map<Character, Long> tCharOccurrence = t.chars()
                    .mapToObj(x -> (char) x)
                    .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
            StringBuilder result = new StringBuilder();

            for (int j = i; j < s.length(); j++) {
                if (j - i >= lMin) break;
                char currentChar = s.charAt(j);
                result.append(currentChar);
                if (tCharOccurrence.containsKey(currentChar)) {
                    long currentCharValue = tCharOccurrence.get(currentChar);
                    if (currentCharValue == 1L) {
                        tCharOccurrence.remove(currentChar);
                    } else {
                        tCharOccurrence.put(currentChar, currentCharValue - 1L);
                    }
                }
                if (tCharOccurrence.isEmpty()) {
                    int lRes = result.length();
                    if (lRes < lMin) lMin = lRes;
                    results.put(lRes, result.toString());
                    break;
                }
            }
        }

        if (results.isEmpty()) return "";
        return results.get(results.firstKey());
    }
}
