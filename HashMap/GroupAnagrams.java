import java.util.Scanner;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class GroupAnagrams {
    Map<String, List<String>> map;
    List<List<String>> output;
    public GroupAnagrams(){
        map=new HashMap<>();
        output=new LinkedList<>();
    }
    public List<List<String>> groupAnagrams(String[] strs) {        
        for(int i=0;i<strs.length;i++){
            char[] chars=strs[i].toCharArray();
            Arrays.sort(chars);            
            checkCanStringBeGrouped(String.valueOf(chars), strs[i]);
        }        
        map.values().stream().forEach(list->output.add(list));        
        return output;
    }
    public void checkCanStringBeGrouped(String sortedString, String originalString){
        if(map.containsKey(sortedString)){
            List<String> list=map.get(sortedString);
            list.add(originalString);
            map.put(sortedString, list);
        }
        else{
            List<String> list=new LinkedList<>();
            list.add(originalString);
            map.put(sortedString, list);
        }
    }
    public static void main(String[] args){
        Scanner sc;
        String[] strs;
        try{
            sc=new Scanner(System.in);
            System.out.println("Enter length of Strs array : ");
            int length=sc.nextInt();
            strs=new String[length];
            for(int i=0;i<length;i++)
                strs[i]=sc.next();
            System.out.println(new GroupAnagrams().groupAnagrams(strs));
        }
        catch(Exception e){
            System.out.println("Exception occurred : "+e.getMessage());
            e.printStackTrace();
        }
    }
}
