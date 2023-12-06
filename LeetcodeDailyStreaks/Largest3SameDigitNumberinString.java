package LeetcodeDailyStreaks;

import java.util.Scanner;

public class Largest3SameDigitNumberinString {    
    String resultStr="";
    int freqCount=1;
    public String largestGoodInteger(String num) {
        for(int i=1;i<num.length();i++){
            if(num.charAt(i)==num.charAt(i-1)){
                freqCount++;
                if(freqCount==3){                
                    if(resultStr.equals(""))
                        resultStr=num.substring(i-2, i+1);
                    else{
                        if(resultStr.equals("000") && num.substring(i-2, i+1).equals("000"))
                            resultStr="000";
                        else
                            resultStr=String.valueOf(Math.max(Integer.valueOf(resultStr), Integer.valueOf(num.substring(i-2, i+1)))); 
                    }
                }
            }            
            else
                freqCount=1;
        }
        return resultStr;
    }
    public static void main(String[] args){
        Scanner sc;
        try{
            sc=new Scanner(System.in);
            System.out.println("Enter String value : ");
            String num=sc.next();
            System.out.println(new Largest3SameDigitNumberinString().largestGoodInteger(num));
        }
        catch(Exception e){
            System.out.println("Exception occurred : "+e.getMessage());
            e.printStackTrace();
        }
    }
}
