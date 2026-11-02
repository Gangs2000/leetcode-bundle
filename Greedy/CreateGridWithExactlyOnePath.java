import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class CreateGridWithExactlyOnePath {
    public String[] createGrid(int m, int n) {
        String[][] result = new String[m][n];
        Arrays.stream(result).forEach(inner -> Arrays.fill(inner, "#"));
        for (int i = 0; i < m; i++) {
            result[i][0] = ".";
        }
        for (int i = 1; i < n; i++) {
            result[m - 1][i] = ".";
        }
        return Arrays.stream(result)
                .map(inner -> Arrays.stream(inner).collect(Collectors.joining("")))
                .toArray(String[]::new);
    }

    public static void main(String[] args) {
        Scanner sc;
        try {
            sc = new Scanner(System.in);
            System.out.println("Enter row and column values : ");
            int row = sc.nextInt(), column = sc.nextInt();
            java.util.function.BiFunction<Integer, Integer, String[]> bifunction = new CreateGridWithExactlyOnePath()::createGrid;
            System.out.println(bifunction.apply(row, column));
            sc.close();
        } catch (Exception e) {
            System.out.println("Exception occurred : " + e.getMessage());
            e.printStackTrace();
        }
    }
}
