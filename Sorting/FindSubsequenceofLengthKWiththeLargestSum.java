import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;
import java.util.function.BiFunction;

public class FindSubsequenceofLengthKWiththeLargestSum {
    Queue<List<Integer>> sortByElement, sortByIndex;

    public FindSubsequenceofLengthKWiththeLargestSum() {
        sortByElement = new PriorityQueue<>(new Comparator<List<Integer>>() {
            @Override
            public int compare(List<Integer> o1, List<Integer> o2) {
                return o2.get(1).compareTo(o1.get(1)); // Sort by element in descending order
            }
        });
        sortByIndex = new PriorityQueue<>(new Comparator<List<Integer>>() {
            @Override
            public int compare(List<Integer> o1, List<Integer> o2) {
                return o1.get(0).compareTo(o2.get(0)); // Sorty by index in ascending order
            }
        });
    }

    public int[] maxSubsequence(int[] nums, int k) {
        int[] resultArr = new int[k];
        int counter = 0;
        for (int index = 0; index < nums.length; index++)
            sortByElement.add(Arrays.asList(index, nums[index]));
        while (counter < k) {
            sortByIndex.add(sortByElement.poll());
            counter++;
        }
        int index = 0;
        while (!sortByIndex.isEmpty())
            resultArr[index++] = sortByIndex.poll().get(1);
        return resultArr;
    }

    public static void main(String[] args) {
        Scanner sc;
        int[] nums;
        try {
            sc = new Scanner(System.in);
            System.out.println("Enter lengt of nums array : ");
            int length = sc.nextInt();
            nums = new int[length];
            for (int i = 0; i < length; i++)
                nums[i] = sc.nextInt();
            System.out.println("Enter K value : ");
            int k = sc.nextInt();
            BiFunction<int[], Integer, int[]> biFunction = (input1,
                    input2) -> new FindSubsequenceofLengthKWiththeLargestSum().maxSubsequence(input1, input2);
            System.out.println(biFunction.apply(nums, k));
            sc.close();
        } catch (Exception e) {
            System.out.println("Exception occurred : " + e.getMessage());
            e.printStackTrace();
        }
    }
}
