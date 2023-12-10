package LeetcodeDailyStreaks;

import java.util.Scanner;

public class LargestOddNumberinString {
    String result="";
    public String largestOddNumber(String num) {
        int pointer=num.length();
        while(pointer!=0){
            String subStr=num.substring(0, pointer);
            if(((int) subStr.charAt(subStr.length()-1))%2==1){
                result=num.substring(0, pointer);
                break;
            }
            pointer--;
        }
        return result;
    }
    public static void main(String[] args){
        Scanner sc;
        try{
            sc=new Scanner(System.in);
            System.out.println("Enter Num value to identify the largest odd number : ");
            String num=sc.next();
            System.out.println(new LargestOddNumberinString().largestOddNumber(num));
        }
        catch(Exception e){
            System.out.println("Exception occurred : "+e.getMessage());
            e.printStackTrace();
        }
    }
}
