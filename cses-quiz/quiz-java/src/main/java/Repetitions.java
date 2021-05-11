import java.util.Scanner;

public class Repetitions {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String dna = input.nextLine();

        final char[] chars = dna.toCharArray();

        int max = 1, len = 1;
        for (int i = 0, j = chars.length - 1; i < j; i++) {
            char c = chars[i];
            char c1 = chars[i + 1];
            if (c == c1) {
                len++;
            } else {
                max = Math.max(max, len);
                len = 1;
            }
        }
        System.out.print(Math.max(max, len));
    }
}
