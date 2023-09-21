package MemoiDPAndBackTracking;

import java.util.Scanner;

public class UniquePaths {
    int[][] cache;
    public int uniquePaths(int m, int n) {
        cache=new int[m][n];
        return findAllPossiblePaths(0, 0, m, n,cache);
    }
    public int findAllPossiblePaths(int i, int j, int m, int n, int[][] cache){
        if(i==m || j==n)
            return 0;
        if(i==m-1 && j==n-1)
            return 1;
        if(cache[i][j]!=0)
            return cache[i][j];
        return cache[i][j]=findAllPossiblePaths(i, j+1, m, n, cache)+findAllPossiblePaths(i+1, j, m, n, cache);
    }
    public static void main(String[] args){
        Scanner sc;        
        try{
            sc=new Scanner(System.in);
            System.out.println("Enter M and N values : ");
            int m=sc.nextInt();
            int n=sc.nextInt();
            System.out.println(new UniquePaths().uniquePaths(m, n));
        }
        catch(Exception e){
            System.out.println("Exception occurred : "+e.getMessage());
            e.printStackTrace();
        }
    }
}
