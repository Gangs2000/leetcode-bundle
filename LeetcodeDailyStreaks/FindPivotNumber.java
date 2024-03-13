import java.util.Scanner;

public class FindPivotNumber {
    public int pivotInteger(int n) {
        int prefixSum=1, suffixSum=n, lp=2, rp=n-1;
        while(lp<=rp){
            if(prefixSum<=suffixSum){
                if(prefixSum==suffixSum){
                    suffixSum+=rp;
                    rp--;
                }
                prefixSum+=lp;
                lp++;
            }
            else if(prefixSum>suffixSum){
                suffixSum+=rp;
                rp--;
            }
        }
        return (lp-1==rp+1 && prefixSum==suffixSum)?(lp-1):(-1);
    }
    public static void main(String[] args) {
        Scanner sc;
        try{
            sc=new Scanner(System.in);
            System.out.println("Enter N value : ");
            int n=sc.nextInt();
            System.out.println(new FindPivotNumber().pivotInteger(n));
            sc.close();
        }
        catch(Exception e){
            System.out.println("Exception occurred : "+e.getMessage());
            e.printStackTrace();
        }
    }
}
