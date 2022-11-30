import java.util.HashMap;
import java.util.Scanner;
import java.util.Map;
import FunctionalInterface.Function;

public class EqualizeFrequency {
    private static boolean isEqualizeFrequency(String str){
        boolean flag=false;  String tempStr="";       
        for(int i=0;i<str.length();i++){            
            if(!str.substring(0,i).equals(""))
                tempStr+=str.substring(0,i);
            if(!str.substring(i+1, str.length()).equals(""))
                tempStr+=str.substring(i+1, str.length());    
            if(EqualizeFrequency.checkEqualizeFrequency(tempStr)){
                flag=true;
                break;
            }
            tempStr="";
        }
        return flag;
    }
    private static boolean checkEqualizeFrequency(String string){        
        Map<Character, Integer> map=new HashMap<>();
        for(int i=0;i<string.length();i++){
            if(map.containsKey(string.charAt(i))){
                int currentCount=map.get(string.charAt(i));
                currentCount++;
                map.put(string.charAt(i), currentCount);
            }
            else
                map.put(string.charAt(i), 0);
        }        
        return (map.values().stream().distinct().count()==1)?(true):(false);        
    }
    public static void main(String[] args){
        Scanner sc;        
        try{
            sc=new Scanner(System.in);
            System.out.println("Enter a String to find out equalize frequency : ");
            String string=sc.next().toLowerCase();                 
            Function<String, Boolean> object=EqualizeFrequency::isEqualizeFrequency;
            if(object.apply(string))
                System.out.println("Given String "+string+" is making equalize frequency");
            else
                System.out.println("Given String "+string+" is not making equalize frequency");      
        }
        catch(Exception e){
            System.out.println("Exception occured : "+e.getMessage());
            e.printStackTrace();
        }
    }
}
