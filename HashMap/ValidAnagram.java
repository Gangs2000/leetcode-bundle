import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ValidAnagram {
    Map<Character, Integer> sMap, tMap;
    public ValidAnagram(){
        sMap=new HashMap<>();
        tMap=new HashMap<>();
    }
    public boolean isAnagram(String s, String t) {
        if(s.length()!=t.length())
            return false;
        for(int i=0;i<s.length();i++){
            sMap.put(s.charAt(i), sMap.getOrDefault(s.charAt(i), 0)+1);
            tMap.put(t.charAt(i), tMap.getOrDefault(t.charAt(i), 0)+1);
        }
        for(Map.Entry<Character, Integer> entry : sMap.entrySet()){
            char key=entry.getKey();
            if(tMap.containsKey(key)){
                if(entry.getValue()!=tMap.get(key))
                    return false;
            }
            else
                return false;
        }
        return true;
    }
    public static void main(String[] args){
        Scanner sc;
        try{
            sc=new Scanner(System.in);
            System.out.println("Enter S and T values : ");
            String s=sc.next();
            String t=sc.next();
            System.out.println(new ValidAnagram().isAnagram(s, t));
        }
        catch(Exception e){
            System.out.println("Exception occurred : "+e.getMessage());
            e.printStackTrace();
        }
    }
}
