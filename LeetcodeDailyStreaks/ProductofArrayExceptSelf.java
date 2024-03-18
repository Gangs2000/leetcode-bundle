import java.util.Arrays;
import java.util.Scanner;

public class ProductofArrayExceptSelf {
    int zeroes=0, zeroIndex=0, product=1;
    public int[] productExceptSelf(int[] nums) {
        for(int i=0;i<nums.length;i++){
            if(nums[i]!=0)
                product*=nums[i];
            else if(nums[i]==0){
                zeroes++;
                if(zeroes>1){
                    Arrays.fill(nums, 0);
                    return nums;
                }
                zeroIndex=i;
            }
        }
        if(zeroes==1){
            Arrays.fill(nums, 0);
            nums[zeroIndex]=product;
            return nums;
        }
        for(int i=0;i<nums.length;i++)
            nums[i]=product/nums[i];
        return nums;
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
            System.out.println(new ProductofArrayExceptSelf().productExceptSelf(nums));
            sc.close();
        } 
        catch (Exception e) {
            System.out.println("Exception occurred : "+e.getMessage());
            e.printStackTrace();
        }
    }
}
