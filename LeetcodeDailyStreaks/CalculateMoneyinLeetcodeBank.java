package LeetcodeDailyStreaks;

import java.util.Scanner;

public class CalculateMoneyinLeetcodeBank {
    int days=1, step=1, amount=step, totalAmount=0;
    public int totalMoney(int n) {
        while(days<=n){            
            totalAmount+=amount;            
            amount=(days%7==0)?(++step):(amount+1);
            days++;
        }
        return totalAmount;        
    }
    public static void main(String[] args){
        Scanner sc;
        try{
            sc=new Scanner(System.in);
            System.out.println("Enter N value : ");
            int n=sc.nextInt();
            System.out.println(new CalculateMoneyinLeetcodeBank().totalMoney(n));
        }   
        catch(Exception e){
            System.out.println("Exception occurred : "+e.getMessage());
            e.printStackTrace();
        }
    }
}
