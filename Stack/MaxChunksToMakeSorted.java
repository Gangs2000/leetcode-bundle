import java.util.Scanner;
import java.util.function.Function;

public class MaxChunksToMakeSorted {
    int chunksCount = 0, sortedCumSum = 0, originalCumSum = 0;

    public int maxChunksToSorted(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            sortedCumSum += i;
            originalCumSum += arr[i];
            if (sortedCumSum == originalCumSum)
                chunksCount++;
        }
        return chunksCount;
    }

    public static void main(String[] args) {
        Scanner sc;
        int[] arr;
        try {
            sc = new Scanner(System.in);
            System.out.println("Enter length of an array : ");
            int length = sc.nextInt();
            arr = new int[length];
            for (int i = 0; i < length; i++)
                arr[i] = sc.nextInt();
            Function<int[], Integer> function = (input) -> new MaxChunksToMakeSorted().maxChunksToSorted(input);
            System.out.println(function.apply(arr));
            sc.close();
        } catch (Exception e) {
            System.out.println("Exception occurred : " + e.getMessage());
            e.printStackTrace();
        }
    }
}
