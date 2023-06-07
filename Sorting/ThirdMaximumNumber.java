import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class ThirdMaximumNumber {
    PriorityQueue<Integer> priorityQueue;
    int count=3, currMax=0, max=0;
    boolean flag=true;
    public ThirdMaximumNumber(){
        priorityQueue=new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer a, Integer b) {                
                return b.compareTo(a);
            }            
        });
    }
    public int thirdMax(int[] nums) {        
        for(int number : nums)
            priorityQueue.add(number);
        if(priorityQueue.size()<3)
            return priorityQueue.poll();
        while(count!=0 && priorityQueue.size()!=0){
            if(flag){
                flag=false; count--;
                max=priorityQueue.peek();                
            }            
            else if(currMax!=priorityQueue.peek())
                count--;                
            currMax=priorityQueue.poll();
        }
        return (count==0)?(currMax):(max);
    }
    public static void main(String[] args){
        Scanner sc;
        int[] array;
        try{
            sc=new Scanner(System.in);
            System.out.println("Enter length of an array : ");
            int length=sc.nextInt();
            array=new int[length];
            for(int i=0;i<length;i++)
                array[i]=sc.nextInt();

        }   
        catch(Exception e){
            System.out.println("Exception occurred : "+e.getMessage());
            e.printStackTrace();
        }
    }
}
