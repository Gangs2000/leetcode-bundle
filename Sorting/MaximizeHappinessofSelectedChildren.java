import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class MaximizeHappinessofSelectedChildren {
    long maximumHappinessSum=0; int valueToBeSubtracted=0;
    PriorityQueue<Long> priorityQueue;
    public MaximizeHappinessofSelectedChildren(){
        priorityQueue=new PriorityQueue<>(new Comparator<Long>() {
            @Override
            public int compare(Long o1, Long o2) {
                return o2.compareTo(o1);
            }
        });
    }
    public long maximumHappinessSum(int[] happiness, int k) {
        this.putValuesInHeapQueue(happiness);
        while(k>0){
            long value=priorityQueue.poll()-valueToBeSubtracted;
            maximumHappinessSum+=(value>0)?(value):(0);
            valueToBeSubtracted++;
            k--;
        }
        return maximumHappinessSum;
    }
    private void putValuesInHeapQueue(int[] happiness){
        for(int happy : happiness)
            priorityQueue.add(Long.valueOf(happy));
    }
    public static void main(String[] args) {
        Scanner sc;
        int[] happines;
        try{
            sc=new Scanner(System.in);
            System.out.println("Enter length of happiness array : ");
            int length=sc.nextInt();
            happines=new int[length];
            for(int i=0;i<length;i++)
                happines[i]=sc.nextInt();
            System.out.println("Enter K value : ");
            int k=sc.nextInt();
            System.out.println(new MaximizeHappinessofSelectedChildren().maximumHappinessSum(happines, k));
            sc.close();
        }
        catch(Exception e){
            System.out.println("Exception occurred : "+e.getMessage());
            e.printStackTrace();
        }
    }
}
