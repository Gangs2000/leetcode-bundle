import java.util.Scanner;

public class LongestEvenOddSubarrayWithThreshold {
    int longestCount=Integer.MIN_VALUE;
    public int longestAlternatingSubarray(int[] nums, int threshold) {
        int outerLoop=0;
        while((outerLoop++)<nums.length){
            if(nums[outerLoop]%2==0 && nums[outerLoop]<=threshold){
                int innerLoop=outerLoop+1, count=1;
                while((innerLoop++)<nums.length){
                    if(Math.abs(nums[innerLoop]-nums[innerLoop-1])%2==1 && nums[innerLoop]<=threshold)
                        count++;
                    else
                        break;
                }
                longestCount=Math.max(longestCount, count);
                outerLoop=innerLoop-1;
            }
        }
        return (longestCount==Integer.MIN_VALUE)?(0):(longestCount);
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
            System.out.println("Enter threshold value : ");
            int threshold=sc.nextInt();
            System.out.println(new LongestEvenOddSubarrayWithThreshold().longestAlternatingSubarray(nums, threshold));
            sc.close();
        } 
        catch (Exception e) {
           System.out.println("Exception occurred : "+e.getMessage());
           e.printStackTrace();
        }
    }
}