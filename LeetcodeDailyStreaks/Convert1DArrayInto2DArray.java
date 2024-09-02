import java.util.Scanner;

public class Convert1DArrayInto2DArray {
    public int[][] construct2DArray(int[] original, int m, int n) {
        if ((m * n) != original.length)
            return new int[][] {};
        int[][] constructed2DArr = new int[m][n];
        int index = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++)
                constructed2DArr[i][j] = original[index++];
        }
        return constructed2DArr;
    }

    public static void main(String[] args) {
        Scanner sc;
        int[] original;
        try {
            sc = new Scanner(System.in);
            System.out.println("Enter length of an original array : ");
            int length = sc.nextInt();
            original = new int[length];
            for (int i = 0; i < length; i++)
                original[i] = sc.nextInt();
            System.out.println("Enter M and N values : ");
            int m = sc.nextInt();
            int n = sc.nextInt();
            System.out.println(new Convert1DArrayInto2DArray().construct2DArray(original, m, n));
            sc.close();
        } catch (Exception e) {
            System.out.println("Exception occurred : " + e.getMessage());
            e.printStackTrace();
        }
    }
}
