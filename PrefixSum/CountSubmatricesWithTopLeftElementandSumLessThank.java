import java.util.Scanner;
import java.util.function.BiFunction;

public class CountSubmatricesWithTopLeftElementandSumLessThank {
    int totalSubMatricesCount = 0;

    public int countSubmatrices(int[][] grid, int k) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                // Left
                int left = this.directions(i, j - 1, grid);
                // Top
                int top = this.directions(i - 1, j, grid);
                // Diagonal
                int diagonal = this.directions(i - 1, j - 1, grid);
                grid[i][j] = grid[i][j] + left + top - diagonal;
                if (grid[i][j] <= k)
                    totalSubMatricesCount++;
            }
        }
        return totalSubMatricesCount;
    }

    private int directions(int i, int j, int[][] grid) {
        if (i >= 0 && i <= grid.length - 1 && j >= 0 && j <= grid[i].length - 1)
            return grid[i][j];
        return 0;
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
            BiFunction<int[][], Integer, Integer> biFunction = (input1,
                    input2) -> new CountSubmatricesWithTopLeftElementandSumLessThank().countSubmatrices(input1, input2);
            System.out.println(biFunction.apply(grid, k));
            sc.close();
        } catch (Exception e) {
            System.out.println("Exception occurred : " + e.getMessage());
            e.printStackTrace();
        }
    }
}
