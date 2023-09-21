import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class FindResultantArrayAfterRemovingAnagrams {
    List<String> resultList;
    Map<Character, Integer> map1, map2;
    Map<String, Integer> anagramMap;
    public FindResultantArrayAfterRemovingAnagrams(){
        resultList=new LinkedList<>();
        map1=new HashMap<>();
        map2=new HashMap<>();
        anagramMap=new HashMap<>();
    }
    public List<String> removeAnagrams(String[] words) {
        if(words.length==1){
            resultList.add(words[0]);
            return resultList;
        }            
        for(int i=1;i<words.length;i++){
            char[] chars=words[i-1].toCharArray();
            Arrays.sort(chars);                    
            String sortedWord=String.valueOf(chars);
            if(words[i].length()==words[i-1].length()){
                String word1=words[i-1];
                String word2=words[i];
                for(int k=0;k<word1.length();k++){
                    countCharacterFrequency(word1.charAt(k), map1);
                    countCharacterFrequency(word2.charAt(k), map2);                    
                }
                if(checkMap(map1, map2)){                    
                    if(!anagramMap.containsKey(sortedWord)){
                        anagramMap.put(sortedWord, 1);
                        resultList.add(words[i-1]);
                    }
                }
                else {                                        
                    if(!anagramMap.containsKey(sortedWord))                        
                        resultList.add(words[i-1]);
                    if(i==words.length-1)
                        resultList.add(words[i]);
                }
            }
            else{                
                if(!anagramMap.containsKey(sortedWord))
                    resultList.add(words[i-1]);
                if(i==words.length-1)
                    resultList.add(words[i]);
            }
            map1.clear(); map2.clear();
        }
        return resultList;
    }
    public void countCharacterFrequency(char character, Map<Character, Integer> map){
        map.putIfAbsent(character, 1);
        map.put(character, map.get(character)+1);
    }
    public boolean checkMap(Map<Character, Integer> map1, Map<Character, Integer> map2){
        for(Map.Entry<Character, Integer> entry : map1.entrySet()){
            char key=(char) entry.getKey();
            int value=(int) entry.getValue();
            if(map2.containsKey(key)){
                if(map2.get(key)!=value)
                    return false;
            }
            else
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
                words[i]=sc.useDelimiter("\n").next();
            System.out.println(new FindResultantArrayAfterRemovingAnagrams().removeAnagrams(words));
        }
        catch(Exception e){
            System.out.println("Exception occurred : "+e.getMessage());
            e.printStackTrace();
        }
    }
}
