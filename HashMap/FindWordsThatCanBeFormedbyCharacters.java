import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class FindWordsThatCanBeFormedbyCharacters {
    Map<Character, Integer> freqMap, tempMap;
    int totalCharCount=0;
    public FindWordsThatCanBeFormedbyCharacters(){
        freqMap=new HashMap<>();
        tempMap=new HashMap<>();
    }
    public int countCharacters(String[] words, String chars) {
        //Find Frequency of Chars using HashMap
        for(int i=0;i<chars.length();i++){
            freqMap.putIfAbsent(chars.charAt(i), 0);
            freqMap.put(chars.charAt(i), freqMap.get(chars.charAt(i))+1);
        }
        for(int i=0;i<words.length;i++){
            if(this.countFreqOfChars(words[i]))
                totalCharCount+=words[i].length();
            tempMap.clear();
        }
        return totalCharCount;
    }
    public boolean countFreqOfChars(String word){
        for(int i=0;i<word.length();i++){
            tempMap.putIfAbsent(word.charAt(i), 0);
            tempMap.put(word.charAt(i), tempMap.get(word.charAt(i))+1);
        }        
        for(Map.Entry<Character, Integer> entry : tempMap.entrySet()){
            if(freqMap.containsKey(entry.getKey())){
                if(!(entry.getValue()<=freqMap.get(entry.getKey())))
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
            System.out.println("Enter length of Words array : ");
            int length=sc.nextInt();
            words=new String[length];
            for(int i=0;i<length;i++)
                words[i]=sc.useDelimiter("\n").next();
            System.out.println("Enter a String : ");
            String chars=sc.next();
            System.out.println(new FindWordsThatCanBeFormedbyCharacters().countCharacters(words, chars));
        }
        catch(Exception e){
            System.out.println("Exception occurred : "+e.getMessage());
            e.printStackTrace();
        }
    }
}
