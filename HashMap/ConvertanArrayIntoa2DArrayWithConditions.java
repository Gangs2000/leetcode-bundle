import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Scanner;

public class ConvertanArrayIntoa2DArrayWithConditions {
    List<List<Integer>> resultList;
    Comparator<List<Integer>> comparator;
    PriorityQueue<List<Integer>> priorityQueue1, priorityQueue2;
    Map<Integer, Integer> map;
    int count=0;
    public ConvertanArrayIntoa2DArrayWithConditions(){
        resultList=new LinkedList<>();
        comparator=new Comparator<List<Integer>>() {
            @Override
            public int compare(List<Integer> arg0, List<Integer> arg1) {
                if(arg0.get(1)==arg1.get(1))
                    return arg1.get(0).compareTo(arg0.get(0));
                return arg1.get(1).compareTo(arg0.get(1));
            }            
        };
        priorityQueue1=new PriorityQueue<>(comparator);
        priorityQueue2=new PriorityQueue<>(comparator);
        map=new HashMap<>();
    }
    public List<List<Integer>> findMatrix(int[] nums) {      
        countFreqAndPutItInQueue(nums);
        boolean flag=true;    
        while(count<nums.length){
            if(flag)
                addElementsToList(priorityQueue1, priorityQueue2);                
            else
                addElementsToList(priorityQueue2, priorityQueue1);
            flag=(flag)?(false):(true);
        }            
        return resultList;
    }
    public void countFreqAndPutItInQueue(int[] nums){
        for(int i=0;i<nums.length;i++){
            if(!map.containsKey(nums[i])){
                map.put(nums[i], 1);
                priorityQueue1.add(List.of(nums[i], 1));
            }
            else{
                int getValue=map.get(nums[i]);
                map.put(nums[i], getValue+1);
                priorityQueue1.remove(List.of(nums[i], getValue));
                priorityQueue1.add(List.of(nums[i], getValue+1));
            }                        
        }
    }
    public void addElementsToList(PriorityQueue<List<Integer>> originalQueue, PriorityQueue<List<Integer>> copyQueue){
        List<Integer> result=new LinkedList<>();
        while(!originalQueue.isEmpty()){
            List<Integer> list=originalQueue.poll();            
            result.add(list.get(0));
            count++;
            if((list.get(1)-1)!=0)
                copyQueue.add(List.of(list.get(0), list.get(1)-1));
        }
        resultList.add(result);
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
            System.out.println(new ConvertanArrayIntoa2DArrayWithConditions().findMatrix(nums));
        }
        catch(Exception e){
            System.out.println("Exception occurred : "+e.getMessage());
            e.printStackTrace();
        }
    }
}
