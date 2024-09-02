import java.util.Scanner;
import java.util.function.BiFunction;
import java.util.function.Consumer;

public class FindtheStudentthatWillReplacetheChalk {
    private long totalSum = 0L;

    public int chalkReplacer(int[] chalk, int k) {
        Consumer<int[]> consumer = (arr) -> this.prefixSumOfChalk(arr);
        consumer.accept(chalk);
        BiFunction<int[], Integer, Integer> biFunction = (arr, kRemaining) -> this.returnReplaceValue(arr,
                kRemaining);
        return (k > totalSum) ? (biFunction.apply(chalk, (int) (k % totalSum))) : (biFunction.apply(chalk, k));
    }

    private void prefixSumOfChalk(int[] chalks) {
        for (int chalk : chalks)
            totalSum += chalk;
    }

    private int returnReplaceValue(int[] chalk, int k) {
        for (int i = 0; i < chalk.length; i++) {
            k -= chalk[i];
            if (k < 0)
                return i;
        }
        return 0;
    }

    public static void main(String[] args) {
        Scanner sc;
        int[] chalks;
        try {
            sc = new Scanner(System.in);
            System.out.println("Enter length of chalks array : ");
            int length = sc.nextInt();
            chalks = new int[length];
            for (int i = 0; i < chalks.length; i++)
                chalks[i] = sc.nextInt();
            System.out.println("Enter K value : ");
            int k = sc.nextInt();
            BiFunction<int[], Integer, Integer> biFunction = (arr,
                    kValue) -> new FindtheStudentthatWillReplacetheChalk().chalkReplacer(arr, kValue);
            System.out.println(biFunction.apply(chalks, k));
            sc.close();
        } catch (Exception e) {
            System.out.println("Exception occurred : " + e.getMessage());
            e.printStackTrace();
        }
    }
}
