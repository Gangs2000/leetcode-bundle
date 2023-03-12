package LeetcodeDailyStreaks;

import java.util.Scanner;

public class NumberOfSubStrWithOnes {
    int count=0, total=0;
    public int numSub(String s) {
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='1')
                count++;
            else if(s.charAt(i)=='0'){
                if(count!=0)
                    total+=this.iterateTillZero(count);
                count=0;
            }
        }        
        return (count==0)?(total):(total+this.iterateTillZero(count));        
    }
    public int iterateTillZero(int count){
        int sum=0, mod=1000000007;
        while(count!=0){
            sum=(sum+count)%mod;
            count--;
        }
        return sum;
    }
    public static void main(String[] args){
        Scanner sc;
        try{
            sc=new Scanner(System.in);
            System.out.println("Enter S value : ");
            String s=sc.next();
            System.out.println(new NumberOfSubStrWithOnes().numSub(s));
        }
        catch(Exception e){
            System.out.println("Exception occurred : "+e.getMessage());
            e.printStackTrace();
        }
    }
}
