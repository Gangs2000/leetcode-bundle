import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class RestoretheArrayFromAdjacentPairs {
    Map<Integer, List<Integer>> adjacentMap;
    Set<Integer> restoredValues;
    int[] result;    
    int index=0;
    public RestoretheArrayFromAdjacentPairs(){
        adjacentMap=new HashMap<>();
        restoredValues=new LinkedHashSet<>();
    }
    public int[] restoreArray(int[][] adjacentPairs) {
        result=new int[adjacentPairs.length+1];
        //Find Adjcent elements
        for(int i=0;i<adjacentPairs.length;i++){
            findAdjacentPairs(adjacentPairs[i][0], adjacentPairs[i][1]);
            findAdjacentPairs(adjacentPairs[i][1], adjacentPairs[i][0]);
        }    
        //For loop to iterate the map to find out source point    
        for(Map.Entry<Integer, List<Integer>> entry : adjacentMap.entrySet()){
            if(entry.getValue().size()==1){
                depthFirstSearch(entry.getKey());
                break;
            }
        }                
        return result;        
    }
    public void findAdjacentPairs(int key, int value){
        List<Integer> values;
        if(adjacentMap.containsKey(key)){
            values=adjacentMap.get(key);
            values.add(value);
        }
        else{
            values=new LinkedList<>();
            values.add(value);            
        }
        adjacentMap.put(key, values);
    }
    public void depthFirstSearch(int source){
        restoredValues.add(source);
        result[index++]=source;
        if(adjacentMap.containsKey(source)){
            List<Integer> values=adjacentMap.get(source);
            for(int i=0;i<values.size();i++){
                if(!restoredValues.contains(values.get(i)))
                    depthFirstSearch(values.get(i));
            }
        }
    }
    public static void main(String[] args){
        Scanner sc;
        int[][] adjacentPairs;
        try{
            sc=new Scanner(System.in);
            System.out.println("Enter length of adjacent pairs array : ");
            int length=sc.nextInt();
            adjacentPairs=new int[length][2];
            for(int i=0;i<length;i++){
                adjacentPairs[i][0]=sc.nextInt();
                adjacentPairs[i][1]=sc.nextInt();
            }
            System.out.println(new RestoretheArrayFromAdjacentPairs().restoreArray(adjacentPairs));
        }
        catch(Exception e){
            System.out.println("Exception occurred : "+e.getMessage());
            e.printStackTrace();
        }
    }
}
