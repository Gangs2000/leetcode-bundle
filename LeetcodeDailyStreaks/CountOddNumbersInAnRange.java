package LeetcodeDailyStreaks;

import java.util.Scanner;

public class CountOddNumbersInAnRange {
    int oddCount=0;
    public int countOdds(int low, int high) {
        int difference=high-low;
        difference=this.template(low, difference);
        difference=this.template(high, difference);
        return oddCount+(difference/2);
    }
    public int template(int scale, int currentDifference){
        if(scale%2==1){
            oddCount++;
            currentDifference--;
        }
        return currentDifference;
    }
    public static void main(String[] args){
        Scanner sc;
        try{
            sc=new Scanner(System.in);
            System.out.println("Enter Low and High values : ");
            int low=sc.nextInt();
            int high=sc.nextInt();
            System.out.println(new CountOddNumbersInAnRange().countOdds(low, high));
        }
        catch(Exception e){
            System.out.println("Exception occurred : "+e.getMessage());
            e.printStackTrace();
        }
    }
}
