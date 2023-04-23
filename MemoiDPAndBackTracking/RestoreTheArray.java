package MemoiDPAndBackTracking;

import java.util.Arrays;
import java.util.Scanner;

public class RestoreTheArray {    
    final int MOD=1000000007;
    int[] dp;
    public int numberOfArrays(String s, int k) {    
        dp=new int[100001];
        Arrays.fill(dp, -1);
        return this.splitAndValidate(0, s, k);            
    }
    public int splitAndValidate(int index, String s, int k){                       
        if(index==s.length())
            return 1;
        if(dp[index]!=-1)
            return dp[index];
        int answer=0;
        for(int i=1;i<=s.length();i++){            
            if(index+i<=s.length() && this.isValid(s.substring(index, index+i), k))                           
                answer=answer+(splitAndValidate(index+i, s, k))%MOD;
        }
        return dp[index]=answer;
    }
    public boolean isValid(String subStr, int k){        
        if(subStr.charAt(0)=='0')
            return false;
        else {
            long num=0;
            for(int i=0;i<subStr.length();i++)
                num=num*10+subStr.charAt(i)-'0';
            return (num>=1 && num<=k);
        }        
    }
    public static void main(String[] args){
        Scanner sc;
        try{
            sc=new Scanner(System.in);
            System.out.println("Enter S value : ");
            String s=sc.next();
            System.out.println("Enter K value : ");
            int k=sc.nextInt();
            System.out.println(new RestoreTheArray().numberOfArrays(s, k));
        }
        catch(Exception e){
            System.out.println("Exception occurred : "+e.getMessage());
            e.printStackTrace();
        }
    }
}
