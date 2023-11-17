package MemoiDPAndBackTracking;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class FindUniqueBinaryString {
    String resultString="";
    Set<String> uniqueStr;
    public FindUniqueBinaryString(){
        uniqueStr=new HashSet<>();
    }
    public String findDifferentBinaryString(String[] nums) {
        for(int i=0;i<nums.length;i++)
            uniqueStr.add(nums[i]);
        classicBackTracking(new StringBuilder(), nums.length);
        return resultString;
    }
    public boolean classicBackTracking(StringBuilder stringBuilder, int length){
        if(stringBuilder.length()==length){
            if(!uniqueStr.contains(stringBuilder.toString())){
                resultString=stringBuilder.toString();
                return true;
            }
            else
                return false;
        }
        boolean flag=false;
        //Preventing further backtracking if answer is already found in order to reduce time complexity
        if(!flag){
            stringBuilder.append('0');
            flag=classicBackTracking(stringBuilder, length);            
            stringBuilder.deleteCharAt(stringBuilder.length()-1);
        }        
        //Preventing further backtracking if answer is already found in order to reduce time complexity
        if(!flag){
            stringBuilder.append('1');
            flag=classicBackTracking(stringBuilder, length);            
            stringBuilder.deleteCharAt(stringBuilder.length()-1);
        }        
        return flag;
    }
    public static void main(String[] args){
        Scanner sc;
        String[] nums;
        try{
            sc=new Scanner(System.in);
            System.out.println("Enter length of nums array : ");
            int length=sc.nextInt();
            nums=new String[length];
            for(int i=0;i<length;i++)
                nums[i]=sc.useDelimiter("\n").next();
            System.out.println(new FindUniqueBinaryString().findDifferentBinaryString(nums));
        }
        catch(Exception e){
            System.out.println("Exception occurred : "+e.getMessage());
            e.printStackTrace();
        }
    }
}
