import java.util.Scanner;
import java.util.Stack;

public class MaximumScoreFromRemovingSubstrings {
    int maximumGain=0;
    Stack<Character> stack;
    public MaximumScoreFromRemovingSubstrings(){
        stack=new Stack<>();
    }
    public int maximumGain(String s, int x, int y) {
        String maxStr=(x>y)?("ab"):("ba");
        String minStr=(x<y)?("ab"):("ba");
        String tempMaxResult=this.removeCharsFromStack(s, maxStr);
        maximumGain+=((s.length()-tempMaxResult.length())/2)*(Math.max(x, y));
        String tempMinResult=this.removeCharsFromStack(tempMaxResult, minStr);
        maximumGain+=((tempMaxResult.length()-tempMinResult.length())/2)*(Math.min(x, y));
        return maximumGain;
    }
    private String removeCharsFromStack(String string, String matachedStr){
        Stack<Character> stack=new Stack<>();
        for(int i=0;i<string.length();i++){
            if(!stack.isEmpty() && string.charAt(i)==matachedStr.charAt(1) && stack.peek()==matachedStr.charAt(0))
                stack.pop();
            else
                stack.push(string.charAt(i));
        }
        StringBuilder tempString=new StringBuilder();
        while (!stack.isEmpty())
            tempString.append(stack.pop());
        return tempString.reverse().toString();
    }
    public static void main(String[] args) {
        Scanner sc;
        try {
            sc=new Scanner(System.in);
            System.out.println("Enter String S value : ");
            String s=sc.nextLine();
            System.out.println("Enter X and Y values : ");
            int x=sc.nextInt();
            int y=sc.nextInt();
            System.out.println(new MaximumScoreFromRemovingSubstrings().maximumGain(s, x, y));
            sc.close();
        } 
        catch (Exception e) {
            System.out.println("Exception occurred : "+e.getMessage());
            e.printStackTrace();
        }
    }
}
