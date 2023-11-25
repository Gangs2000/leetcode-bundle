import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class MaximumNumberofCoinsYouCanGet {
    int maxCoinsOfMine=0;
    public int maxCoins(int[] piles) {                
        /* With Descending order run time is 113ms and beats 5.30% of Java users ( Worst approach ) */
        piles=Arrays.stream(piles).boxed().sorted(Collections.reverseOrder()).mapToInt(Integer::intValue).toArray();
        /* With Ascending order run time is 27ms and beats 98.99% of Java users ( Best approach ) */
        Arrays.sort(piles);
        int leftPointer=0, rightPointer=piles.length-2;
        while(leftPointer<rightPointer){
            maxCoinsOfMine+=piles[rightPointer];
            rightPointer=rightPointer-2;
            leftPointer++;            
        }            
        return maxCoinsOfMine;
    }
    public static void main(String[] args){
        Scanner sc;
        int[] piles;
        try{
            sc=new Scanner(System.in);
            System.out.println("Enter length of piles array : ");
            int length=sc.nextInt();
            piles=new int[length];
            for(int i=0;i<length;i++)
                piles[i]=sc.nextInt();
            System.out.println(new MaximumNumberofCoinsYouCanGet().maxCoins(piles));       
        }
        catch(Exception e){
            System.out.println("Exception occurred : "+e.getMessage());
            e.printStackTrace();
        }
    }
}
