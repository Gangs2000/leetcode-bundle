import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class LengthofLongestSubarrayWithatMostKFrequency {
    Map<Integer, Integer> freqMapper;
    int maxSubArrayLength=Integer.MIN_VALUE;
    public LengthofLongestSubarrayWithatMostKFrequency(){
        freqMapper=new HashMap<>();
    }
    public int maxSubarrayLength(int[] nums, int k) {
        int leftPointer=0, rightPointer=0;
        while(rightPointer<nums.length){
            freqMapper.putIfAbsent(nums[rightPointer], 0);
            freqMapper.put(nums[rightPointer], freqMapper.get(nums[rightPointer])+1);
            if(freqMapper.get(nums[rightPointer])>k){
                while(nums[leftPointer]!=nums[rightPointer]){
                    freqMapper.put(nums[leftPointer], freqMapper.get(nums[leftPointer])-1);
                    leftPointer++;
                }
                freqMapper.put(nums[leftPointer], freqMapper.get(nums[leftPointer])-1);
                leftPointer++;
            }
            maxSubArrayLength=Math.max(maxSubArrayLength, rightPointer-leftPointer);
            rightPointer++;
        }
        return maxSubArrayLength+1;
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
            System.out.println("Enter K value : ");
            int k=sc.nextInt();
            System.out.println(new LengthofLongestSubarrayWithatMostKFrequency().maxSubarrayLength(nums, k));
            sc.close();
        } 
        catch (Exception e) {
            System.out.println("Exception occurred : "+e.getMessage());
            e.printStackTrace();
        }
    }
}
