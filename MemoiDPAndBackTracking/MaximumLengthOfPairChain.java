package MemoiDPAndBackTracking;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class MaximumLengthOfPairChain {
    int[][] cache;
    public int findLongestChain(int[][] pairs) {
        cache=new int[pairs.length][pairs.length+1];
        Arrays.stream(cache).forEach(pair->Arrays.fill(pair, -1));
        Comparator<int[]> comparator=new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {                
                return (a[0]<b[0])?(-1):(1);
            }            
        };
        Arrays.sort(pairs, comparator);        
        return findMaxLengthPairs(0, -1, pairs, cache);
    }
    public int findMaxLengthPairs(int index, int prev, int[][] pairs, int[][] cache){
        if(index==pairs.length)
            return 0;
        if(cache[index][prev+1]!=-1)
            return cache[index][prev+1];
        int notTake=0+findMaxLengthPairs(index+1, prev, pairs, cache);
        int take=0;
        if(prev==-1 || pairs[prev][1]<pairs[index][0])
            take=1+findMaxLengthPairs(index+1, index, pairs, cache);
        return cache[index][prev+1]=Math.max(notTake, take);
    }
    public static void main(String[] args){
        Scanner sc;
        int[][] pairs;
        try{
            sc=new Scanner(System.in);
            System.out.println("Enter length of pairs array : ");
            int length=sc.nextInt();
            pairs=new int[length][2];
            for(int i=0;i<length;i++){
                pairs[i][0]=sc.nextInt();
                pairs[i][1]=sc.nextInt();
            }
            System.out.println(new MaximumLengthOfPairChain().findLongestChain(pairs));
        }
        catch(Exception e){
            System.out.println("Exception occurred : "+e.getMessage());
            e.printStackTrace();
        }
    }
}
