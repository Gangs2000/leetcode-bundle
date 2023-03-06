import java.util.Map;
import java.util.LinkedHashMap;
import java.util.Scanner;
import java.util.TreeMap;

public class SortCharactersByFrequency {
    StringBuilder outputString=new StringBuilder();
    Map<Character,Integer> wordMapper;
    public SortCharactersByFrequency(){
        wordMapper=new LinkedHashMap<>();
    }
    public String frequencySort(String s) {        
        for(int i=0;i<s.length();i++)
            wordMapper.put(s.charAt(i), wordMapper.getOrDefault(s.charAt(i), 0)+1);                                            
        TreeMap<Integer, String> resultMap=new TreeMap<>();      
        for(Map.Entry<Character,Integer> entry : wordMapper.entrySet()){
            if(resultMap.containsKey(entry.getValue()))
                resultMap.put(entry.getValue(), resultMap.get(entry.getValue())+entry.getKey());
            else
                resultMap.put(entry.getValue(), String.valueOf(entry.getKey()));
        }                                   
        for(Map.Entry<Integer, String> entry : resultMap.entrySet()){
            String string=entry.getValue();   
            if(string.length()==1){
                for(int i=0;i<entry.getKey();i++)
                    outputString.append(string.charAt(0));
            }
            else{
                for(int i=0;i<string.length();i++){
                    for(int count=0;count<entry.getKey();count++)
                        outputString.append(string.charAt(i));
                }                    
            }                
        }
        return outputString.reverse().toString();
    }
    public static void main(String[] args){
        Scanner sc;
        try{
            sc=new Scanner(System.in);
            System.out.println("Enter a String to find out frequency : ");
            String string=sc.nextLine();
            System.out.println(new SortCharactersByFrequency().frequencySort(string));
        }
        catch(Exception e){
            System.out.println("Exception occured : "+e.getMessage());
            e.printStackTrace();
        }
    }
}
