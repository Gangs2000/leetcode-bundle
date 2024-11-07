import java.util.Scanner;
import java.util.function.Function;

public class MaximumNumberofMovesinaGrid {
    int result = 0;

    public int maxMoves(int[][] grid) {
        for (int i = 0; i < grid.length; i++)
            this.possibleWays(i, 0, 0, grid);
        return result;
    }

    private void possibleWays(int i, int j, int steps, int[][] grid) {
        // Top
        if (i - 1 >= 0 && j + 1 <= grid[i].length - 1 && grid[i][j] < grid[i - 1][j + 1])
            this.possibleWays(i - 1, j + 1, steps + 1, grid);
        // Straight
        if (i <= grid.length - 1 && j + 1 <= grid[i].length - 1 && grid[i][j] < grid[i][j + 1])
            this.possibleWays(i, j + 1, steps + 1, grid);
        // Bottom
        if (i + 1 <= grid.length - 1 && j + 1 <= grid[i].length - 1 && grid[i][j] < grid[i + 1][j + 1])
            this.possibleWays(i + 1, j + 1, steps + 1, grid);
        result = Math.max(result, steps);
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
            Function<int[][], Integer> function = (input) -> new MaximumNumberofMovesinaGrid().maxMoves(input);
            System.out.println(function.apply(grid));
            sc.close();
        } catch (Exception e) {
            System.out.println("Exception occurred : " + e.getMessage());
            e.printStackTrace();
        }
    }
}
