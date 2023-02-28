import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class MinimumStepsToMakeAnagram {
    int minStepsCount=0;
    Map<Character, Integer> sMap, tMap;
    public MinimumStepsToMakeAnagram(){
        sMap=new HashMap<>();
        tMap=new HashMap<>();
    }
    public int minSteps(String s, String t) {       
        this.countFrequencyOfChar(s, sMap); 
        this.countFrequencyOfChar(t, tMap);        
        for(Map.Entry<Character, Integer> entry : sMap.entrySet()){
            char getChar=(char) entry.getKey();
            if(tMap.containsKey(getChar)){
                if(sMap.get(getChar)>tMap.get(getChar))
                    minStepsCount+=sMap.get(getChar)-tMap.get(getChar);
            }
            else
                minStepsCount+=sMap.get(getChar);
        }
        return minStepsCount;
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
            System.out.println("Enter S and T values : ");
            String s=sc.next();            
            String t=sc.next();
            System.out.println(new MinimumStepsToMakeAnagram().minSteps(s, t));
        }
        catch(Exception e){
            System.out.println("Exception occurred : "+e.getMessage());
            e.printStackTrace();
        }
    }
}
