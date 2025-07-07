import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.function.Function;

public class FindLuckyIntegerinanArray {
    Map<Integer, Integer> freqCount;
    int maxFreqCount = Integer.MIN_VALUE;

    public FindLuckyIntegerinanArray() {
        freqCount = new HashMap<>();
    }

    public int findLucky(int[] arr) {
        for (int number : arr) {
            freqCount.putIfAbsent(number, 0);
            freqCount.put(number, freqCount.get(number) + 1);
        }
        for (Map.Entry<Integer, Integer> entry : freqCount.entrySet()) {
            int count = entry.getValue();
            if (freqCount.containsKey(count) && freqCount.get(count) == count)
                maxFreqCount = Math.max(maxFreqCount, count);
        }
        return maxFreqCount == Integer.MIN_VALUE ? -1 : maxFreqCount;
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
            Function<int[], Integer> function = (input) -> new FindLuckyIntegerinanArray().findLucky(input);
            System.out.println(function.apply(arr));
            sc.close();
        } catch (Exception e) {
            System.out.println("Exception occurred : " + e.getMessage());
            e.printStackTrace();
        }
    }
}
