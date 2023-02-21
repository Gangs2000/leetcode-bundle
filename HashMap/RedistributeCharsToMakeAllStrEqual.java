import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class RedistributeCharsToMakeAllStrEqual {
    Map<Character, Integer> mapper;
    public RedistributeCharsToMakeAllStrEqual(){
        mapper=new HashMap<>();
    }
    public boolean makeEqual(String[] words) {        
        for(int i=0;i<words.length;i++){
            String word=words[i];            
            for(int j=0;j<word.length();j++){
                if(mapper.containsKey(word.charAt(j)))
                    mapper.put(word.charAt(j), mapper.get(word.charAt(j))+1);
                else
                    mapper.put(word.charAt(j), 1);
            }                          
        }        
        for(Map.Entry<Character, Integer> entry : mapper.entrySet()){
            if((int) entry.getValue()%words.length!=0)
                return false;
        }
        return true;
    }
    public static void main(String[] args){
        Scanner sc;
        String[] words;
        try{
            sc=new Scanner(System.in);
            System.out.println("Enter length of words array : ");
            int length=sc.nextInt();
            words=new String[length];
            for(int i=0;i<length;i++)
                words[i]=sc.next();
            System.out.println(new RedistributeCharsToMakeAllStrEqual().makeEqual(words));
        }
        catch(Exception e){
            System.out.println("Exception occurred : "+e.getMessage());
            e.printStackTrace();
        }
    }
}
