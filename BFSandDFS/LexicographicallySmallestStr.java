import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class LexicographicallySmallestStr {
    Map<Character, List<Character>> adjacentMap;
    String result="";
    public LexicographicallySmallestStr(){
        adjacentMap=new LinkedHashMap<>();
    }
    public String smallestEquivalentString(String s1, String s2, String baseStr) {
        //Finding Adjacent cells - Edges between one node to another
        for(int i=0;i<s1.length();i++){
            if(adjacentMap.containsKey(s1.charAt(i))){
                List<Character> tempList=adjacentMap.get(s1.charAt(i));
                tempList.add(s2.charAt(i));
                adjacentMap.put(s1.charAt(i), tempList);
            }
            else{
                List<Character> list=new LinkedList<>();
                list.add(s2.charAt(i));
                adjacentMap.put(s1.charAt(i), list);
            }

            if(adjacentMap.containsKey(s2.charAt(i))){
                List<Character> tempList=adjacentMap.get(s2.charAt(i));
                tempList.add(s1.charAt(i));
                adjacentMap.put(s2.charAt(i), tempList);
            }
            else{
                List<Character> list=new LinkedList<>();
                list.add(s1.charAt(i));
                adjacentMap.put(s2.charAt(i), list);
            }
        }
        for(int i=0;i<baseStr.length();i++){            
            Map<Character, Integer> charMapper=new LinkedHashMap<>();
            for(char letter='a'; letter<='z'; letter++)
                charMapper.put(letter, 0);
            if(adjacentMap.containsKey(baseStr.charAt(i)))
                result+=dfsMinChar(adjacentMap, baseStr.charAt(i), charMapper);
            else
                result+=baseStr.charAt(i);
        }
        return result;
    }
    private char dfsMinChar(Map<Character, List<Character>> adjacentMap, char currentChar, Map<Character,Integer> charMapper){
        char minChar=currentChar;
        charMapper.put(currentChar, 1);
        for(char ch : adjacentMap.get(currentChar)){
            if(charMapper.get(ch)==0){
                char newChar=dfsMinChar(adjacentMap, ch, charMapper);
                if(minChar>newChar)
                    minChar=newChar;
            }                
        }
        return minChar;
    }
    public static void main(String[] args){
        Scanner sc;
        try{
            sc=new Scanner(System.in);
            System.out.println("Enter String1 and String2 and baseStr : ");
            String s1=sc.next();
            String s2=sc.next();
            String baseStr=sc.next();
            System.out.println(new LexicographicallySmallestStr().smallestEquivalentString(s1, s2, baseStr));
        }
        catch(Exception e){
            System.out.println("Exception occurred : "+e.getMessage());
            e.printStackTrace();
        }
    }
}
