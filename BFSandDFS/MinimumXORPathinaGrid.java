import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;
import java.util.function.Function;

public class MinimumXORPathinaGrid {
    Queue<List<Integer>> queue;

    public MinimumXORPathinaGrid() {
        queue = new LinkedList<>();
    }

    public int minCost(int[][] grid) {
        queue.add(Arrays.asList(0, 0, grid[0][0]));
        int minCost = Integer.MAX_VALUE;
        while (!queue.isEmpty()) {
            List<Integer> peekList = queue.poll();
            int row = peekList.get(0), column = peekList.get(1), currentXOR = peekList.get(2);
            if (row == grid.length - 1 && column == grid[0].length - 1)
                minCost = Math.min(currentXOR, minCost);
            // Right
            this.checkNeighBourCells(row, column + 1, currentXOR, grid);
            // Down
            this.checkNeighBourCells(row + 1, column, currentXOR, grid);
        }
        return minCost;
    }

    private void checkNeighBourCells(int i, int j, int xor, int[][] grid) {
        if (i >= 0 && j >= 0 && i <= grid.length - 1 && j <= grid[i].length - 1) {
            int nextCellVal = grid[i][j];
            queue.add(Arrays.asList(i, j, xor | nextCellVal));
        }
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
            Function<int[][], Integer> function = new MinimumXORPathinaGrid()::minCost;
            System.out.println(function.apply(grid));
            sc.close();
        } catch (Exception e) {
            System.out.println("Exception occurred : " + e.getMessage());
            e.printStackTrace();
        }
    }
}
