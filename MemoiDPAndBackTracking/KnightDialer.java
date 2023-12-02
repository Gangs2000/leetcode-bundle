package MemoiDPAndBackTracking;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class KnightDialer {
    Map<Integer, List<Integer>> dialBoard;
    int MOD=(int) (1e9+7), answer=0;
    int[][] memo;
    public KnightDialer(){
        dialBoard=new HashMap<>();
        dialBoard.put(0, List.of(4,6));
        dialBoard.put(1, List.of(6,8));
        dialBoard.put(2, List.of(7,9));
        dialBoard.put(3, List.of(4,8));
        dialBoard.put(4, List.of(0,3,9));
        dialBoard.put(5, List.of());
        dialBoard.put(6, List.of(0,1,7));
        dialBoard.put(7, List.of(2,6));
        dialBoard.put(8, List.of(1,3));
        dialBoard.put(9, List.of(2,4));
    }
    public int knightDialer(int n) {
        memo=new int[n+1][10];
        Arrays.stream(memo).forEach(array->Arrays.fill(array, -1));
        for(int i=0;i<10;i++)
            answer=(answer+dynamicProgramming(n-1, i, memo))%MOD;
        return answer;
    }
    public int dynamicProgramming(int remaining, int currentSquare, int[][] memo){
        if(remaining==0)
            return 1;        
        if(memo[remaining][currentSquare]!=-1)
            return memo[remaining][currentSquare];
        int answer=0;
        for(int nextSquare : dialBoard.get(currentSquare))
            answer=(answer+dynamicProgramming(remaining-1, nextSquare, memo))%MOD;
        return memo[remaining][currentSquare]=answer;
    }
    public static void main(String[] args){
        Scanner sc;
        try{
            sc=new Scanner(System.in);
            System.out.println("Enter N value : ");
            int n=sc.nextInt();
            System.out.println(new KnightDialer().knightDialer(n));
        }
        catch(Exception e){
            System.out.println("Exception occurred : "+e.getMessage());
            e.printStackTrace();
        }
    }
}
