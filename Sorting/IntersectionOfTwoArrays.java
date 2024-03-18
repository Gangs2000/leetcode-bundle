import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class IntersectionOfTwoArrays {
    List<Integer> resultList;
    public IntersectionOfTwoArrays(){
        resultList=new LinkedList<>();
    }
    public int[] intersection(int[] nums1, int[] nums2) {
        int leftPointer=0, rightPointer=0;
        Arrays.sort(nums1); Arrays.sort(nums2);
        while(leftPointer<nums1.length && rightPointer<nums2.length){
            if(nums1[leftPointer]<nums2[rightPointer])
                leftPointer++;
            else if(nums1[leftPointer]>nums2[rightPointer])
                rightPointer++;
            else if(nums1[leftPointer]==nums2[rightPointer]){
                if(!resultList.contains(nums1[leftPointer]))
                    resultList.add(nums2[rightPointer]);
                leftPointer++; rightPointer++;
            }
        }
        return resultList.stream().mapToInt(Integer::intValue).toArray();
    }
    public static void main(String[] args) {
        Scanner sc;
        int[] nums1, nums2;
        try {
            sc=new Scanner(System.in);
            System.out.println("Enter length of num1 array : ");
            int length1=sc.nextInt();
            nums1=new int[length1];
            for(int i=0;i<length1;i++)
                nums1[i]=sc.nextInt();
            System.out.println("Enter length of num2 array : ");
            int length2=sc.nextInt();
            nums2=new int[length2];
            for(int i=0;i<length2;i++)
                nums2[i]=sc.nextInt();
            System.out.println(new IntersectionOfTwoArrays().intersection(nums1, nums2));
            sc.close();
        } 
        catch (Exception e) {
            System.out.println("Exception occurred : "+e.getMessage());
            e.printStackTrace();
        }
    }
}
