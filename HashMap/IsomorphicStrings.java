import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class IsomorphicStrings {
    Map<Character, Character> charMap;
    public IsomorphicStrings(){
        charMap=new HashMap<>();
    }
    public boolean isIsomorphic(String s, String t) {
        if(s.length()!=t.length())
            return false;
        for(int i=0;i<s.length();i++){
            if(charMap.containsKey(s.charAt(i))){
                if(charMap.get(s.charAt(i))!=t.charAt(i))
                    return false;
            }
            else{
                if(charMap.containsValue(t.charAt(i)))
                    return false;
                charMap.put(s.charAt(i), t.charAt(i));
            }
        }
        return true;
    }
    public static void main(String[] args) {
        Scanner sc;
        try{
            sc=new Scanner(System.in);
            System.out.println("Enter S and T values : ");
            String s=sc.nextLine();
            String t=sc.nextLine();
            System.out.println(new IsomorphicStrings().isIsomorphic(s, t));
            sc.close();
        }
        catch(Exception e){
            System.out.println("Exception occurred : "+e.getMessage());
            e.printStackTrace();
        }
    }
}
