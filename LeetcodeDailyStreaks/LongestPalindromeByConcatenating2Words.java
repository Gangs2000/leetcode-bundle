package LeetcodeDailyStreaks;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class LongestPalindromeByConcatenating2Words {
    int palindromeLength=0;
    Map<String, Integer> mapper;    
    boolean appendSingleTime=true;
    public LongestPalindromeByConcatenating2Words(){
        mapper=new HashMap<>();
    }
    public int longestPalindrome(String[] words) {
        for(int i=0;i<words.length;i++){
            if(mapper.containsKey(words[i]))
                mapper.put(words[i], mapper.get(words[i])+2);
            else
                mapper.put(words[i], 2);
        }        
        while(!mapper.isEmpty()){            
            String key=mapper.entrySet().stream().findFirst().get().getKey();            
            if(key.charAt(0)==key.charAt(1)){
                if(mapper.get(key)%4==2 && appendSingleTime){
                    palindromeLength+=2;
                    appendSingleTime=false;
                }                
                palindromeLength+=mapper.get(key)-(mapper.get(key)%4);                                        
            }
            else if(key.charAt(0)!=key.charAt(1)){
                String reverseKey=new StringBuilder(key).reverse().toString();
                if(mapper.containsKey(reverseKey)){
                    palindromeLength+=Math.min(mapper.get(key), mapper.get(reverseKey))*2;                                        
                    mapper.remove(reverseKey);
                }                   
            }            
            mapper.remove(key);            
        }
        return palindromeLength;
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
            System.out.println(new LongestPalindromeByConcatenating2Words().longestPalindrome(words));
        }
        catch(Exception e){
            System.out.println("Exception occurred : "+e.getMessage());
            e.printStackTrace();
        }
    }
}
