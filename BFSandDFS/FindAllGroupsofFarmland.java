import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;
import java.util.function.Function;

public class FindAllGroupsofFarmland {
    List<List<Integer>> plots;
    Queue<List<Integer>> queue;

    public FindAllGroupsofFarmland() {
        plots = new LinkedList<>();
        queue = new LinkedList<>();
    }

    public int[][] findFarmland(int[][] land) {
        Function<int[][], int[][]> function = (arr) -> this.scanGrid(arr);
        return function.apply(land);
    }

    private int[][] scanGrid(int[][] land) {

        for (int i = 0; i < land.length; i++) {
            for (int j = 0; j < land[i].length; j++) {
                if (land[i][j] == 1) {
                    land[i][j] = 0;
                    List<Integer> coordinates = new LinkedList<>();
                    coordinates.add(i);
                    coordinates.add(j);
                    this.breathFirstSearch(i, j, land, coordinates);
                    plots.add(coordinates);
                }
            }
        }
        return this.covertListIntoIntArray(plots);
    }

    private int[][] covertListIntoIntArray(List<List<Integer>> plots) {
        int[][] result = new int[plots.size()][4];
        int index = 0;
        for (List<Integer> list : plots) {
            result[index][0] = list.get(0);
            result[index][1] = list.get(1);
            result[index][2] = list.get(2);
            result[index][3] = list.get(3);
            index++;
        }
        return result;
    }

    private void breathFirstSearch(int i, int j, int[][] land, List<Integer> coordinates) {
        queue.clear();
        queue.add(Arrays.asList(i, j));
        while (!queue.isEmpty()) {
            List<Integer> list = queue.poll();
            int row = list.get(0), column = list.get(1);
            // Left
            this.checkBoundariesAndFarmLand(row, column - 1, land, queue);
            // Right
            this.checkBoundariesAndFarmLand(row, column + 1, land, queue);
            // Top
            this.checkBoundariesAndFarmLand(row - 1, column, land, queue);
            // Bottom
            this.checkBoundariesAndFarmLand(row + 1, column, land, queue);
            // Add bottom right coordinates if queue is empty after all neighbours visited
            if (queue.isEmpty()) {
                coordinates.add(row);
                coordinates.add(column);
            }
        }
    }

    private void checkBoundariesAndFarmLand(int i, int j, int[][] grid, Queue<List<Integer>> queue) {
        if (i >= 0 && j >= 0 && i <= grid.length - 1 && j <= grid[i].length - 1 && grid[i][j] == 1) {
            grid[i][j] = 0;
            queue.add(Arrays.asList(i, j));
        }
    }

    public static void main(String[] args) {
        Scanner sc;
        int[][] grid;
        try {
            sc = new Scanner(System.in);
            System.out.println("Enter grid M and N values : ");
            int m = sc.nextInt(), n = sc.nextInt();
            grid = new int[m][n];
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    grid[i][j] = sc.nextInt();
                }
            }
            Function<int[][], int[][]> function = (arr) -> new FindAllGroupsofFarmland().findFarmland(arr);
            System.out.println(function.apply(grid));
            sc.close();
        } catch (Exception e) {
            System.out.println("Exception occurred : " + e.getMessage());
            e.printStackTrace();
        }
    }
}
