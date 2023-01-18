import java.util.Scanner;

public class MaxSubArray {
    //Kadane's algorithm
    public int maxSubArray(int[] nums) {
        int sum=nums[0];
        int maxSum=nums[0];
        for(int i=1;i<nums.length;i++){
            sum=Math.max(sum+nums[i], nums[i]);
            maxSum=Math.max(maxSum, sum);
        }
        return maxSum;
    } 
    public static void main(String[] args){
        Scanner sc;
        int[] nums;
        try{
            sc=new Scanner(System.in);           
            System.out.println("Enter the length of an array list : ");
            int length=sc.nextInt();
            nums=new int[length];
            for(int i=0;i<length;i++)
                nums[i]=sc.nextInt();            
            System.out.println("Max Sub Array Sum is "+new MaxSubArray().maxSubArray(nums));
        }
        catch(Exception e){
            System.out.println("Exception occured : "+e.getMessage());
            e.printStackTrace();
        }
    }
}
