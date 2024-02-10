import java.util.Scanner;

public class PalindromicSubstrings {
    int palindromicCount=0;
    public int countSubstrings(String s) {
        for(int i=0;i<s.length();i++){
            this.checkIfPalindrome(i, i, s.length(), s);
            this.checkIfPalindrome(i, i+1, s.length(), s);
        }
        return palindromicCount;
    }
    public void checkIfPalindrome(int i, int j, int length, String s){
        while(i>=0 && j<=length-1 && s.charAt(i)==s.charAt(j)){
            palindromicCount++;
            i--; j++;
        }
    }
    public static void main(String[] args){
        Scanner sc;
        try {
            sc=new Scanner(System.in);
            System.out.println("Enter String value : ");
            String string=sc.next();
            System.out.println(new PalindromicSubstrings().countSubstrings(string));
            sc.close();
        } 
        catch (Exception e) {
           System.out.println("Exception occurred : "+e.getMessage());
           e.printStackTrace();
        }
    }
}
