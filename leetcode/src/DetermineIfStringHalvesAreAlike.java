import java.util.ArrayList;
import java.util.List;

public class DetermineIfStringHalvesAreAlike {
    public boolean halvesAreAlike(String s) {
        List<Character> vowels = new ArrayList<>(List.of('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'));
        String firstHalf = s.substring(0, s.length() / 2);
        String secondHalf = s.substring(s.length() / 2);

        long firstHalfVowelsCount = firstHalf.chars()
                .filter(c -> vowels.contains((char)c))
                .count();

        long secondHalfVowelsCount = secondHalf.chars()
                .filter(c -> vowels.contains((char)c))
                .count();

        return firstHalfVowelsCount == secondHalfVowelsCount;
    }
}
