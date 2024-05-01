import java.util.Scanner;

public class ReversePrefixofWord {
    public String reversePrefix(String word, char ch) {
        if(word.indexOf(ch)==-1)
            return word;
        int indexValue=word.indexOf(ch)+1;
        StringBuilder prefixString=new StringBuilder(word.substring(0, indexValue));
        return prefixString.reverse().toString()+word.substring(indexValue, word.length());
    }
    public static void main(String[] args) {
        Scanner sc;
        try {
            sc=new Scanner(System.in);
            System.out.println("Enter a Word : ");
            String word=sc.next();
            System.out.println("Enter a character to find it in word : ");
            char ch=sc.next().charAt(0);
            System.out.println(new ReversePrefixofWord().reversePrefix(word, ch));
            sc.close();
        } 
        catch (Exception e) {
            System.out.println("Exception occurred : "+e.getMessage());
            e.printStackTrace();
        }
    }
}
