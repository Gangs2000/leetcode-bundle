import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import FunctionalInterface.BiFunction;

public class ShortestCompletingWord {
    static Map<Character, Integer> mapper=new HashMap<>();
    private static String shortestWord(Map<Character, Integer> mapChars, List<String> words){
        String output="";        
        for(int i=0;i<words.size();i++){
            mapper=ShortestCompletingWord.duplicateMap(mapChars);
            String word=words.get(i);
            for(int j=0;j<word.length();j++){
                if(mapper.containsKey(word.charAt(j))){
                    int value=mapper.get(word.charAt(j)); value--;              
                    if(value==0)
                        mapper.remove(word.charAt(j));
                    else
                        mapper.put(word.charAt(j), value);                         
                }               
            }                
            if(mapper.size()==0){
                if(output.length()==0)
                    output=word;
                else if(word.length()<output.length())
                    output=word;
            }
            mapper.clear();
        }
        return output;
    }
    private static Map<Character, Integer> duplicateMap(Map<Character, Integer> mapChars){
        Map<Character, Integer> tempChars=new HashMap<>();
        mapChars.entrySet().stream().forEach(entry->{
            tempChars.put(entry.getKey(), entry.getValue());
        });
        return tempChars;
    }
    public static void main(String[] args){
        Scanner sc;        
        List<String> words;
        Map<Character, Integer> mapChars;
        try{
            sc=new Scanner(System.in);
            words=new LinkedList<>();
            mapChars=new HashMap<>();
            System.out.println("Enter the license plate value : ");
            String licensePlate=sc.nextLine().toLowerCase();
            System.out.println("Enter length of the list : ");
            int length=sc.nextInt();
            for(int i=0;i<length;i++)
                words.add(sc.next());
            for(int i=0;i<licensePlate.length();i++){
                if(Character.isLetter(licensePlate.charAt(i))){
                    if(mapChars.containsKey(licensePlate.charAt(i))){
                        int currentCount=mapChars.get(licensePlate.charAt(i));
                        currentCount++;
                        mapChars.put(licensePlate.charAt(i), currentCount);
                    }
                    else
                        mapChars.put(licensePlate.charAt(i), 1);
                }
            }  
            BiFunction<Map<Character, Integer>,List<String>, String> functionalObject=ShortestCompletingWord::shortestWord;
            System.out.println("Shortest completing words is "+functionalObject.apply(mapChars, words));
        }
        catch(Exception e){
            System.out.println("Exception occured : "+e.getMessage());
            e.printStackTrace();
        }
    }
}
