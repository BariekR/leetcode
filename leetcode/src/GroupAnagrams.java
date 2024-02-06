import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class GroupAnagrams {
    public static List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<>();
        int[][] strsAnChars = new int[strs.length][26];
        HashMap<int[], Integer> groups = new HashMap<>();
        int group = 0;

        for (int i = 0; i < strs.length; i++) {
            int[] anChars = new int[26];
            for (int j = 0; j < strs[i].length(); j++) {
                char letter = strs[i].charAt(j);
                anChars[letter - 97]++;
            }
            strsAnChars[i] = anChars;

            if (i != 0) {
                for (int j = 0; j < i; j++) {
                    if (Arrays.equals(anChars, strsAnChars[j])) {
                        res.get(groups.get(strsAnChars[j])).add(strs[i]);
                        break;
                    }
                    if (j == i - 1) {
                        List<String> newGroup = new ArrayList<>();
                        newGroup.add(strs[i]);
                        res.add(newGroup);
                        groups.put(anChars, ++group);
                    }
                }
            } else {
                List<String> firstGroup = new ArrayList<>();
                firstGroup.add(strs[i]);
                res.add(firstGroup);
                groups.put(anChars, group);
            }
        }

        return res;
    }
}

