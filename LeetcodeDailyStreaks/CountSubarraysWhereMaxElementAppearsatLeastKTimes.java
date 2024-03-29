import java.util.Scanner;

public class CountSubarraysWhereMaxElementAppearsatLeastKTimes {
    int maxElement=Integer.MIN_VALUE, count=0;
    long totalCount=0;
    public long countSubarrays(int[] nums, int k) {
        int leftPointer=0, rightPointer=0;
        this.findMaxElement(nums);
        while(rightPointer<nums.length){
            if(nums[rightPointer]==maxElement)
                count++;
            while(leftPointer<nums.length && count>=k){
                if(nums[leftPointer]==maxElement)
                    count--;
                leftPointer++;
            }
            totalCount+=leftPointer;
            rightPointer++;
        }
        return totalCount;
    }
    public void findMaxElement(int[] nums){
        for(int number : nums)
            maxElement=Math.max(maxElement, number);
    }
    public static void main(String[] args) {
        Scanner sc;
        int[] nums;
        try{
            sc=new Scanner(System.in);
            System.out.println("Enter length of nums array : ");
            int length=sc.nextInt();
            nums=new int[length];
            for(int i=0;i<length;i++)
                nums[i]=sc.nextInt();
            System.out.println("Enter K value : ");
            int k=sc.nextInt();
            System.out.println(new CountSubarraysWhereMaxElementAppearsatLeastKTimes().countSubarrays(nums, k));
            sc.close();
        }
        catch(Exception e){
            System.out.println("Exception occurred : "+e.getMessage());
            e.printStackTrace();
        }
    }
}
