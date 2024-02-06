import java.util.Scanner;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class GroupAnagrams {
    Map<String, List<String>> mapper;
    List<List<String>> resultList;
    public GroupAnagrams(){
        mapper=new HashMap<>();
        resultList=new LinkedList<>();
    }
    public List<List<String>> groupAnagrams(String[] strs) {
        for(int i=0;i<strs.length;i++){
            char[] charArray=strs[i].toCharArray();
            Arrays.sort(charArray);
            String sortedString=Arrays.toString(charArray);
            List<String> list;
            if(!mapper.containsKey(sortedString)){
                list=new LinkedList<>();
                list.add(strs[i]);
            }
            else{
                list=mapper.get(sortedString);
                list.add(strs[i]);
            }
            mapper.put(sortedString, list);
        }
        for(Map.Entry<String, List<String>> entry : mapper.entrySet())
            resultList.add(entry.getValue());
        return resultList;
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
            sc.close();
        }
        catch(Exception e){
            System.out.println("Exception occurred : "+e.getMessage());
            e.printStackTrace();
        }
    }
}
