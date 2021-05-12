public class MiscUtils {
    static long fraction(long n) {
        long product = 1;
        for (long i = product; i <= n; i++) {
            product = product * i;
        }
        return product;
    }

    static long arrangementCnt(long n, long m) {
        return fraction(n) / fraction(n - m);
    }

    static long combinationCnt(long n, long m) {
        return fraction(n) / fraction(m) / fraction(n - m);
    }
}
