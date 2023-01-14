package LeetcodeDailyStreaks;

import java.util.Scanner;

public class MinimumMovesToReachTargetScore {
    int minSteps=0;
    public int minMoves(int target, int maxDoubles) {
        if(target==1)
            return 0;        
        if(target!=1 && maxDoubles==0)
            return target-1;
        while(target!=1 && maxDoubles!=0){
            if(target%2==1){
                target--;
                minSteps++;
            }
            else if(target%2==0){                
                target/=2;
                minSteps++; maxDoubles--;
            }            
        }
        return (target==1)?(minSteps):(minSteps+(target-1));
    }
    public static void main(String[] args){
        Scanner sc;
        try{
            sc=new Scanner(System.in);
            System.out.println("Enter Target and Max doubles value : ");
            int target=sc.nextInt();
            int maxDoubles=sc.nextInt();
            System.out.println(new MinimumMovesToReachTargetScore().minMoves(target, maxDoubles));
        }
        catch(Exception e){
            System.out.println("Exception occurred : "+e.getMessage());
            e.printStackTrace();
        }
    }
}
