import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Scanner;

public class MinimumDeletionstoMakeCharacterFrequenciesUnique {
    int minimumDeletionCount=0;
    Map<Character, Integer> charCount;
    PriorityQueue<List<Object>> priorityQueue, tempPriorityQueue;
    Comparator<List<Object>> comparator;
    public MinimumDeletionstoMakeCharacterFrequenciesUnique(){
        charCount=new HashMap<>();
        comparator=new Comparator<List<Object>>() {
            @Override
            public int compare(List<Object> arg0, List<Object> arg1) {
                if((int) arg0.get(1)==(int) arg1.get(1))
                    return Character.valueOf((char) arg0.get(0)).compareTo(Character.valueOf((char) arg1.get(0)));
                return Integer.valueOf((int) arg0.get(1)).compareTo(Integer.valueOf((int) arg1.get(1)));
            }
        };
        priorityQueue=new PriorityQueue<>(comparator);
        tempPriorityQueue=new PriorityQueue<>(comparator);
    }
    public int minDeletions(String s) {
        for(int i=0;i<s.length();i++){
            if(charCount.containsKey(s.charAt(i))){
                int value=charCount.get(s.charAt(i));
                priorityQueue.remove(List.of(s.charAt(i), value));
                charCount.put(s.charAt(i), value+1);        
                priorityQueue.add(List.of(s.charAt(i), value+1));
            }
            else{
                charCount.put(s.charAt(i), 1);                
                priorityQueue.add(List.of(s.charAt(i), 1));
            }
        }  
        this.iteratePriorityQueueAndDeleteMinValue(priorityQueue);
        return minimumDeletionCount;
    }  
    public void iteratePriorityQueueAndDeleteMinValue(PriorityQueue<List<Object>> priorityQueue){
        //Making PQ no two characters having same frequency count
        while(!priorityQueue.isEmpty()){
            List<Object> polledList=priorityQueue.poll();
            if(!priorityQueue.isEmpty()){
                List<Object> peekList=priorityQueue.peek();
                if((int) polledList.get(1)!=(int) peekList.get(1))
                    tempPriorityQueue.add(polledList);
                else{
                    //Since frequency count is equal..
                    char key=(char) polledList.get(0);
                    int value=(int) polledList.get(1);
                    if(value>0){
                        priorityQueue.add(List.of(key, value-1));
                        //Once value is decreased by -1 check if temp queue is having any data if so move those values to original PQ for next iteration
                        while(!tempPriorityQueue.isEmpty())
                            priorityQueue.add(tempPriorityQueue.poll());
                        minimumDeletionCount++;
                    }                                        
                }
            }   
        }              
    }
    public static void main(String[] args){
        Scanner sc;
        try{
            sc=new Scanner(System.in);
            System.out.println("Enter S value : ");
            String string=sc.next();
            System.out.println(new MinimumDeletionstoMakeCharacterFrequenciesUnique().minDeletions(string));
        }
        catch(Exception e){
            System.out.println("Exception occurred : "+e.getMessage());
            e.printStackTrace();
        }
    }
}
