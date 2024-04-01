import java.util.Scanner;

public class LengthofLastWord {
    public int lengthOfLastWord(String s) {
        String lastWord=s.split(" ")[s.split(" ").length-1];
        return lastWord.trim().length();
    }
    public static void main(String[] args) {
        Scanner sc;
        try {
            sc=new Scanner(System.in);
            System.out.println("Enter String value : ");
            String s=sc.nextLine();
            System.out.println(new LengthofLastWord().lengthOfLastWord(s));
            sc.close();
        } 
        catch (Exception e) {
            System.out.println("Exception occurred : "+e.getMessage());
            e.printStackTrace();
        }
    }
}
