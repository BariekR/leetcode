public class ReverseWordsInAStringIII {
    public String reverseWords(String s) {
        StringBuilder sb = new StringBuilder();
        StringBuilder word = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c != ' ') {
                word.insert(0, c);
            } else {
                if (word.isEmpty()) continue;
                sb.append(word);
                sb.append(' ');
                word.delete(0, word.length());
            }
        }

        if (!word.isEmpty()) {
            sb.append(word);
        } else {
            sb.delete(sb.length() - 1, sb.length());
        }

        return sb.toString();
    }
}
