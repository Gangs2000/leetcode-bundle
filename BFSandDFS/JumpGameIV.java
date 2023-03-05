import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class JumpGameIV {
    List<List<Integer>> queue;
    Set<Integer> visited;
    Map<Integer, List<Integer>> mapper;
    public JumpGameIV(){
        queue=new LinkedList<>();
        visited=new HashSet<>();
        mapper=new HashMap<>();
    }
    public int minJumps(int[] arr) {        
        this.findIndiciesOfValues(arr);        
        queue.add(List.of(0,0));        
        while(!queue.isEmpty()){
            int currentIndex=queue.get(0).get(0);
            int steps=queue.get(0).get(1);
            if(currentIndex==arr.length-1)
                return steps;
            if(!visited.contains(currentIndex)){
                visited.add(currentIndex);                
                this.breathFirstSearch(arr, currentIndex, steps);                
            }
            queue.remove(0);            
        }
        return -1;        
    }
    public void breathFirstSearch(int[] arr, int currentIndex, int step){
        int element=arr[currentIndex];
        if(currentIndex-1>=0)
            queue.add(List.of(currentIndex-1, step+1));
        if(currentIndex+1<=arr.length-1)
            queue.add(List.of(currentIndex+1, step+1));
        if(mapper.containsKey(element)){
            List<Integer> indicies=mapper.get(element);
            for(int i : indicies){
                if(!visited.contains(i)){             
                    visited.add(currentIndex);   
                    queue.add(List.of(i, step+1));
                }
            }
        }
        mapper.remove(element);
    }
    public void findIndiciesOfValues(int[] arr){
        for(int i=0;i<arr.length;i++){
            if(mapper.containsKey(arr[i])){
                List<Integer> indicies=mapper.get(arr[i]);
                indicies.add(i);
                mapper.put(arr[i], indicies);
            }
            else{
                List<Integer> indicies=new LinkedList<>();
                indicies.add(i);
                mapper.put(arr[i], indicies);
            }
        }
    }    
    public static void main(String[] args){
        Scanner sc;
        int[] nums;
        try{
            sc=new Scanner(System.in);
            System.out.println("Enter length of nums array : ");
            int length=sc.nextInt();
            nums=new int[length];
            for(int i=0;i<length;i++)
                nums[i]=sc.nextInt();
            System.out.println(new JumpGameIV().minJumps(nums));
        }
        catch(Exception e){
            System.out.println("Exception occurred : "+e.getMessage());
            e.printStackTrace();
        }
    }
}
