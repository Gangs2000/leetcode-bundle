package MemoiDPAndBackTracking;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.BiFunction;

public class MaximumPathScoreinaGrid {
    public int maxPathScore(int[][] grid, int k) {
        int[][][] memo = new int[grid.length][grid[0].length][k + 1];
        Arrays.stream(memo).forEach(arr -> {
            Arrays.stream(arr).forEach(nested -> {
                Arrays.fill(nested, -2);
            });
        });
        return this.findMaxPathScore(0, 0, grid, k, 0, memo);
    }

    private int findMaxPathScore(int i, int j, int[][] grid, int k, int score, int[][][] memo) {
        if (i >= grid.length || j >= grid[0].length || score > k)
            return -1;
        if (i == grid.length - 1 && j == grid[0].length - 1)
            return grid[i][j] == 0 ? 0 : 1;
        if (memo[i][j][score] != -2)
            return memo[i][j][score];
        int cost = grid[i][j] == 2 ? 1 : grid[i][j];
        int left = this.findMaxPathScore(i, j + 1, grid, k, score + cost, memo);
        int bottom = this.findMaxPathScore(i + 1, j, grid, k, score + cost, memo);
        left = left == -1 ? -1 : left + grid[i][j];
        bottom = bottom == -1 ? -1 : bottom + grid[i][j];
        return memo[i][j][cost] = Math.max(left, bottom);
    }

    public static void main(String[] args) {
        Scanner sc;
        int[][] grid;
        try {
            sc = new Scanner(System.in);
            System.out.println("Enter M and N values of a grid : ");
            int m = sc.nextInt(), n = sc.nextInt();
            grid = new int[m][n];
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++)
                    grid[i][j] = sc.nextInt();
            }
            System.out.println("Enter K value : ");
            int k = sc.nextInt();
            BiFunction<int[][], Integer, Integer> biFunction = new MaximumPathScoreinaGrid()::maxPathScore;
            System.out.println(biFunction.apply(grid, k));
            sc.close();
        } catch (Exception e) {
            System.out.println("Exception occurred : " + e.getMessage());
            e.printStackTrace();
        }
    }
}
