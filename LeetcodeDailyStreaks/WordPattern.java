package LeetcodeDailyStreaks;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class WordPattern {
    Map<Character, String> map;
    public WordPattern(){
        map=new LinkedHashMap<>();
    }
    public boolean wordPattern(String pattern, String s) {
        String[] splitStr=s.split(" ");
        if(pattern.length()!=splitStr.length)
            return false;
        for(int i=0;i<pattern.length();i++){
            if(map.containsKey(pattern.charAt(i))){
                if(map.containsValue(splitStr[i])){
                    if(!map.get(pattern.charAt(i)).equals(splitStr[i]))
                        return false;                    
                }
                else
                    return false;               
            }
            else{   
                if(map.containsValue(splitStr[i]))
                    return false;
                map.put(pattern.charAt(i), splitStr[i]);
            }
        }
        return true;        
    }
    public static void main(String[] args){
        Scanner sc;
        try{
            sc=new Scanner(System.in);
            System.out.println("Enter Pattern and Word s : ");
            String pattern=sc.useDelimiter("\n").next();
            String s=sc.useDelimiter("\n").next();
            System.out.println(new WordPattern().wordPattern(pattern, s));
        }
        catch(Exception e){
            System.out.println("Exception occurred : "+e.getMessage());
            e.printStackTrace();
        }
    }
}
