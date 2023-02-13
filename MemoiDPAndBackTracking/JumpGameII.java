package MemoiDPAndBackTracking;

import java.util.Scanner;

public class JumpGameII {    
    int[] cache;    
    public int jump(int[] nums) {           
        cache=new int[nums.length];        
        return isReachableWithMinDepth(0, nums, cache);
    }
    public int isReachableWithMinDepth(int index, int[] nums, int[] cache){
        if(index>=nums.length-1)
            return 0;
        if(cache[index]!=0)
            return cache[index];
        int minDepth=10001;
        for(int i=index+1;i<=nums[index]+index;i++)            
            minDepth=Math.min(minDepth, 1+isReachableWithMinDepth(i, nums, cache));
        cache[index]=minDepth;
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