import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.Set;

public class MinimumNumberofOperationstoMakeArrayContinuous {
    int minOps=0;
    PriorityQueue<Integer> priorityQueue;
    Set<Integer> tracker;
    public MinimumNumberofOperationstoMakeArrayContinuous(){
        priorityQueue=new PriorityQueue<>();
        tracker=new HashSet<>();
    }
    public int minOperations(int[] nums) {
        for(int number : nums)
            priorityQueue.add(number);
        tracker.add(priorityQueue.peek());
        int nextElement=priorityQueue.poll()+1;        
        while(!priorityQueue.isEmpty()){
            int peekElement=priorityQueue.peek();
            if(peekElement!=nextElement && !tracker.contains(nextElement))
                minOps++;
            tracker.add(peekElement);
            priorityQueue.poll();
            nextElement++;
        }        
        return minOps;
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
            System.out.println(new MinimumNumberofOperationstoMakeArrayContinuous().minOperations(nums));
        }
        catch(Exception e){
            System.out.println("Exception occurred : "+e.getMessage());
            e.printStackTrace();
        }
    }
}
