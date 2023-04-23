package MemoiDPAndBackTracking;

import java.util.Arrays;
import java.util.Scanner;

public class ProfitableSchemes {
    int[][][] dp;
    final int MOD=1000000007;
    public ProfitableSchemes(){
        dp=new int[101][101][101];
    }
    public int profitableSchemes(int n, int minProfit, int[] group, int[] profit) {       
        Arrays.stream(dp).forEach(array->Arrays.stream(array).forEach(fill->Arrays.fill(fill, -1))); 
        return this.traverseAllPossibilites(0, 0, 0, n, minProfit, group, profit);
    }
    public int traverseAllPossibilites(int memberSelected, int currentProfit, int index, int n, int minProfit, int[] group, int[] profit){
        if(index>=group.length)
            return (currentProfit>=minProfit)?(1):(0);
        if(dp[index][memberSelected][currentProfit]!=-1)
            return dp[index][memberSelected][currentProfit];
        int notPick=traverseAllPossibilites(memberSelected, currentProfit, index+1, n, minProfit, group, profit);
        int pick=0;
        if(memberSelected+group[index]<=n)
            pick+=traverseAllPossibilites(memberSelected+group[index], Math.min(minProfit, currentProfit+profit[index]), index+1, n, minProfit, group, profit);
        return dp[index][memberSelected][currentProfit]=(notPick%MOD + pick%MOD)%MOD;
    }
    public static void main(String[] args){
        Scanner sc;
        int[] groups, profits;
        try{
            sc=new Scanner(System.in);
            System.out.println("Enter number of people : ");
            int n=sc.nextInt();
            System.out.println("Enter Minimum profit value : ");
            int minProfit=sc.nextInt();
            System.out.println("Enter group and profit arrays length : ");
            int length=sc.nextInt();
            groups=new int[length];
            profits=new int[length];
            for(int i=0;i<length;i++){
                groups[i]=sc.nextInt();
                profits[i]=sc.nextInt();
            }            
            System.out.println(new ProfitableSchemes().profitableSchemes(n, minProfit, groups, profits));
        }
        catch(Exception e){
            System.out.println("Exception occurred : "+e.getMessage());
            e.printStackTrace();
        }
    }
}
