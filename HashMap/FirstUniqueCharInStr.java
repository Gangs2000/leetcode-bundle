import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class FirstUniqueCharInStr {
    Map<Character, Integer> mapper;
    public FirstUniqueCharInStr(){
        mapper=new LinkedHashMap<>();
    }
    public int firstUniqChar(String s) {
        for(int i=0;i<s.length();i++)    
            mapper.put(s.charAt(i), mapper.getOrDefault(s.charAt(i), 0)+1);                              
        return mapper.entrySet().stream().filter(entry->(entry.getValue()==1)).map(entry->s.indexOf(entry.getKey())).min(Integer::compareTo).orElse(-1);
    }
    public static void main(String[] args){
        Scanner sc;
        try{
            sc=new Scanner(System.in);
            System.out.println("Enter S value : ");
            String s=sc.next();
            System.out.println(new FirstUniqueCharInStr().firstUniqChar(s));
        }
        catch(Exception e){
            System.out.println("Exception occurred : "+e.getMessage());
            e.printStackTrace();
        }
    }
}
