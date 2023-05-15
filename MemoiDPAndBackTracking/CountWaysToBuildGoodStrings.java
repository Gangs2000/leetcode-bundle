package MemoiDPAndBackTracking;

import java.util.Arrays;
import java.util.Scanner;

public class CountWaysToBuildGoodStrings {
    final int MOD=1000000007;
    int[] cache;
    public int countGoodStrings(int low, int high, int zero, int one) {        
        cache=new int[high+1];
        Arrays.fill(cache, -1);
        return getGoodStrings(cache, low, high, zero, one, 0);        
    }
    public int getGoodStrings(int[] cache, int low, int high, int zero, int one, int currentLength){
        if(currentLength>high)
            return 0;
        if(cache[currentLength]!=-1)
            return cache[currentLength];
        cache[currentLength]=(currentLength>=low && currentLength<=high)?(1):(0);
        cache[currentLength]=(cache[currentLength]+getGoodStrings(cache, low, high, zero, one, currentLength+zero))%MOD;
        cache[currentLength]=(cache[currentLength]+getGoodStrings(cache, low, high, zero, one, currentLength+one))%MOD;
        return cache[currentLength];
    }
    public static void main(String[] args){
        Scanner sc;
        try{
            sc=new Scanner(System.in);
            System.out.println("Enter Low, High, Zero and One values : ");
            int low=sc.nextInt();
            int high=sc.nextInt();
            int zero=sc.nextInt();
            int one=sc.nextInt();
            System.out.println(new CountWaysToBuildGoodStrings().countGoodStrings(low, high, zero, one));
        }
        catch(Exception e){
            System.out.println("Exception occurred : "+e.getMessage());
            e.printStackTrace();
        }
    }
}
