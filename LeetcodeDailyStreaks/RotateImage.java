package LeetcodeDailyStreaks;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;

public class RotateImage {
    // Not an optimal solution - Need to solve this using in-place technique
    public void rotate(int[][] matrix) {
        List<List<Integer>> values = new LinkedList<>();
        for (int i = 0; i < matrix.length; i++) {
            List<Integer> innerList = new LinkedList<>();
            for (int j = 0; j < matrix.length; j++) {
                innerList.add(matrix[j][i]);
            }
            values.add(innerList);
        }

        for (int i = 0; i < matrix.length; i++) {
            List<Integer> innerList = values.get(i);
            for (int j = 0; j < matrix.length; j++)
                matrix[i][j] = innerList.get(matrix.length - j - 1);
        }
    }

    public static void main(String[] args) {
        Scanner sc;
        int[][] grid;
        try {
            sc = new Scanner(System.in);
            System.out.println("Enter N value : ");
            int n = sc.nextInt();
            grid = new int[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++)
                    grid[i][j] = sc.nextInt();
            }
            Consumer<int[][]> consumer = new RotateImage()::rotate;
            consumer.accept(grid);
            sc.close();
        } catch (Exception e) {
            System.out.println("Exception occurred : " + e.getMessage());
            e.printStackTrace();
        }
    }
}
