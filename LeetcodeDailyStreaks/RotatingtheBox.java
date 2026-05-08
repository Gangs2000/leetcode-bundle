package LeetcodeDailyStreaks;

import java.util.Scanner;
import java.util.function.UnaryOperator;

public class RotatingtheBox {
    char[][] result;

    public char[][] rotateTheBox(char[][] boxGrid) {
        int m = boxGrid.length, n = boxGrid[0].length;
        result = new char[n][m];

        for (int i = 0; i < m; i++) {
            int rightPointer = n - 1, leftPointer = n - 1;
            while (leftPointer >= 0) {
                if (boxGrid[i][leftPointer] == '.') {
                    while (rightPointer >= 0) {
                        if (boxGrid[i][rightPointer] == '*')
                            leftPointer = rightPointer;
                        if (boxGrid[i][rightPointer] == '.' && boxGrid[i][leftPointer] == '*')
                            leftPointer = rightPointer;
                        if (boxGrid[i][rightPointer] == '#' && boxGrid[i][leftPointer] == '.') {
                            boxGrid[i][rightPointer] = '.';
                            boxGrid[i][leftPointer] = '#';
                            break;
                        }
                        rightPointer--;
                    }
                }
                leftPointer--;
                rightPointer--;
            }
        }
        int a = 0, b = 0;
        for (int i = boxGrid.length - 1; i >= 0; i--) {
            for (int j = 0; j < boxGrid[0].length; j++)
                result[a++][b] = boxGrid[i][j];
            a = 0;
            b++;
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner sc;
        char[][] grid;
        try {
            sc = new Scanner(System.in);
            System.out.println("Enter M and N values for grid : ");
            int m = sc.nextInt(), n = sc.nextInt();
            grid = new char[m][n];
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++)
                    grid[i][j] = sc.nextLine().charAt(0);
            }
            UnaryOperator<char[][]> unaryOperator = new RotatingtheBox()::rotateTheBox;
            System.out.println(unaryOperator.apply(grid));
            sc.close();
        } catch (Exception e) {
            System.out.println("Exception occurred : " + e.getMessage());
            e.printStackTrace();
        }
    }
}
