import java.util.Scanner;

public class MinimumCommonValue {
    public int getCommon(int[] nums1, int[] nums2) {
        int leftPointer=0, rightPointer=0;
        while(leftPointer<nums1.length && rightPointer<nums2.length){
            if(nums1[leftPointer]<nums2[rightPointer])
                leftPointer++;
            else if(nums1[leftPointer]>nums2[rightPointer])
                rightPointer++;
            else if(nums1[leftPointer]==nums2[rightPointer])
                return nums2[rightPointer];
        }
        return -1;
    }
    public static void main(String[] args) {
        Scanner sc;
        int[] num1, num2;
        try {
            sc=new Scanner(System.in);
            System.out.println("Enter length of num1 array : ");
            int length1=sc.nextInt();
            num1=new int[length1];
            for(int i=0;i<length1;i++)
                num1[i]=sc.nextInt();
            System.out.println("Enter length of num2 array : ");
            int length2=sc.nextInt();
            num2=new int[length2];
            for(int i=0;i<length2;i++)
                num2[i]=sc.nextInt();
            System.out.println(new MinimumCommonValue().getCommon(num1, num2));
            sc.close();
        } 
        catch (Exception e) {
            System.out.println("Exception occurred : "+e.getMessage());
            e.printStackTrace();
        }
    }
}
