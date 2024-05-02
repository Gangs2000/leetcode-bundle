import java.util.Arrays;
import java.util.Scanner;

public class LargestPositiveIntegerThatExistsWithItsNegative {
    public int findMaxK(int[] nums) {
        //Sort the array..
        Arrays.sort(nums);
        int leftPointer=0, rightPointer=nums.length-1;
        /*If end element of an array is having -ve that means no +ve present so return -1
        Similarly If start element of an array is having +ve that means no -ve present so return -1*/
        if(nums[rightPointer]<0 || nums[leftPointer]>0)
            return -1;
        //Check, leftpointer is always less than rightpointer and nums[leftPointer] value less than 0
        while(leftPointer<rightPointer && nums[leftPointer]<0){
            int leftValue=Math.abs(nums[leftPointer]);
            int rightValue=nums[rightPointer];
            if(leftValue>rightValue)
                leftPointer++;
            else if(leftValue<rightValue)
                rightPointer--;
            else if(leftValue==rightValue)
                return nums[rightPointer];
        }
        return -1;
    }
    public static void main(String[] args) {
        Scanner sc;
        int[] nums;
        try {
            sc=new Scanner(System.in);
            System.out.println("Enter length nums array : ");
            int length=sc.nextInt();
            nums=new int[length];
            for(int i=0;i<length;i++)
                nums[i]=sc.nextInt();
            System.out.println(new LargestPositiveIntegerThatExistsWithItsNegative().findMaxK(nums));
            sc.close();
        } 
        catch (Exception e) {
            System.out.println("Exception occurred : "+e.getMessage());
            e.printStackTrace();
        }
    }
}
