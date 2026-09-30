import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;
import java.util.function.Function;

public class CheckifThereIsaValidParenthesesStringPath {
    Queue<List<Object>> queue;

    public CheckifThereIsaValidParenthesesStringPath() {
        queue = new ArrayDeque<>();
    }

    public boolean hasValidPath(char[][] grid) {
        int m = grid.length, n = grid[0].length;
        if ((m + n - 1) % 2 != 0 || grid[0][0] == ')' || grid[m - 1][n - 1] == '(')
            return false;
        int maxBalance = (m + n - 1) / 2;
        boolean[][][] visited = new boolean[m][n][maxBalance + 1];
        visited[0][0][1] = true;
        // Loading initial path to the queue
        queue.add(Arrays.asList(0, 0, 1));
        while (!queue.isEmpty()) {
            List<Object> peekList = queue.poll();
            int row = (int) peekList.get(0), column = (int) peekList.get(1), balance = (int) peekList.get(2);
            // Found one valid path
            if (row == grid.length - 1 && column == grid[0].length - 1)
                return balance == 0;
            if (balance > (m - 1 - row) + (n - 1 - column))
                continue;
            // Right
            if (column + 1 <= grid[0].length - 1)
                this.performStack(row, column + 1, balance, maxBalance, grid[row][column + 1], queue, visited);
            // Down
            if (row + 1 <= grid.length - 1)
                this.performStack(row + 1, column, balance, maxBalance, grid[row + 1][column], queue, visited);
        }
        return false;
    }

    private void performStack(int row, int column, int balance, int maxBalance, char currentChar,
            Queue<List<Object>> queue, boolean[][][] visited) {
        balance = balance + (currentChar == '(' ? 1 : -1);
        if (balance < 0 || balance > maxBalance || visited[row][column][balance])
            return;
        queue.add(Arrays.asList(row, column, balance));
        visited[row][column][balance] = true;
    }

    public static void main(String[] args) {
        Scanner sc;
        char[][] grid;
        try {
            sc = new Scanner(System.in);
            System.out.println("Enter M and N values for the grid : ");
            int m = sc.nextInt(), n = sc.nextInt();
            grid = new char[m][n];
            for (int i = 0; i < m; i++)
                for (int j = 0; j < n; j++)
                    grid[i][j] = sc.nextLine().charAt(0);
            Function<char[][], Boolean> function = new CheckifThereIsaValidParenthesesStringPath()::hasValidPath;
            System.out.println(function.apply(grid));
            sc.close();
        } catch (Exception e) {
            System.out.println("Exception occurred : " + e.getMessage());
            e.printStackTrace();
        }
    }
}
