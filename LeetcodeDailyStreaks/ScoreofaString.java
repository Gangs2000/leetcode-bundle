import java.util.Scanner;

public class ScoreofaString {
    int totalScoreOfStr=0;
    public int scoreOfString(String s) {
        for(int i=0;i<s.length()-1;i++)
            totalScoreOfStr+=Math.abs((byte) s.charAt(i)-(byte) s.charAt(i+1));
        return totalScoreOfStr;
    }
    public static void main(String[] args) {
        Scanner sc;
        try {
            sc=new Scanner(System.in);
            System.out.println("Enter a String : ");
            String s=sc.nextLine();
            System.out.println(new ScoreofaString().scoreOfString(s));
            sc.close();
        } 
        catch (Exception e) {
            System.out.println("Exception occurred : "+e.getMessage());
            e.printStackTrace();
        }
    }
}
