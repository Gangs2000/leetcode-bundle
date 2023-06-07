import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class TimeNeededToInformAllEmployees {    
    Map<Integer, Integer> mapper;
    Map<Integer, List<Integer>> adjMap;
    int getMaxValue=Integer.MIN_VALUE;
    public TimeNeededToInformAllEmployees(){        
        mapper=new HashMap<>();        
        adjMap=new LinkedHashMap<>();
    }
    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        for(int i=0;i<n;i++){                                 
            List<Integer> list=(adjMap.containsKey(manager[i]))?(adjMap.get(manager[i])):(new LinkedList<>());            
            list.add(i);                
            adjMap.put(manager[i], list);
            mapper.put(i, informTime[i]);
        }        
        depthFirstSearch(-1, adjMap, mapper, 0);
        return getMaxValue;
    }
    public void depthFirstSearch(int root, Map<Integer, List<Integer>> adjMap ,Map<Integer, Integer> mapper, int sum){
        if(adjMap.containsKey(root)){
            List<Integer> list=adjMap.get(root);
            for(int child : list)                
                depthFirstSearch(child, adjMap, mapper, sum+mapper.get(child));
        }        
        getMaxValue=Math.max(getMaxValue, sum);
    }
    public static void main(String[] args){
        Scanner sc;
        int[] managers, informTime;
        try{
            sc=new Scanner(System.in);
            System.out.println("Enter number of managers : ");
            int n=sc.nextInt();
            System.out.println("Enter Head Id : ");
            int headId=sc.nextInt();
            managers=new int[n];
            System.out.println("Enter managers array value : ");
            for(int i=0;i<n;i++)
                managers[i]=sc.nextInt();
            informTime=new int[n];
            System.out.println("Enter inform time array value : ");
            for(int i=0;i<n;i++)
                informTime[i]=sc.nextInt();
            System.out.println(new TimeNeededToInformAllEmployees().numOfMinutes(n, headId, managers, informTime));
        }
        catch(Exception e){
            System.out.println("Exception occurred : "+e.getMessage());
            e.printStackTrace();
        }
    }
}