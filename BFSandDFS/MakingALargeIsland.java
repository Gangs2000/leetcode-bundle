import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;
import java.util.function.Function;

public class MakingALargeIsland {
    Map<List<Integer>, Integer> specificCellBelogsToWhichIsLand;
    Map<Integer, List<List<Integer>>> mapCellToIsland;
    Queue<List<Integer>> queue;
    int isLandCount = 1;

    public MakingALargeIsland() {
        specificCellBelogsToWhichIsLand = new HashMap<>();
        mapCellToIsland = new HashMap<>();
        queue = new LinkedList<>();
    }

    public int largestIsland(int[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                // Scan for Land cell
                if (grid[i][j] == 1) {
                    List<List<Integer>> trackIslandCells = new LinkedList<>();
                    queue.add(Arrays.asList(i, j));
                    // -1 means, the cell is visited
                    grid[i][j] = -1;
                    // Keep track of each cell belongs to which isLand
                    specificCellBelogsToWhichIsLand.put(Arrays.asList(i, j), isLandCount);
                    trackIslandCells.add(Arrays.asList(i, j));
                    this.breathFirstSearch(trackIslandCells, grid);
                    // Keep track of whole area belongs to which isLand
                    mapCellToIsland.put(isLandCount, trackIslandCells);
                    isLandCount++;
                }
            }
        }
        // If means we have got more than 1 isLand, then we have find out largest isLand
        // by combining them
        if (isLandCount >= 2) {
            Function<int[][], Integer> getLargeIsland = (input) -> this.canMakeLargeIsland(input);
            return getLargeIsland.apply(grid);
        }
        return 1;
    }

    private void breathFirstSearch(List<List<Integer>> trackIslandCells, int[][] grid) {
        while (!queue.isEmpty()) {
            List<Integer> currentCell = queue.poll();
            int row = currentCell.get(0), column = currentCell.get(1);
            // Left
            this.checkBoundaries(trackIslandCells, row, column - 1, grid);
            // Right
            this.checkBoundaries(trackIslandCells, row, column + 1, grid);
            // Top
            this.checkBoundaries(trackIslandCells, row - 1, column, grid);
            // Bottom
            this.checkBoundaries(trackIslandCells, row + 1, column, grid);
        }
    }

    private void checkBoundaries(List<List<Integer>> trackIslandCells, int row, int column, int[][] grid) {
        if (row >= 0 && row <= grid.length - 1 && column >= 0 && column <= grid[row].length - 1
                && !Arrays.asList(-1, 0).contains(grid[row][column])) {
            grid[row][column] = -1;
            queue.add(Arrays.asList(row, column));
            specificCellBelogsToWhichIsLand.put(Arrays.asList(row, column), isLandCount);
            trackIslandCells.add(Arrays.asList(row, column));
        }
    }

    private int canMakeLargeIsland(int[][] grid) {
        int largeIsland = Integer.MIN_VALUE;
        Set<Integer> isLands = new HashSet<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                // Scan for water cell
                if (grid[i][j] == 0) {
                    // Left
                    this.getCorrespondingIslands(i, j - 1, grid, isLands);
                    // Right
                    this.getCorrespondingIslands(i, j + 1, grid, isLands);
                    // Top
                    this.getCorrespondingIslands(i - 1, j, grid, isLands);
                    // Bottom
                    this.getCorrespondingIslands(i + 1, j, grid, isLands);
                }
                if (isLands.size() != 0) {
                    int totalCells = isLands.stream().filter(isLand -> mapCellToIsland.containsKey(isLand))
                            .map(isLand -> mapCellToIsland.get(isLand).size()).reduce((a, b) -> a + b).get().intValue();
                    largeIsland = Math.max(largeIsland, totalCells + 1);
                    isLands.clear();
                }
            }
        }
        return largeIsland == Integer.MIN_VALUE ? grid.length * grid[0].length : largeIsland;
    }

    private void getCorrespondingIslands(int row, int column, int[][] grid, Set<Integer> isLands) {
        if (row >= 0 && row <= grid.length - 1 && column >= 0 && column <= grid[row].length - 1
                && grid[row][column] != 0) {
            isLands.add(specificCellBelogsToWhichIsLand.get(Arrays.asList(row, column)));
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
                for (int j = 0; j < n; j++) {
                    grid[i][j] = sc.nextInt();
                }
            }
            Function<int[][], Integer> function = (input) -> new MakingALargeIsland().largestIsland(input);
            System.out.println(function.apply(grid));
            sc.close();
        } catch (Exception e) {
            System.out.println("Exception occurred : " + e.getMessage());
            e.printStackTrace();
        }
    }
}
