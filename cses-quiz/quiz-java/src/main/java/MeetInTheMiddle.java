import java.util.*;
import java.util.stream.LongStream;

public class MeetInTheMiddle {

    static long count = 0;
    static Deque<Long> stack = new ArrayDeque<>();
    static Map<Integer, Long> cache = new HashMap<>();

    static void log(long[] arr, int i, long sum, long rest) {
        System.out.println(
            i +
//                " " + Arrays.toString(Arrays.copyOfRange(arr, 0, i))
                " " + stack
                + " " + sum
                + " " + rest
                + " " + Arrays.toString(Arrays.copyOfRange(arr, i, arr.length)));
    }

    static void meetInTheMiddle(long[] arr, int i, long sum, long rest) {
        log(arr, i, sum, rest);
        try {
            if (sum == rest) {
                System.out.println(stack + "-----------------");
                count++;
                return;
            }
            if (sum > rest) {
                return;
            }
            if (i == arr.length) {
                return;
            }

            for (int j = arr.length; i < j; i++) {
                long nextSum = sum - arr[i];
                stack.push(arr[i]);
                if (nextSum == 0) {
                    System.out.println(stack + "-----------------");
                    count++;
                    stack.pop();
                    continue;
                }
                if (nextSum < 0) {
                    return;
                }
                meetInTheMiddle(arr, i + 1, nextSum, rest - arr[i]);
            }
        } finally {
            stack.pop();
        }
    }

    static void meetInTheMiddle1(long[] arr, int h, long sum, long rest) {
        log(arr, h, sum, rest);
        if (sum > rest) return;

        if (sum == 0) {
            count++;
            System.out.println("sum == 0 ----------");
            return;
        }

        if (sum == rest) {
            count++;
            System.out.println("sum == rest ----------");
            return;
        }
        if (arr.length == h) return;

        for (int i = h, j = arr.length; i < j; i++) {
            final long el = arr[i];
            if (el > sum) return;
            long nextSum = sum - el;
            long nextRest = rest - el;
            if (nextSum > nextRest) return;

            stack.add(el);
            meetInTheMiddle1(arr, i + 1, nextSum, nextRest);
            stack.removeLast();
        }
    }

    public static void main(String[] args) {
//        final long[] arr = {16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16};final long sum = 640;
//        final long[] arr = {1, 2, 3, 4};
//        final long[] arr = {1,1, 2, 3, 4};
//        final long[] arr = {1, 2, 2, 3, 4};
//        final long[] arr = {1, 2, 3, 3, 4};
//        final long[] arr = {1, 2, 3, 4, 4};
        final long[] arr = {1, 1, 1, 2, 3, 4};
//        final long[] arr = {1, 1, 2, 2, 3, 3, 4, 4};
//        final long sum = 16;
//        final long[] arr = {1, 2, 3, 2};        final long sum = 5;
//        final long[] arr = {1, 2, 3, 2};
//        final long sum = 5;
//        final long[] arr = LongStream.range(0, 10).map(v -> 1).toArray();
        final long sum = 5;
        final long rest = LongStream.of(arr).sum();
        callAlgo(arr, sum);
    }

    static void callAlgo(long[] arr, long sum) {
        Arrays.sort(arr);
        final long rest = LongStream.of(arr).sum();
        meetInTheMiddle1(arr, 0, sum, rest);
        System.out.print(count);
    }

    public static void _main(String[] args) {
        Scanner input = new Scanner(System.in);
        String line1 = input.nextLine();
        long sum = Long.parseLong(line1.split("\\s")[1]);
        String line2 = input.nextLine();
        long[] arr = Arrays.stream(line2.split("\\s")).mapToLong(Long::parseLong).toArray();
        callAlgo(arr, sum);
    }
}
