import java.util.Scanner;

public class PerfectSqaures {      
    public int function(int n, int[] memo) {           
        if(n==0)
            return 0;
        if(memo[n]!=0)
            return memo[n];
        int minCount=Integer.MAX_VALUE;
        for(int i=1;i*i<=n;i++){                
            int result=1+function(n-(i*i), memo);                         
            minCount=Math.min(minCount, result);
        }
        return memo[n]=minCount;                     
    }
    public int numSquares(int n) {        
        int[] memo=new int[n+1];
        return this.function(n, memo);
    }
    public static void main(String[] args){
        Scanner sc;
        try{
            sc=new Scanner(System.in);
            System.out.println("Enter a number to perfect squares : ");
            int number=sc.nextInt();
            System.out.println(new PerfectSqaures().numSquares(number));
        }
        catch(Exception e){
            System.out.println("Exception occured : "+e.getMessage());
            e.printStackTrace();
        }
    }
}
