import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class DetermineIfTwoStringsAreClose {
    Map<Character,Integer> word1Map,word2Map;    
    public DetermineIfTwoStringsAreClose(){
        word1Map=new LinkedHashMap<>();
        word2Map=new LinkedHashMap<>();        
    }
    public boolean closeStrings(String word1, String word2) {
        if(word1.length()!=word2.length())
            return false;
        else{
            for(int i=0;i<word1.length();i++){
                //Collecting each charater count details for word1
                if(word1Map.containsKey(word1.charAt(i)))
                    word1Map.put(word1.charAt(i), word1Map.get(word1.charAt(i))+1);
                else
                    word1Map.put(word1.charAt(i), 1);

                //Collecting each charater count details for word2
                if(word2Map.containsKey(word2.charAt(i)))
                    word2Map.put(word2.charAt(i), word2Map.get(word2.charAt(i))+1);
                else
                    word2Map.put(word2.charAt(i), 1);
            }                               
            return word1Map.keySet().containsAll(word2Map.keySet()) 
                && word1Map.values().stream().sorted().collect(Collectors.toList()).equals(word2Map.values().stream().sorted().collect(Collectors.toList()));
        }
    }
    public static void main(String[] args){
        Scanner sc;
        try{
            sc=new Scanner(System.in);
            System.out.println("Enter word1 and word2 to find those are close : ");
            String word1=sc.next();
            String word2=sc.next();
            System.out.println(new DetermineIfTwoStringsAreClose().closeStrings(word1, word2));
        }
        catch(Exception e){
            System.out.println("Exception occured : "+e.getMessage());
            e.printStackTrace();
        }
    }
}
