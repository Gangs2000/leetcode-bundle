import java.util.Scanner;
import java.util.function.BiFunction;

public class SlidingWindowSum {
    public int[] windowSum(int[] arr, int k) {
        int leftPointer = 0, rightPoitner = 0, currentSum = 0;
        int[] resultArr = new int[arr.length];
        while (rightPoitner < arr.length) {
            while (rightPoitner < arr.length && rightPoitner - leftPointer < k) {
                currentSum += arr[rightPoitner];
                resultArr[rightPoitner++] = currentSum;
            }
            currentSum -= arr[leftPointer];
            leftPointer++;
        }
        return resultArr;
    }

    public static void main(String[] args) {
        Scanner sc;
        int[] arr;
        try {
            sc = new Scanner(System.in);
            System.out.println("Enter length of an array : ");
            int length = sc.nextInt();
            arr = new int[length];
            for (int i = 0; i < length; i++)
                arr[i] = sc.nextInt();
            System.out.println("Enter K value : ");
            int k = sc.nextInt();
            BiFunction<int[], Integer, int[]> biFunction = new SlidingWindowSum()::windowSum;
            System.out.println(biFunction.apply(arr, k));
            sc.close();
        } catch (Exception e) {
            System.out.println("Exception occurred : " + e.getMessage());
            e.printStackTrace();
        }
    }
}
