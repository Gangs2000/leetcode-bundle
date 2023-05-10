import java.util.Arrays;
import java.util.Scanner;

public class ReductionOperationstoMaketheArrayElementsEqual {
    int totalNumCount=0;         
    public int reductionOperations(int[] nums) {        
        Arrays.sort(nums);
        for(int i=nums.length-1;i>0;i--){
            if(nums[i]!=nums[i-1])
                totalNumCount+=nums.length-i;
        }
        return totalNumCount;
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
            System.out.println(new ReductionOperationstoMaketheArrayElementsEqual().reductionOperations(nums));
        }
        catch(Exception e){
            System.out.println("Exception occurred : "+e.getMessage());
            e.printStackTrace();
        }
    }
}
