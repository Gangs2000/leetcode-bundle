import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.function.BiFunction;

public class MinimumOperationstoMakeaUniValueGrid {
    Set<Integer> reminders;

    public MinimumOperationstoMakeaUniValueGrid() {
        reminders = new HashSet<>();
    }

    public int minOperations(int[][] grid, int x) {
        int[] flattenArr = new int[grid.length * grid[0].length];
        int index = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                flattenArr[index++] = grid[i][j];
                int reminder = grid[i][j] % x;
                reminders.add(reminder);
                if (reminders.size() > 1)
                    return -1;
            }
        }
        Arrays.sort(flattenArr);
        return this.findMedianAndGetMinOpToMakeAllElementsUnique(flattenArr, x);
    }

    private int findMedianAndGetMinOpToMakeAllElementsUnique(int[] arr, int x) {
        int minOperation = 0;
        int medianIndex = arr.length / 2, medianElement = arr[medianIndex];
        for (int i = 0; i <= medianIndex; i++)
            minOperation += (medianElement - arr[i]) / x;
        for (int i = medianIndex; i < arr.length; i++)
            minOperation += (arr[i] - medianElement) / x;
        return minOperation;
    }

    public static void main(String[] args) {
        Scanner sc;
        int[][] grid;
        try {
            sc = new Scanner(System.in);
            System.out.println("Enter M and N values : ");
            int m = sc.nextInt(), n = sc.nextInt();
            grid = new int[m][n];
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++)
                    grid[i][j] = sc.nextInt();
            }
            System.out.println("Enter X value : ");
            int x = sc.nextInt();
            BiFunction<int[][], Integer, Integer> biFunction = (input1,
                    input2) -> new MinimumOperationstoMakeaUniValueGrid().minOperations(input1, input2);
            System.out.println(biFunction.apply(grid, x));
            sc.close();
        } catch (Exception e) {
            System.out.println("Exception occurred : " + e.getMessage());
            e.printStackTrace();
        }
    }
}
