import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Scanner;

public class SortIntegersbyTheNumberof1Bits {
    Map<Integer, PriorityQueue<Integer>> mapper;
    int arraySize=0, index=0;
    int[] resultArray;
    public SortIntegersbyTheNumberof1Bits(){
        mapper=new HashMap<>();
    }
    public int[] sortByBits(int[] arr) {
        for(int i=0;i<arr.length;i++){
            int noOfOnes=this.convertDecimalToBinary(arr[i]);
            PriorityQueue<Integer> priorityQueue;
            if(mapper.containsKey(noOfOnes)){
                priorityQueue=mapper.get(noOfOnes);
                priorityQueue.add(arr[i]);                
            }
            else{
                priorityQueue=new PriorityQueue<>();
                priorityQueue.add(arr[i]);                
            }            
            mapper.put(noOfOnes, priorityQueue);
        }        
        //Find the total size required by calculating the all pq size
        mapper.values().stream().forEach(pq->{arraySize+=pq.size();});
        resultArray=new int[arraySize];
        mapper.keySet().forEach(key->{
            PriorityQueue<Integer> priorityQueue=mapper.get(key);
            while(!priorityQueue.isEmpty())
                resultArray[index++]=priorityQueue.poll();
        });
        return resultArray;
    }
    public int convertDecimalToBinary(int decimal){        
        int noOfOnes=0;
        while(decimal>0){
            if(decimal%2==1)
                noOfOnes++;
            decimal=decimal/2;
        }   
        return noOfOnes;     
    }
    public static void main(String[] args){
        Scanner sc;
        int[] arr;
        try{
            sc=new Scanner(System.in);
            System.out.println("Enter length of array : ");
            int length=sc.nextInt();
            arr=new int[length];
            for(int i=0;i<length;i++)
                arr[i]=sc.nextInt();
            System.out.println(new SortIntegersbyTheNumberof1Bits().sortByBits(arr));       
        }
        catch(Exception e){
            System.out.println("Exception occurred : "+e.getMessage());
            e.printStackTrace();    
        }
    }
}
