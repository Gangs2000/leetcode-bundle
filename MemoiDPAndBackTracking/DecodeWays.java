package MemoiDPAndBackTracking;

import java.util.Scanner;

public class DecodeWays {
    int totalCount=0;   
    public int numDecodings(String s) {
        decodeWays(0, s);
        return totalCount;
    }
    public void decodeWays(int index, String s){
        if(index==s.length()){
            totalCount++;
            return ;
        }
        if(index+1<=s.length() && isValidWay(s.substring(index, index+1)))
            decodeWays(index+1, s);
        if(index+2<=s.length() && isValidWay(s.substring(index, index+2)))
            decodeWays(index+2, s);
    }
    public boolean isValidWay(String string){
        if(string.length()==1 && string.charAt(0)=='0')
            return false;
        if(string.length()==2){
            if(string.charAt(0)=='0')
                return false;
            else if(Integer.valueOf(string)>26)
                return false;
        }
        return true;
    }
    public static void main(String[] args){
        Scanner sc;
        try{
            sc=new Scanner(System.in);
            System.out.println("Enter S value to decode ways : ");
            String s=sc.next();
            System.out.println(new DecodeWays().numDecodings(s));
        }
        catch(Exception e){
            System.out.println("Exception occurred : "+e.getMessage());
            e.printStackTrace();
        }
    }
}
