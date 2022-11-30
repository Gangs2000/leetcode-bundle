package LeetcodeDailyStreaks;

import java.util.Scanner;

public class MinimumDeletionsToMakeArrayBeautiful {
    public int minDeletion(int[] nums) {
        int res = 0, pre = -1;
        for (int a : nums) {
            if (a == pre)
                res++;
            else
                pre = pre < 0 ? a : -1;
        }
        return pre < 0 ? res : res + 1;
    }
    public static void main(String[] args){
        Scanner sc;
        int[] numArray;
        try{
            sc=new Scanner(System.in);
            System.out.println("Enter length of an number array : ");
            int length=sc.nextInt();
            numArray=new int[length];
            System.out.println(numArray.length);
            for(int i=0;i<length;i++)
                numArray[i]=sc.nextInt();            
            System.out.println(new MinimumDeletionsToMakeArrayBeautiful().minDeletion(numArray));
        }
        catch(Exception e){
            System.out.println("Exception occured : "+e.getMessage());
            e.printStackTrace();
        }
    }
}
