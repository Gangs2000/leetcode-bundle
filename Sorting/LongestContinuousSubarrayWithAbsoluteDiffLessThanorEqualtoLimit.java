import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class LongestContinuousSubarrayWithAbsoluteDiffLessThanorEqualtoLimit {
    int longestContinuousSubArrLength=Integer.MIN_VALUE, leftPointer=0, rightPointer=0;
    PriorityQueue<Integer> minHeap, maxHeap;
    public LongestContinuousSubarrayWithAbsoluteDiffLessThanorEqualtoLimit(){
        minHeap=new PriorityQueue<>();
        maxHeap=new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2.compareTo(o1);
            }
        });
    }
    public int longestSubarray(int[] nums, int limit) {
        while (leftPointer<nums.length && rightPointer<nums.length) {
            minHeap.add(nums[rightPointer]);
            maxHeap.add(nums[rightPointer]);
            if(Math.abs(maxHeap.peek()-minHeap.peek())>limit){
                minHeap.remove(nums[leftPointer]);
                maxHeap.remove(nums[leftPointer]);
                leftPointer++;
            }
            longestContinuousSubArrLength=Math.max(longestContinuousSubArrLength, (rightPointer-leftPointer)+1);
            rightPointer++;
        }
        return longestContinuousSubArrLength;
    }
    public static void main(String[] args) {
        Scanner sc;
        int[] nums;
        try {
            sc=new Scanner(System.in);
            System.out.println("Enter length of nums array : ");
            int length=sc.nextInt();
            nums=new int[length];
            for(int i=0;i<length;i++)
                nums[i]=sc.nextInt();
            System.out.println("Enter Limit value : ");
            int limit=sc.nextInt();
            System.out.println(new LongestContinuousSubarrayWithAbsoluteDiffLessThanorEqualtoLimit().longestSubarray(nums, limit));
            sc.close();
        } 
        catch (Exception e) {
            System.out.println("Excpetion occurred : "+e.getMessage());
            e.printStackTrace();
        }
    }
}
