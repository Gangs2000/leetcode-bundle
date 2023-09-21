import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class BuddyStrings {
    Map<Character, Integer> sMap, goalMap;
    public BuddyStrings(){
        sMap=new HashMap<>();
        goalMap=new HashMap<>();
    }
    public boolean buddyStrings(String s, String goal) {
        //Check both String lengths are equal..
        if(s.length()==goal.length()){
            //Find Frequency of all characters from S and Goal..
            for(int i=0;i<s.length();i++){                
                sMap.putIfAbsent(s.charAt(i), 0);
                sMap.put(s.charAt(i), sMap.get(s.charAt(i))+1);
                goalMap.putIfAbsent(goal.charAt(i), 0);
                goalMap.put(goal.charAt(i), goalMap.get(goal.charAt(i))+1);
            }
            //Check if both strings are equal..
            if(s.equals(goal)){                
                //Check if frequency of any character is greater than 1
                for(Map.Entry<Character, Integer> entry : sMap.entrySet()){
                    if((int) entry.getValue()>1)
                        return true;
                }
                return false;
            }
            else{
                int mismatchCount=0;
                //Check all characters occurred in goal string and frequency of characters for both strings are same..
                for(Map.Entry<Character, Integer> entry : sMap.entrySet()){
                    char currentKey=(char) entry.getKey();
                    int currentValue=(int) entry.getValue();
                    if(!((goalMap.containsKey(currentKey)) && (goalMap.get(currentKey))==currentValue))
                        return false;
                }                
                //Count mismatch characters count
                for(int i=0;i<s.length();i++){
                    if(s.charAt(i)!=goal.charAt(i))
                        mismatchCount++;
                }
                //Return true if mismatch count is equal to 2, else false
                return (mismatchCount==2)?(true):(false);
            }
        }
        return false;
    }
    public static void main(String[] args){
        Scanner sc;
        try{
            sc=new Scanner(System.in);
            System.out.println("Enter S and Goal values : ");
            String s=sc.useDelimiter("\n").next();
            String goal=sc.useDelimiter("\n").next();
            System.out.println(new BuddyStrings().buddyStrings(s, goal));
        }
        catch(Exception e){
            System.out.println("Exception occurred : "+e.getMessage());
            e.printStackTrace();
        }
    }
}
