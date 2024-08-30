import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;

public class CountSubIslands {

    public int countSubIslands(int[][] grid1, int[][] grid2) {
        BiFunction<int[][], int[][], Integer> biFunction = (arr1, arr2) -> this.scanGrid2(arr1, arr2);
        return biFunction.apply(grid1, grid2);
    }

    private int scanGrid2(int[][] grid1, int[][] grid2) {
        int noOfSubIslandsCount = 0;
        for (int i = 0; i < grid2.length; i++) {
            for (int j = 0; j < grid2[i].length; j++) {
                if (grid1[i][j] == 1 && grid2[i][j] == 1) {
                    grid2[i][j] = 0;
                    noOfSubIslandsCount = (this.breathFirstSearch(i, j, grid1, grid2)) ? (noOfSubIslandsCount + 1)
                            : (noOfSubIslandsCount);
                }
            }
        }
        return noOfSubIslandsCount;
    }

    private boolean breathFirstSearch(int i, int j, int[][] grid1, int[][] grid2) {
        boolean isSubIsland = true;
        Queue<List<Integer>> queue = new LinkedList<>();
        queue.add(Arrays.asList(i, j));
        while (!queue.isEmpty()) {
            List<Integer> list = queue.poll();
            int row = list.get(0), column = list.get(1);
            // Left
            if (!this.checkBoundariesAndLand(row, column - 1, grid1, grid2, queue))
                isSubIsland = false;
            // Right
            if (!this.checkBoundariesAndLand(row, column + 1, grid1, grid2, queue))
                isSubIsland = false;
            // Top
            if (!this.checkBoundariesAndLand(row - 1, column, grid1, grid2, queue))
                isSubIsland = false;
            // Bottom
            if (!this.checkBoundariesAndLand(row + 1, column, grid1, grid2, queue))
                isSubIsland = false;
        }
        return isSubIsland;
    }

    private boolean checkBoundariesAndLand(int i, int j, int[][] grid1, int[][] grid2, Queue<List<Integer>> queue) {
        boolean areNeighboursIsland = true;
        if (i >= 0 && j >= 0 && i <= grid2.length - 1 && j <= grid2[i].length - 1 && grid2[i][j] == 1) {
            if (grid1[i][j] != 1)
                areNeighboursIsland = false;
            queue.add(Arrays.asList(i, j));
            grid2[i][j] = 0;
        }
        return areNeighboursIsland;
    }

    public static void main(String[] args) {
        Scanner sc;
        int[][] grid1, grid2;
        try {
            sc = new Scanner(System.in);
            System.out.println("Enter M and N values : ");
            int m = sc.nextInt(), n = sc.nextInt();
            grid1 = new int[m][n];
            grid2 = new int[m][n];
            BiConsumer<int[][], Scanner> biConsumer = (grid, scanner) -> prepareGrid(grid, scanner);
            biConsumer.accept(grid1, sc);
            biConsumer.accept(grid2, sc);
            BiFunction<int[][], int[][], Integer> biFunction = (arr1, arr2) -> new CountSubIslands()
                    .countSubIslands(arr1, arr2);
            System.out.println(biFunction.apply(grid1, grid2));
            sc.close();
        } catch (Exception e) {
            System.out.println("Exception occurred : " + e.getMessage());
            e.printStackTrace();
        }
    }

    private static void prepareGrid(int[][] grid, Scanner sc) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++)
                grid[i][j] = sc.nextInt();
        }
    }
}
