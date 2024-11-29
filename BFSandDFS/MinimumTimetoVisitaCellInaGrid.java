import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.Set;
import java.util.function.Function;

public class MinimumTimetoVisitaCellInaGrid {
    PriorityQueue<List<Integer>> priorityQueue;
    Set<List<Integer>> visited;

    public MinimumTimetoVisitaCellInaGrid() {
        visited = new HashSet<>();
        priorityQueue = new PriorityQueue<>(new Comparator<List<Integer>>() {
            @Override
            public int compare(List<Integer> o1, List<Integer> o2) {
                return o1.get(2).compareTo(o2.get(2));
            }
        });
    }

    public int minimumTime(int[][] grid) {
        // Base case to handle if initial choice is stuck then return -1
        if (grid[0][1] > 1 && grid[1][0] > 1)
            return -1;
        return this.breathFirstSearch(grid);
    }

    private void checkAdjacentCells(int i, int j, int currentMove, int[][] grid) {
        if (i >= 0 && j >= 0 && i <= grid.length - 1 && j <= grid[i].length - 1
                && !visited.contains(Arrays.asList(i, j))) {
            int waitingMoves = (grid[i][j] - currentMove) % 2 == 0 ? 1 : 0;
            int nextMove = Math.max(grid[i][j] + waitingMoves, currentMove + 1);
            priorityQueue.add(Arrays.asList(i, j, nextMove));
            visited.add(Arrays.asList(i, j));
        }
    }

    private int breathFirstSearch(int[][] grid) {
        // Load initial point ( row, col, noOfMoves )
        priorityQueue.add(Arrays.asList(0, 0, 0));
        visited.add(Arrays.asList(0, 0));
        while (!priorityQueue.isEmpty()) {
            List<Integer> currentGrid = priorityQueue.poll();
            int row = currentGrid.get(0), column = currentGrid.get(1), currentMove = currentGrid.get(2);
            // Return minimum time if pointer reached the bottom right curner of the grid
            if (row == grid.length - 1 && column == grid[row].length - 1)
                return currentMove;
            // Left
            this.checkAdjacentCells(row, column - 1, currentMove, grid);
            // Right
            this.checkAdjacentCells(row, column + 1, currentMove, grid);
            // Top
            this.checkAdjacentCells(row - 1, column, currentMove, grid);
            // Bottom
            this.checkAdjacentCells(row + 1, column, currentMove, grid);
        }
        return -1;
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
            Function<int[][], Integer> function = (input1) -> new MinimumTimetoVisitaCellInaGrid().minimumTime(input1);
            System.out.println(function.apply(grid));
            sc.close();
        } catch (Exception e) {
            System.out.println("Exception occurred : " + e.getMessage());
            e.printStackTrace();
        }
    }
}
