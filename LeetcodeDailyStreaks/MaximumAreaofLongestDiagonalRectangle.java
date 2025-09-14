import java.util.Scanner;
import java.util.function.Function;

public class MaximumAreaofLongestDiagonalRectangle {
    int maxArea = Integer.MIN_VALUE;
    double maxSquare = 0.0;

    public int areaOfMaxDiagonal(int[][] dimensions) {
        for (int i = 0; i < dimensions.length; i++) {
            double currentValue = Math
                    .sqrt((dimensions[i][0] * dimensions[i][0]) + (dimensions[i][1] * dimensions[i][1]));
            if (currentValue >= maxSquare) {
                maxSquare = currentValue;
                maxArea = Math.max(maxArea, dimensions[i][0] * dimensions[i][1]);
            }
        }
        return maxArea;
    }

    public static void main(String[] args) {
        Scanner sc;
        int[][] nums;
        try {
            sc = new Scanner(System.in);
            System.out.println("Enter length of nums array : ");
            int length = sc.nextInt();
            nums = new int[length][2];
            for (int i = 0; i < length; i++) {
                nums[i][0] = sc.nextInt();
                nums[i][1] = sc.nextInt();
            }
            Function<int[][], Integer> function = (input) -> new MaximumAreaofLongestDiagonalRectangle()
                    .areaOfMaxDiagonal(input);
            System.out.println(function.apply(nums));
            sc.close();
        } catch (Exception e) {
            System.out.println("Exception occurred : " + e.getMessage());
            e.printStackTrace();
        }
    }
}
