import java.util.Scanner;
import java.util.function.Function;

public class EqualSumGridPartitionI {
    long totalSum = 0;

    public boolean canPartitionGrid(int[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++)
                totalSum += grid[i][j];
        }
        return this.isEquallyPartitionedByRow(grid, totalSum) || this.isEquallyPartitionedByColumn(grid, totalSum);
    }

    private boolean isEquallyPartitionedByRow(int[][] grid, long totalSum) {
        long rowCumulativeSum = 0;
        for (int i = 0; i < grid.length - 1; i++) {
            for (int j = 0; j < grid[i].length; j++)
                rowCumulativeSum += grid[i][j];
            if (rowCumulativeSum == (totalSum - rowCumulativeSum))
                return true;
        }
        return false;
    }

    private boolean isEquallyPartitionedByColumn(int[][] grid, long totalSum) {
        long columnCumulativeSum = 0;
        for (int j = 0; j < grid[0].length - 1; j++) {
            for (int i = 0; i < grid.length; i++)
                columnCumulativeSum += grid[i][j];
            if (columnCumulativeSum == (totalSum - columnCumulativeSum))
                return true;
        }
        return false;
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
            Function<int[][], Boolean> function = new EqualSumGridPartitionI()::canPartitionGrid;
            System.out.println(function.apply(grid));
            sc.close();
        } catch (Exception e) {
            System.out.println("Exception occurred : " + e.getMessage());
            e.printStackTrace();
        }
    }
}
