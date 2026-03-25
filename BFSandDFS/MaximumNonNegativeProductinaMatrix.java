import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;
import java.util.function.Function;

public class MaximumNonNegativeProductinaMatrix {
    Queue<List<Integer>> queue;
    int maxNonNegativeProduct = Integer.MIN_VALUE;

    public MaximumNonNegativeProductinaMatrix() {
        queue = new LinkedList<>();
    }

    public int maxProductPath(int[][] grid) {
        // Load initial queue with 0,0 and grid[0][0] value
        queue.add(Arrays.asList(0, 0, grid[0][0]));
        double mod = Math.pow(10, 9) + 7.0;
        while (!queue.isEmpty()) {
            List<Integer> list = queue.poll();
            int row = list.get(0), column = list.get(1), currentProduct = list.get(2);
            if (row == grid.length - 1 && column == grid[row].length - 1)
                maxNonNegativeProduct = Math.max(maxNonNegativeProduct, currentProduct);
            // Check right side grid
            this.addToQueue(row, column + 1, currentProduct, grid);
            // Check down side grid
            this.addToQueue(row + 1, column, currentProduct, grid);
        }
        return maxNonNegativeProduct < 0 ? -1 : maxNonNegativeProduct % ((int) mod);
    }

    private void addToQueue(int row, int column, int product, int[][] grid) {
        if (row >= 0 && column >= 0 && row <= grid.length - 1 && column <= grid[row].length - 1)
            queue.add(Arrays.asList(row, column, product * grid[row][column]));
    }

    public static void main(String[] args) {
        Scanner sc;
        int[][] grid;
        try {
            sc = new Scanner(System.in);
            System.out.println("Enter M and N values : ");
            int m = sc.nextInt(), n = sc.nextInt();
            grid = new int[m][n];
            Function<int[][], Integer> function = new MaximumNonNegativeProductinaMatrix()::maxProductPath;
            System.out.println(function.apply(grid));
            sc.close();
        } catch (Exception e) {
            System.out.println("Exception occurred : " + e.getMessage());
            e.printStackTrace();
        }
    }
}
