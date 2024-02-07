import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class SortCharactersByFrequency {
    public String frequencySort(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        List<Character> sortedChars = map.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey)
                .toList();

        for (int i = sortedChars.size() - 1; i >=0 ; i--) {
            char c = sortedChars.get(i);
            sb.repeat(c, map.get(c));
        }

        return sb.toString();
    }
}
