package LeetcodeDailyStreaks;

import java.util.Scanner;

public class PowerOfTwo {
    int power=0;
    public boolean isPowerOfTwo(int n) {
        while(n>=Math.pow(2, power)){
            if(n==Math.pow(2, power))
                return true;
            power++;
        }
        return false;
    }
    public static void main(String[] args) {
        Scanner sc;
        try {
            sc=new Scanner(System.in);
            System.out.println("Enter N value : ");
            int n=sc.nextInt();
            System.out.println(new PowerOfTwo().isPowerOfTwo(n));
            sc.close();
        } 
        catch (Exception e) {
            System.out.println("Exception occurred : "+e.getMessage());
            e.printStackTrace();
        }
    }
}
