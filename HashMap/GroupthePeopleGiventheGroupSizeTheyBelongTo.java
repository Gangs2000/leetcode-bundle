import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class GroupthePeopleGiventheGroupSizeTheyBelongTo {
    List<List<Integer>> resultList;
    Map<Integer, List<Integer>> mapper;
    public GroupthePeopleGiventheGroupSizeTheyBelongTo(){
        resultList=new LinkedList<>();
        mapper=new HashMap<>();
    }
    public List<List<Integer>> groupThePeople(int[] groupSizes) {
        for(int i=0;i<groupSizes.length;i++){
            if(mapper.containsKey(groupSizes[i])){
                List<Integer> list=mapper.get(groupSizes[i]);
                if(list.size()<groupSizes[i])
                    list.add(i);
                else{                    
                    resultList.add(new LinkedList<>(list));
                    list.clear(); list.add(i);                    
                }
                mapper.put(groupSizes[i], list);
            }
            else{
                List<Integer> list=new LinkedList<>();
                list.add(i);
                mapper.put(groupSizes[i], list);                
            }
        }        
        for(Map.Entry<Integer, List<Integer>> entry : mapper.entrySet())
            resultList.add(new LinkedList<>(mapper.get(entry.getKey())));
        return resultList;
    }
    public static void main(String[] args){
        Scanner sc;
        int[] groupSizes;
        try{
            sc=new Scanner(System.in);
            System.out.println("Enter length of group size array : ");
            int length=sc.nextInt();
            groupSizes=new int[length];
            for(int i=0;i<length;i++)
                groupSizes[i]=sc.nextInt();
            System.out.println(new GroupthePeopleGiventheGroupSizeTheyBelongTo().groupThePeople(groupSizes));
        }
        catch(Exception e){
            System.out.println("Exception occurred : "+e.getMessage());
            e.printStackTrace();
        }
    }
}
