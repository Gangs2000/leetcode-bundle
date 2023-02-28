import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class MinimumStepsToMakeAnagramII {
    int minStepsCount=0;
    Map<Character, Integer> sMap, tMap;
    public MinimumStepsToMakeAnagramII(){
        sMap=new HashMap<>();
        tMap=new HashMap<>();
    }
    public int minSteps(String s, String t) {
        this.countFrequencyOfChar(s, sMap);
        this.countFrequencyOfChar(t, tMap);       
        this.findDifferenceBetweenMaps(sMap, tMap); 
        this.findDifferenceBetweenMaps(tMap, sMap);
        return minStepsCount;
    }
    public void findDifferenceBetweenMaps(Map<Character, Integer> map1, Map<Character, Integer> map2){
        for(Map.Entry<Character, Integer> entry : map1.entrySet()){
            char getChar=entry.getKey();
            if(map2.containsKey(getChar)){
                if(map1.get(getChar)>map2.get(getChar))
                    minStepsCount+=map1.get(getChar)-map2.get(getChar);
            }
            else
                minStepsCount+=map1.get(getChar);
        }        
    }
    public void countFrequencyOfChar(String string, Map<Character, Integer> map){
        for(int i=0;i<string.length();i++){
            if(map.containsKey(string.charAt(i)))
                map.put(string.charAt(i), map.get(string.charAt(i))+1);
            else
                map.put(string.charAt(i), 1);
        }
    }
    public static void main(String[] args){
        Scanner sc;
        try{
            sc=new Scanner(System.in);
            System.out.println("Enter S and T values :");
            String s=sc.next(); 
            String t=sc.next();
            System.out.println(new MinimumStepsToMakeAnagramII().minSteps(s, t));
        }
        catch(Exception e){
            System.out.println("Exception occurred : "+e.getMessage());
            e.printStackTrace();
        }
    }
}
