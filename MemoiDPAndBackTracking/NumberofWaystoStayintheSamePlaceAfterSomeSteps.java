package MemoiDPAndBackTracking;

import java.util.Arrays;
import java.util.Scanner;

public class NumberofWaystoStayintheSamePlaceAfterSomeSteps {
    final int MOD=1000000007;
    int[][] cache;
    public int numWays(int steps, int arrLen) {
        cache=new int[steps+1][steps+1];
        Arrays.stream(cache).forEach(array->Arrays.fill(array, -1));
        return findAllPossibilities(arrLen, cache, 0, steps)%MOD;
    }
    public int findAllPossibilities(int arrLen, int [][] cache, int currentIndex, int steps){
        if(steps==0 && currentIndex==0)
            return 1;
        if(steps==0 && currentIndex!=0)
            return 0;
        if(cache[currentIndex][steps]!=-1)
            return cache[currentIndex][steps];
        long stay=findAllPossibilities(arrLen, cache, currentIndex, steps-1);
        long right=0, left=0;
        if(currentIndex>0)
            left=findAllPossibilities(arrLen, cache, currentIndex-1, steps-1);
        if(currentIndex<arrLen-1)
            right=findAllPossibilities(arrLen, cache, currentIndex+1, steps-1);
        return cache[currentIndex][steps]=(int) ((stay+left+right)%MOD);
    }
    public static void main(String[] args){
        Scanner sc;
        try{
            sc=new Scanner(System.in);
            System.out.println("Enter Steps and array Length values : ");
            int steps=sc.nextInt();
            int arrLen=sc.nextInt();
            System.out.println(new NumberofWaystoStayintheSamePlaceAfterSomeSteps().numWays(steps, arrLen));
        }
        catch(Exception e){
            System.out.println("Exception occurred : "+e.getMessage());
            e.printStackTrace();
        }
    }
}
