import java.util.Scanner;
import java.util.function.Function;

public class ConstructProductMatrix {

    int[][] result, suffixProduct;

    public int[][] constructProductMatrix(int[][] grid) {
        result = new int[grid.length][grid[0].length];
        suffixProduct = new int[grid.length][grid[0].length];
        long suffixProduct = 1, prefixProduct = 1;
        for (int i = grid.length - 1; i >= 0; i--) {
            for (int j = grid[i].length - 1; j >= 0; j--) {
                result[i][j] = (int) suffixProduct;
                suffixProduct = (suffixProduct * grid[i][j]) % 12345;
            }
        }

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                result[i][j] = (int) (prefixProduct * result[i][j]) % 12345;
                prefixProduct = (prefixProduct * grid[i][j]) % 12345;
            }
        }
        return result;
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
            Function<int[][], int[][]> function = new ConstructProductMatrix()::constructProductMatrix;
            System.out.println(function.apply(grid));
            sc.close();
        } catch (Exception e) {
            System.out.println("Exception occurred : " + e.getMessage());
            e.printStackTrace();
        }
    }
}
