package MemoizationAndDP;

import java.util.Scanner;

public class ClimbingStairs {
    int[] cache;
    public ClimbingStairs(){
        cache=new int[46];
    }
    public int climbStairs(int n) {
        if(n<=3)
            return n;
        if(cache[n]!=0)
            return cache[n];
        else    
            return cache[n]=climbStairs(n-1)+climbStairs(n-2);
    }
    public static void main(String[] args){
        Scanner sc;
        try{
            sc=new Scanner(System.in);
            System.out.println("Enter n value to find out distinct ways to split steps count : ");
            int n=sc.nextInt();
            System.out.println(new ClimbingStairs().climbStairs(n));
        }
        catch(Exception e){
            System.out.println("Exception occured : "+e.getMessage());
            e.printStackTrace();
        }
    }
}
