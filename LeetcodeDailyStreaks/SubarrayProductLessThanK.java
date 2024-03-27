import java.util.Scanner;

public class SubarrayProductLessThanK {
    int totalCount=0;
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int leftPointer=0, rightPointer=0, currentProduct=1;
        while (leftPointer<nums.length) {
            while(rightPointer<nums.length){
                if(currentProduct*nums[rightPointer]<k){
                    totalCount++;
                    currentProduct=currentProduct*nums[rightPointer];
                }
                else
                    break;
                rightPointer++;
            }
            leftPointer++; rightPointer=leftPointer; currentProduct=1;
        }
        return totalCount;
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
            System.out.println(new SubarrayProductLessThanK().numSubarrayProductLessThanK(nums, k));
            sc.close();
        } 
        catch (Exception e) {
            System.out.println("Exception occurred : "+e.getMessage());
            e.printStackTrace();
        }
    }
}
