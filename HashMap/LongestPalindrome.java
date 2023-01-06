import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class LongestPalindrome {
    Map<Character, Integer> mapper;
    boolean isOddLength=false;
    int longestCount=0;
    public LongestPalindrome(){
        mapper=new LinkedHashMap<>();
    }
    public int longestPalindrome(String s) {
        for(int i=0;i<s.length();i++)
            mapper.put(s.charAt(i), (mapper.getOrDefault(s.charAt(i), 0))+1);
        for(int value : mapper.values()){
            if(value%2==0)
                longestCount+=value;
            else{
                if(!isOddLength){
                    isOddLength=true;                
                    longestCount+=value;
                }
                else
                    longestCount+=value-1;
            }
        }
        return longestCount;
    }
    public static void main(String[] args){
        Scanner sc;
        try{
            sc=new Scanner(System.in);
            System.out.println("Enter S value to find out longest palindrome : ");
            String string=sc.next();
            System.out.println(new LongestPalindrome().longestPalindrome(string));
        }
        catch(Exception e){
            System.out.println("Exception occurred : "+e.getMessage());
            e.printStackTrace();
        }
    }
}
