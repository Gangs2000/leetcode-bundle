package LeetcodeDailyStreaks;

import java.util.Scanner;

public class PowerOfFour {
    public boolean isPowerOfFour(int n) {
        return findPowerMatchesWithN(n); 
    }
    private boolean findPowerMatchesWithN(int n){
        if(n<1)
            return false;
        if(n==1)
            return true;
        if(n%4==0)
            return findPowerMatchesWithN(n/4);
        return false;
    }
    public static void main(String[] args){
        Scanner sc;
        try{
            sc=new Scanner(System.in);
            System.out.println("Enter N value : ");
            int n=sc.nextInt();
            System.out.println(new PowerOfFour().isPowerOfFour(n));
        }
        catch(Exception e){
            System.out.println("Exception occurred : "+e.getMessage());
            e.printStackTrace();
        }
    }
}
