package LeetcodeDailyStreaks;

import java.util.Scanner;

public class MinimumDistancetotheTargetElement {
    int minDistance = Integer.MAX_VALUE;

    public int getMinDistance(int[] nums, int target, int start) {
        int index = 0;
        while (index <= nums.length / 2) {
            if (nums[index] == target)
                minDistance = Math.min(minDistance, Math.abs(index - start));
            if (nums[nums.length - index - 1] == target)
                minDistance = Math.min(minDistance, Math.abs((nums.length - index - 1) - start));
            index++;
        }
        return minDistance;
    }

    public static void main(String[] args) {
        Scanner sc;
        int[] nums;
        try {
            sc = new Scanner(System.in);
            System.out.println("Enter length of nums array : ");
            int length = sc.nextInt();
            nums = new int[length];
            for (int i = 0; i < length; i++)
                nums[i] = sc.nextInt();
            System.out.println("Enter target and start values : ");
            int target = sc.nextInt(), start = sc.nextInt();
            System.out.println(new MinimumDistancetotheTargetElement().getMinDistance(nums, target, start));
            sc.close();
        } catch (Exception e) {
            System.out.println("Exception occurred : " + e.getMessage());
            e.printStackTrace();
        }
    }
}
