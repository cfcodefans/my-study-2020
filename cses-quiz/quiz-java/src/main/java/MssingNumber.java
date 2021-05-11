import java.math.BigInteger;
import java.util.Arrays;
import java.util.Scanner;

public class MssingNumber {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        input.nextLine();

        BigInteger sum = new BigInteger(String.valueOf(n)).multiply(new BigInteger(String.valueOf(n + 1))).divide(new BigInteger(String.valueOf(2)));
        int[] arr = Arrays.stream(input.nextLine().split("\\s")).mapToInt(s -> Integer.parseInt(s)).toArray();

        for (int e : arr) {
            sum = sum.subtract(BigInteger.valueOf((long) e));
        }
        System.out.print(sum);
    }
}
