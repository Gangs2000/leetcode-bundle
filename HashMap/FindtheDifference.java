import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class FindtheDifference {
    Map<Character, Integer> sMap, tMap;    
    char missingChar;
    public FindtheDifference(){
        sMap=new HashMap<>();
        tMap=new HashMap<>();
    }
    public char findTheDifference(String s, String t) {
        this.countFrequencyOfChar(s, sMap);
        this.countFrequencyOfChar(t, tMap);
        for(Map.Entry<Character, Integer> entry : tMap.entrySet()){
            char key=(char) entry.getKey();            
            if(sMap.containsKey(key)){
                if(sMap.get(key)!=tMap.get(key)){
                    missingChar=key;
                    break;
                }
            }
            else{
                missingChar=key;
                break;
            }
        }             
        return missingChar;   
    }
    public void countFrequencyOfChar(String string, Map<Character, Integer> mapper){
        for(int i=0;i<string.length();i++){
            mapper.putIfAbsent(string.charAt(i), 0);
            mapper.put(string.charAt(i), mapper.get(string.charAt(i))+1);
        }
    }
    public static void main(String[] args){
        Scanner sc;
        try{
            sc=new Scanner(System.in);
            System.out.println("Enter S and T values : ");
            String s=sc.useDelimiter("\n").next();
            String t=sc.useDelimiter("\n").next();
            System.out.println(new FindtheDifference().findTheDifference(s, t));
        }
        catch(Exception e){
            System.out.println("Exception occurred : "+e.getMessage());
            e.printStackTrace();    
        }
    }
}
