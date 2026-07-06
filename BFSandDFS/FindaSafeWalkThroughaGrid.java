import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class FindaSafeWalkThroughaGrid {
    ArrayDeque<List<Integer>> queue;
    boolean[][][] visited;

    public FindaSafeWalkThroughaGrid() {
        queue = new ArrayDeque<>();
    }

    public boolean findSafeWalk(List<List<Integer>> grid, int health) {
        // Initial position of the grid
        if (grid.get(0).get(0) == 1 && health == 1)
            return false;
        visited = new boolean[grid.size()][grid.get(0).size()][health + 1];
        queue.offer(Arrays.asList(0, 0, health - grid.get(0).get(0)));
        visited[0][0][health - grid.get(0).get(0)] = true;
        while (!queue.isEmpty()) {
            List<Integer> list = queue.pollFirst();
            int row = list.get(0), column = list.get(1), currentHealth = list.get(2);
            if (row == grid.size() - 1 && column == grid.get(0).size() - 1 && currentHealth > 0)
                return true;
            // Left
            this.checkBoundaries(row, column - 1, currentHealth, grid);
            // Right
            this.checkBoundaries(row, column + 1, currentHealth, grid);
            // Top
            this.checkBoundaries(row - 1, column, currentHealth, grid);
            // Bottom
            this.checkBoundaries(row + 1, column, currentHealth, grid);
        }
        return false;
    }

    private void checkBoundaries(int i, int j, int currentHealth, List<List<Integer>> grid) {
        if (i >= 0 && j >= 0 && i <= grid.size() - 1 && j <= grid.get(i).size() - 1) {
            int currentSafety = grid.get(i).get(j);
            if (currentHealth - currentSafety >= 1 && !visited[i][j][currentHealth - currentSafety]) {
                if (currentSafety == 1)
                    queue.offerLast(Arrays.asList(i, j, currentHealth - currentSafety));
                else
                    queue.offerFirst(Arrays.asList(i, j, currentHealth - currentSafety));
                visited[i][j][currentHealth - currentSafety] = true;
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc;
        List<List<Integer>> grid = new LinkedList<>();
        try {
            sc = new Scanner(System.in);
            System.out.println("Enter length of M and N : ");
            int m = sc.nextInt(), n = sc.nextInt();
            for (int i = 0; i < m; i++) {
                List<Integer> columns = new LinkedList<>();
                for (int j = 0; j < n; j++) {
                    columns.add(sc.nextInt());
                }
                grid.add(columns);
            }
            System.out.println("Enter health value : ");
            int health = sc.nextInt();
            java.util.function.BiFunction<List<List<Integer>>, Integer, Boolean> biFunction = new FindaSafeWalkThroughaGrid()::findSafeWalk;
            System.out.println(biFunction.apply(grid, health));
            sc.close();
        } catch (Exception e) {
            System.out.println("Exception occurred : " + e.getMessage());
            e.printStackTrace();
        }
    }
}
