public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        if (strs[0].isEmpty()) {
            return "";
        }

        StringBuilder sb = new StringBuilder();
        int index = 0;

        while (true) {
            if (index == strs[0].length()) {
                return sb.toString();
            }
            char c = strs[0].charAt(index);
            for (int i = 0; i < strs.length; i++) {
                if (index == strs[i].length() || c != strs[i].charAt(index)) {
                    return sb.toString();
                }
            }
            sb.append(c);
            index++;
        }
    }
}
