package MemoiDPAndBackTracking;

import java.util.Scanner;
import java.util.Set;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public class ConcatenatedWords {
    List<String> result;
    Set<String> set;
    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        result=new LinkedList<>();
        set=new HashSet<>();
        for(int i=0;i<words.length;i++)
            set.add(words[i]);
        for(int i=0;i<words.length;i++){
            String word=words[i];
            if(isConcatenated(word))
                result.add(word);
        }
        return result;
    }
    public boolean isConcatenated(String word){
        for(int i=0;i<word.length();i++){
            String prefix=word.substring(0, i+1);
            String suffix=word.substring(i+1);
            if(set.contains(prefix) && set.contains(suffix) || set.contains(prefix) && isConcatenated(suffix))
                return true;
        }
        return false;
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
            System.out.println(new ConcatenatedWords().findAllConcatenatedWordsInADict(words));
        }
        catch(Exception e){
            System.out.println("Exception occurred : "+e.getMessage());
            e.printStackTrace();
        }
    }
}
