package LeetcodeDailyStreaks;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class LargestNumber {
    StringBuilder stringBuilder=new StringBuilder();
    String[] strArray;
    public String largestNumber(int[] nums) {
        strArray=new String[nums.length];
        for(int i=0;i<nums.length;i++)
            strArray[i]=String.valueOf(nums[i]);
        Comparator<String> comparator=new Comparator<String>() {
            @Override
            public int compare(String arg0, String arg1) {                
                String s1=arg0+arg1;
                String s2=arg1+arg0;
                return s2.compareTo(s1);
            }
        };
        Arrays.sort(strArray, comparator);
        if(strArray[0].equals("0"))
            return "0";
        for(int i=0;i<nums.length-1;i++)
            stringBuilder.append(strArray[i]);
        return stringBuilder.toString();
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
            System.out.println(new LargestNumber().largestNumber(nums));
        }
        catch(Exception e){
            System.out.println("Exception occurred : "+e.getMessage());
            e.printStackTrace();
        }
    }
}
