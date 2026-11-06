import java.util.Arrays;
import java.util.Scanner;

public class FindtheDistanceValueBetweenTwoArraysII {
    public int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
        Arrays.sort(arr2);
        int validCount = 0;
        for (int number : arr1) {
            boolean isValid = this.binarySearch(arr2, number, d);
            if (isValid)
                validCount++;
        }
        return validCount;
    }

    private boolean binarySearch(int[] sortedArr, int number, int distance) {
        int low = 0, high = sortedArr.length - 1;
        while (low <= high) {
            int middle = low + (high - low) / 2;
            if (Math.abs(sortedArr[middle] - number) <= distance)
                return false;
            if (sortedArr[middle] < number)
                low = middle + 1;
            else
                high = middle - 1;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc;
        int[] nums1, nums2;
        try {
            sc = new Scanner(System.in);
            System.out.println("Enter length of nums1 and nums2 array : ");
            int length1 = sc.nextInt(), length2 = sc.nextInt();
            nums1 = new int[length1];
            nums2 = new int[length2];
            for (int i = 0; i < length1; i++)
                nums1[i] = sc.nextInt();
            for (int i = 0; i < length2; i++)
                nums2[i] = sc.nextInt();
            System.out.println("Enter distance value : ");
            int distance = sc.nextInt();
            System.out
                    .println(new FindtheDistanceValueBetweenTwoArraysII().findTheDistanceValue(nums1, nums2, distance));
            sc.close();
        } catch (Exception e) {
            System.out.println("Exception occurred : " + e.getMessage());
            e.printStackTrace();
        }
    }
}
