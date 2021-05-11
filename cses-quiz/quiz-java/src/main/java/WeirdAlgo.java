import java.util.Scanner;

public class WeirdAlgo {
    static void weirdAlgo(int n) {
        for (long i = n; i != 1; ) {
            System.out.print(i + " ");
            if (i % 2 == 0) i = i / 2;
            else i = i * 3 + 1;
        }
        System.out.print(1);
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        weirdAlgo(n);
    }
}
