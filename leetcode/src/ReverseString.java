public class ReverseString {
    public void reverseString(char[] s) {
        reverse(0, s.length - 1, s);
    }

    private void reverse(int start, int end, char[] s) {
        if (start > end) {
            return;
        }
        char temp = s[start];
        s[start] = s[end];
        s[end] = temp;

        reverse(start + 1, end - 1, s);
    }
}
