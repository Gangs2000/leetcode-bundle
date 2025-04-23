import java.util.Scanner;

public class CountGoodTriplets {
    int countTriplets = 0;

    public int countGoodTriplets(int[] arr, int a, int b, int c) {
        for (int i = 0; i <= arr.length - 3; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                for (int k = j + 1; k < arr.length; k++) {
                    if (Math.abs(arr[i] - arr[j]) <= a && Math.abs(arr[j] - arr[k]) <= b
                            && Math.abs(arr[i] - arr[k]) <= c)
                        countTriplets++;
                }
            }
        }
        return countTriplets;
    }

    public static void main(String[] args) {
        Scanner sc;
        int[] nums;
        try {
            sc = new Scanner(System.in);
            System.out.println("Enter length of nums array : ");
            int length = sc.nextInt();
            nums = new int[length];
            System.out.println("Enter A, B and C values : ");
            int a = sc.nextInt(), b = sc.nextInt(), c = sc.nextInt();
            System.out.println(new CountGoodTriplets().countGoodTriplets(nums, a, b, c));
            sc.close();
        } catch (Exception e) {
            System.out.println("Exception occurred : " + e.getMessage());
            e.printStackTrace();
        }
    }
}
