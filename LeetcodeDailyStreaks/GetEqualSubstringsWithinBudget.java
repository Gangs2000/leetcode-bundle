import java.util.Scanner;

public class GetEqualSubstringsWithinBudget {
    int subStrWithInBudget=Integer.MIN_VALUE;
    public int equalSubstring(String s, String t, int maxCost) {
        int leftPointer=0, rightPointer=0, totalCostTillNow=0;
        while (leftPointer<s.length()) {
            if(leftPointer<s.length()){
                totalCostTillNow+=Math.abs((byte) s.charAt(leftPointer)-(byte) t.charAt(leftPointer));
                if(totalCostTillNow<=maxCost)
                    subStrWithInBudget=Math.max(subStrWithInBudget, (leftPointer-rightPointer)+1);
            }
            while (totalCostTillNow>maxCost && rightPointer<s.length()) {
                totalCostTillNow-=Math.abs((byte) s.charAt(rightPointer)-(byte) t.charAt(rightPointer));
                rightPointer++;
            }
            leftPointer++;
        }
        return (subStrWithInBudget==Integer.MIN_VALUE)?(0):(subStrWithInBudget);   
    }
    public static void main(String[] args) {
        Scanner sc;
        try {
            sc=new Scanner(System.in);
            System.out.println("Enter String values S and T : ");
            String s=sc.useDelimiter("\n").next();
            String t=sc.useDelimiter("\n").next();
            System.out.println("Enter MaxCost value : ");
            int maxCosts=sc.nextInt();
            System.out.println(new GetEqualSubstringsWithinBudget().equalSubstring(s, t, maxCosts));
            sc.close();
        } 
        catch (Exception e) {
            System.out.println("Exception occurred : "+e.getMessage());
            e.printStackTrace();
        }
    }
}
