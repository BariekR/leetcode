public class KthSymbolInGrammar {
    public int kthGrammar(int n, int k) {
        if (n == 1) {
            return 0;
        }

        boolean first = k % 2 != 0;
        int previous = kthGrammar(n - 1, first ? k/2 + 1 : k/2);

        if (previous == 0 && first) {
            return 0;
        } else if (previous == 0) {
            return 1;
        } else if (previous == 1 && first) {
            return 1;
        } else {
            return 0;
        }
    }
}
