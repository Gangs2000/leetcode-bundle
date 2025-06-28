import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class FindAllKDistantIndicesinanArray {
    List<Integer> resultList;

    public FindAllKDistantIndicesinanArray() {
        resultList = new LinkedList<>();
    }

    public List<Integer> findKDistantIndices(int[] nums, int key, int k) {
        int leftPointer = 0, rightPointer = 0;
        while (leftPointer < nums.length) {
            while (rightPointer < nums.length) {
                if (nums[rightPointer] == key && Math.abs(nums[leftPointer] - nums[rightPointer]) <= k) {
                    resultList.add(leftPointer);
                    break;
                }
                rightPointer++;
            }
            leftPointer++;
            rightPointer = 0;
        }
        return resultList;
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
            System.out.println("Enter Key and K values : ");
            int key = sc.nextInt(), k = sc.nextInt();
            System.out.println(new FindAllKDistantIndicesinanArray().findKDistantIndices(nums, key, k));
            sc.close();
        } catch (Exception e) {
            System.out.println("Exception occurred : " + e.getMessage());
            e.printStackTrace();
        }
    }
}
