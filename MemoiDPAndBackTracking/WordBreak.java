package MemoiDPAndBackTracking;

import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class WordBreak {
    Map<String, Boolean> cache;
    public boolean wordBreak(String s, List<String> wordDict) {
        cache=new LinkedHashMap<>();
        if(wordDict.contains(s))
            return true;
        return canBeBroken(s, wordDict);
    }
    public boolean canBeBroken(String word, List<String> wordDict){
        if(cache.containsKey(word))
            return cache.get(word);
        for(int i=0;i<word.length();i++){
            String prefix=word.substring(0, i+1);
            String suffix=word.substring(i+1);
            if(wordDict.contains(prefix) && wordDict.contains(suffix) || wordDict.contains(prefix) && canBeBroken(suffix, wordDict)){
                cache.put(word, true);
                return true;
            }
        }
        cache.put(word, false);
        return false;
    }
    public static void main(String[] args){
        Scanner sc;
        List<String> wordDict;
        try{
            sc=new Scanner(System.in);
            System.out.println("Enter a String to break : ");
            String string=sc.next();
            System.out.println("Enter length of word dictionary : ");
            int length=sc.nextInt();
            wordDict=new LinkedList<>();
            for(int i=0;i<length;i++)
                wordDict.add(sc.next());
            System.out.println(new WordBreak().wordBreak(string, wordDict));
        }
        catch(Exception e){
            System.out.println("Exception occurred : "+e.getMessage());
            e.printStackTrace();
        }
    }
}
