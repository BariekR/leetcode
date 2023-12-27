public class PowXN {
    public double myPow(double x, int n) {
        if (n < 0) {
            return 1.0 / myPowHelper(x, Math.abs(n));
        }
        return myPowHelper(x, n);
    }

    public double myPowHelper(double x, int n) {
        if (n == 0) {
            return 1;
        }
        if (n == 1) {
            return x;
        }
        if (n % 2 == 0) {
            return myPowHelper(x * x, n/2);
        }
        return x * myPowHelper(x * x, n/2);
    }
}
