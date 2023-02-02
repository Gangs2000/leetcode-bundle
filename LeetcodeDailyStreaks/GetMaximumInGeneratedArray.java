package LeetcodeDailyStreaks;

import java.util.Scanner;

public class GetMaximumInGeneratedArray {
    int value=1,getMax=0;
    int[] nums;
    public int getMaximumGenerated(int n) {
        if(n==0)
            return 0;
        if(n==1)
            return 1;        
        nums=new int[n+1];
        nums[0]=0; nums[1]=1;        
        for(int i=2;i<=n;i++){
            if(i%2==0)
                nums[value*2]=nums[value];                
            else{
                nums[(value*2)+1]=nums[value]+nums[value+1];
                value++;
            }
            getMax=Math.max(getMax, nums[i]);            
        }
        return getMax;
    }
    public static void main(String[] args){
        Scanner sc;
        try{
            sc=new Scanner(System.in);
            System.out.println("Enter N value ");
            int n=sc.nextInt();
            System.out.println(new GetMaximumInGeneratedArray().getMaximumGenerated(n));
        }
        catch(Exception e){
            System.out.println("Exception occurred : "+e.getMessage());
            e.printStackTrace();
        }
    }
}
