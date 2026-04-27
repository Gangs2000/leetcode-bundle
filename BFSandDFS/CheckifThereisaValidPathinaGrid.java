import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;
import java.util.function.Function;

public class CheckifThereisaValidPathinaGrid {
    Queue<List<Integer>> queue;
    Set<List<Integer>> visited;

    public CheckifThereisaValidPathinaGrid() {
        queue = new LinkedList<>();
        visited = new HashSet<>();
    }

    public boolean hasValidPath(int[][] grid) {
        // Initial position
        queue.add(Arrays.asList(0, 0));
        visited.add(Arrays.asList(0, 0));
        while (!queue.isEmpty()) {
            List<Integer> position = queue.poll();
            int i = position.get(0), j = position.get(1);
            if (i == grid.length - 1 && j == grid[i].length - 1)
                return true;
            if (i >= 0 && i <= grid.length - 1 && j >= 0 && j <= grid[i].length - 1) {
                int direction = grid[i][j];
                switch (direction) {
                    // Left and right allowed
                    case 1: {
                        this.isValidDirection(i, j - 1, grid, Arrays.asList(1, 4, 6));
                        this.isValidDirection(i, j + 1, grid, Arrays.asList(1, 3, 5));
                    }
                        break;
                    // Top and botton allowed
                    case 2: {
                        this.isValidDirection(i - 1, j, grid, Arrays.asList(2, 3, 4));
                        this.isValidDirection(i + 1, j, grid, Arrays.asList(2, 5, 6));
                    }
                        break;
                    // Bottom and left allowed
                    case 3: {
                        this.isValidDirection(i + 1, j, grid, Arrays.asList(2, 5, 6));
                        this.isValidDirection(i, j - 1, grid, Arrays.asList(1, 4, 6));
                    }
                        break;
                    // Bottom and right allowed
                    case 4: {
                        this.isValidDirection(i + 1, j, grid, Arrays.asList(2, 5, 6));
                        this.isValidDirection(i, j + 1, grid, Arrays.asList(1, 3, 5));
                    }
                        break;
                    // Top and left allowed
                    case 5: {
                        this.isValidDirection(i - 1, j, grid, Arrays.asList(2, 3, 4));
                        this.isValidDirection(i, j - 1, grid, Arrays.asList(1, 4, 6));
                    }
                        break;
                    // Top and right and allowed
                    case 6: {
                        this.isValidDirection(i - 1, j, grid, Arrays.asList(2, 3, 4));
                        this.isValidDirection(i, j + 1, grid, Arrays.asList(1, 3, 5));
                    }
                        break;
                }
            }
        }
        return false;
    }

    private void isValidDirection(int i, int j, int[][] grid, List<Integer> allowedDirections) {
        if (i >= 0 && i <= grid.length - 1 && j >= 0 && j <= grid[i].length - 1
                && !visited.contains(Arrays.asList(i, j))) {
            int currentDirection = grid[i][j];
            if (allowedDirections.contains(currentDirection)) {
                queue.add(Arrays.asList(i, j));
                visited.add(Arrays.asList(i, j));
            }
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
            Function<int[][], Boolean> function = new CheckifThereisaValidPathinaGrid()::hasValidPath;
            System.out.println(function.apply(grid));
            sc.close();
        } catch (Exception e) {
            System.out.println("Exception occurred : " + e.getMessage());
            e.printStackTrace();
        }
    }
}
