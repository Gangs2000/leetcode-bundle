import java.util.Scanner;

public class VerifyingAnAlieanDictionary {   
    public boolean isGreater(String s1, String s2, String order){
        int end=(s1.length()<s2.length())?(s1.length()):(s2.length()), start=0;        
        while(start<end){
            if(s1.charAt(start)!=s2.charAt(start))
                return order.indexOf(s1.charAt(start))<=order.indexOf(s2.charAt(start));
            start++;
        }
        return (s1.length()==start)?(true):(false);        
    } 
    public boolean isAlienSorted(String[] words, String order) {
        for(int i=1;i<words.length;i++){
            if(!(isGreater(words[i-1], words[i], order)))
                return false;
        }
        return true;
    }
    public static void main(String[] args){
        Scanner sc;
        String[] words;
        try{
            sc=new Scanner(System.in);
            System.out.println("Enter length of words array : ");
            int length=sc.nextInt();
            words=new String[length];
            for(int i=0;i<length;i++)
                words[i]=sc.next();
            System.out.println("Enter Order value : ");
            String order=sc.next();
            System.out.println(new VerifyingAnAlieanDictionary().isAlienSorted(words, order));
        }
        catch(Exception e){
            System.out.println("Exception occurred : "+e.getMessage());
            e.printStackTrace();
        }
    }
}
