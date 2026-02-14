import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;

public class MinimumAbsoluteDifference {
    int minDifference = Integer.MAX_VALUE;
    List<List<Integer>> resutList;

    public MinimumAbsoluteDifference() {
        resutList = new LinkedList<>();
    }

    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        // Sort elements in ascending order..
        Arrays.sort(arr);
        for (int i = 0; i < arr.length - 1; i++) {
            int absDiff = Math.abs(arr[i] - arr[i + 1]);
            if (absDiff < minDifference) {
                minDifference = Math.min(absDiff, minDifference);
                // Reset the list
                resutList.clear();
            }
            if (absDiff == minDifference)
                resutList.add(Arrays.asList(arr[i], arr[i + 1]));
        }
        return resutList;
    }

    public static void main(String[] args) {
        Scanner sc;
        int[] arr;
        try {
            sc = new Scanner(System.in);
            System.out.println("Enter length of array elements :");
            int length = sc.nextInt();
            arr = new int[length];
            Function<int[], List<List<Integer>>> function = (input) -> new MinimumAbsoluteDifference()
                    .minimumAbsDifference(input);
            for (int i = 0; i < length; i++)
                arr[i] = sc.nextInt();
            System.out.println(function.apply(arr));
            sc.close();
        } catch (Exception e) {
            System.out.println("Exception occurred : " + e.getMessage());
            e.printStackTrace();
        }
    }
}
