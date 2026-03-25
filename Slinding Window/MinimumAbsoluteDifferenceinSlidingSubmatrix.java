import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;
import java.util.function.BiFunction;

public class MinimumAbsoluteDifferenceinSlidingSubmatrix {
    List<Integer> list;

    public MinimumAbsoluteDifferenceinSlidingSubmatrix() {
        list = new LinkedList<>();
    }

    public int[][] minAbsDiff(int[][] grid, int k) {
        int[][] resultArr = new int[grid.length - k + 1][grid[0].length - k + 1];
        if (k != 1) {
            for (int i = 0; i <= grid.length - k; i++) {
                for (int j = 0; j <= grid[i].length - k; j++) {
                    // Only column 0 we need to take whole subMatrix
                    if (j == 0) {
                        for (int m = i; m < i + k; m++) {
                            for (int n = j; n < j + k; n++)
                                list.add(grid[m][n]);
                        }
                    } else {
                        // Remove previous column
                        for (int remove = i; remove < i + k; remove++)
                            list.remove(Integer.valueOf(grid[remove][j - 1]));
                        // Add next column
                        for (int add = i; add < i + k; add++)
                            list.add(grid[add][j + k - 1]);
                    }
                    int minAbsDiff = this.minAbsDifference(list);
                    resultArr[i][j] = minAbsDiff;
                }
                list.clear();
            }
        }
        return resultArr;
    }

    private int minAbsDifference(List<Integer> list) {
        boolean seenFirstElement = false;
        int prevValue = 0, minAbsDiff = Integer.MAX_VALUE;
        Set<Integer> set = new TreeSet<>(list);
        for (Integer element : set) {
            if (!seenFirstElement) {
                seenFirstElement = true;
                prevValue = element;
                continue;
            }
            minAbsDiff = Math.min(minAbsDiff, Math.abs(prevValue - element));
            prevValue = element;
        }
        return minAbsDiff == Integer.MAX_VALUE ? 0 : minAbsDiff;
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
                for (int j = 0; j < n; j++) {
                    grid[i][j] = sc.nextInt();
                }
            }
            System.out.println("Enter K value : ");
            int k = sc.nextInt();
            BiFunction<int[][], Integer, int[][]> biFunction = (input1,
                    input2) -> new MinimumAbsoluteDifferenceinSlidingSubmatrix()
                            .minAbsDiff(input1, k);
            System.out.println(biFunction.apply(grid, k));
            sc.close();
        } catch (Exception e) {
            System.out.println("Exception occurred : " + e.getMessage());
            e.printStackTrace();
        }
    }
}
