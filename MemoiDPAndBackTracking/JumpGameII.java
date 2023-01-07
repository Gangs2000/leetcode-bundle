package MemoiDPAndBackTracking;

import java.util.Scanner;

public class JumpGameII {    
    public int jump(int[] nums) {           
        return isReachableWithMinDepth(0, nums, 0);
    }
    public int isReachableWithMinDepth(int index, int[] nums, int depth){
        if(index==nums.length-1 || index>=nums.length)                                     
            return depth;        
        int minDepth=Integer.MAX_VALUE;
        for(int i=1;i<=nums[index];i++){
            int currentDepth=isReachableWithMinDepth(index+i, nums, depth+1);
            minDepth=Math.min(minDepth, currentDepth);
        }
        return minDepth;
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
            System.out.println(new JumpGameII().jump(nums));
        }
        catch(Exception e){
            System.out.println("Exception occurred : "+e.getMessage());
            e.printStackTrace();
        }
    }
}
