public class FirstUniqueCharacterInAString {
    public int firstUniqChar(String s) {
        for (int i = 0; i < s.length(); i++) {
            if(s.substring(i + 1).indexOf(s.charAt(i)) == -1 &&
                    s.substring(0, i).indexOf(s.charAt(i)) == -1) {
                return i;
            }
        }

        return -1;
    }
}
