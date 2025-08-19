import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;

public class FindtheMaximumNumberofFruitsCollected {
    List<List<Integer>> queue;
    int maxCollectedByChildOne = 0, maxCollectedByChildTwo = 0, maxCollectedByChildThree = 0;

    public FindtheMaximumNumberofFruitsCollected() {
        queue = new LinkedList<>();
    }

    public int maxCollectedFruits(int[][] fruits) {
        // Collect all fruits for children 1
        for (int i = 0; i < fruits.length; i++) {
            maxCollectedByChildOne += fruits[i][i]; // Collect all diagonal fruits
            fruits[i][i] = -1;
        }
        // (0, n-1) and (n-1, 0) load into initial queue
        queue.add(Arrays.asList(0, fruits.length - 1, fruits[0][fruits.length - 1], 1, 2));
        queue.add(Arrays.asList(fruits.length - 1, 0, fruits[fruits.length - 1][0], 1, 3));
        while ((!queue.isEmpty())) {
            List<Integer> currentList = queue.get(0);
            int currentMove = currentList.get(3);
            // Filter only moves less than n-1
            if (currentMove <= fruits.length - 1) {
                int row = currentList.get(0), column = currentList.get(1), currentTotal = currentList.get(2),
                        currentChild = currentList.get(4);
                if (currentChild == 2) {
                    // Right bottom diagonal
                    this.findNextPossibleFlows(row + 1, column + 1, fruits, currentTotal, currentMove + 1,
                            currentChild);
                    // Left bottom diagonal
                    this.findNextPossibleFlows(row + 1, column - 1, fruits, currentTotal, currentMove + 1,
                            currentChild);
                    // Straight bottom
                    this.findNextPossibleFlows(row + 1, column, fruits, currentTotal, currentMove + 1, currentChild);
                }
                if (currentChild == 3) {
                    // Right bottom diagonal
                    this.findNextPossibleFlows(row + 1, column + 1, fruits, currentTotal, currentMove + 1,
                            currentChild);
                    // Right upper diagonal
                    this.findNextPossibleFlows(row - 1, column + 1, fruits, currentTotal, currentMove + 1,
                            currentChild);
                    // Next column
                    this.findNextPossibleFlows(row, column + 1, fruits, currentTotal, currentMove + 1, currentChild);
                }
            }
            queue.remove(0);
        }
        return maxCollectedByChildOne + maxCollectedByChildTwo + maxCollectedByChildThree;
    }

    private void findNextPossibleFlows(int row, int column, int[][] fruits, int currentTotal, int currentMove,
            int child) {
        if (row >= 0 && column >= 0 && row <= fruits.length - 1 && column <= fruits.length - 1
                && fruits[row][column] != -1) {
            if (row == fruits.length - 1 && column == fruits.length - 1) {
                if (child == 2)
                    maxCollectedByChildTwo = Math.max(maxCollectedByChildTwo, currentTotal);
                else if (child == 3)
                    maxCollectedByChildThree = Math.max(maxCollectedByChildThree, currentTotal);
            } else
                queue.add(Arrays.asList(row, column, currentTotal + fruits[row][column], currentMove, child));
        }
    }

    public static void main(String[] args) {
        Scanner sc;
        int[][] fruits;
        try {
            sc = new Scanner(System.in);
            System.out.println("Enter N value : ");
            int n = sc.nextInt();
            fruits = new int[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++)
                    fruits[i][j] = sc.nextInt();
            }
            Function<int[][], Integer> function = (input) -> new FindtheMaximumNumberofFruitsCollected()
                    .maxCollectedFruits(input);
            System.out.println(function.apply(fruits));
            sc.close();
        } catch (Exception e) {
            System.out.println("Exception occurred : " + e.getMessage());
            e.printStackTrace();
        }
    }
}
