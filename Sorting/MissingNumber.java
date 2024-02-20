import java.util.Arrays;
import java.util.Scanner;

public class MissingNumber {
    public int missingNumber(int[] nums) {
        //Sort the array before performing binary search
        Arrays.sort(nums);
        int leftPointer=0, rightPointer=nums.length-1;
        while (leftPointer<=rightPointer) {
            int middle=leftPointer+((rightPointer-leftPointer)/2);
            //Discard first half of the array if middle is equal to nums[middle]
            if(middle==nums[middle])
                leftPointer=middle+1;
            //Discard last half of the array if middle is less than nums[middle]
            else if(middle<nums[middle])
                rightPointer=middle-1;
        }
        return leftPointer;
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
            System.out.println(new MissingNumber().missingNumber(nums));
            sc.close();
        } 
        catch (Exception e) {
            System.out.println("Exception occurred : "+e.getMessage());
            e.printStackTrace();
        }
    }
}
