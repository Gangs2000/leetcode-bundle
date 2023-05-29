import java.util.Scanner;

public class MinimumNumbersofFunctionCallstoMakeTargetArray {
    public int minOperations(int[] nums) {
        int count=0;
        boolean isEvenFound=false;
        for(int i=0;i<nums.length;i++){
            if((nums[i]%2)!=0){
                nums[i]--;
                count++;
            }
            if(nums[i]>0){
                isEvenFound=true;
                nums[i]/=2;
            }
        }
        if(isEvenFound)
            count++;        
        return (count>0)?(count+minOperations(nums)):(0);
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
            System.out.println(new MinimumNumbersofFunctionCallstoMakeTargetArray().minOperations(nums));
        }
        catch(Exception e){
            System.out.println("Exception occurred : "+e.getMessage());
            e.printStackTrace();
        }
    }
}
