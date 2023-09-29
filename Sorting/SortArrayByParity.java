import java.util.Scanner;

public class SortArrayByParity {
    int[] sortedArray;    
    public int[] sortArrayByParity(int[] nums) {
        sortedArray=new int[nums.length];
        int leftPointer=0, rightPointer=nums.length-1;
        for(int i=0;i<nums.length;i++){
            if(nums[i]%2==0)
                sortedArray[leftPointer++]=nums[i];                
            else
                sortedArray[rightPointer--]=nums[i];
        }
        return sortedArray;
    }
    public static void main(String[] args){
        Scanner sc;
        int[] nums;
        try{
            sc=new Scanner(System.in);
            System.out.println("Enter length of nums array : ");
            int length=sc.nextInt();
            nums=new int[length];
            for(int i=0;i<length;i++)
                nums[i]=sc.nextInt();
            System.out.println(new SortArrayByParity().sortArrayByParity(nums));
        }   
        catch(Exception e){
            System.out.println("Exception occurred : "+e.getMessage());
            e.printStackTrace();
        }
    }
}
