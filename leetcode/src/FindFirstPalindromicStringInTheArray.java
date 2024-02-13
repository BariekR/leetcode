public class FindFirstPalindromicStringInTheArray {
    public String firstPalindrome(String[] words) {
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            if(word.equals(new StringBuilder(word).reverse().toString())) {
                return word;
            }
        }

        return "";
    }
}
