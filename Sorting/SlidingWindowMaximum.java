import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class SlidingWindowMaximum {
    int[] result;
    int arrIndex=0, windowCount=0;
    PriorityQueue<Integer> maxHeap;
    boolean isThisFirstWindow=true;
    public SlidingWindowMaximum(){
        maxHeap=new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer a, Integer b) {                
                return b.compareTo(a);
            }            
        });
    }
    public int[] maxSlidingWindow(int[] nums, int k) {
        result=new int[(nums.length)-(k-1)];
        int index=0;
        while(index<nums.length){            
            if(isThisFirstWindow){
                isThisFirstWindow=false;
                while(index<k)
                    maxHeap.add(nums[index++]);                                    
            }
            else
                maxHeap.add(nums[index++]);                                                     
            result[arrIndex++]=maxHeap.peek();     
            maxHeap.remove(nums[windowCount++]);
        }
        return result;
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
            System.out.println("Enter K value : ");
            int k=sc.nextInt();
            System.out.println(new SlidingWindowMaximum().maxSlidingWindow(nums, k));
        }
        catch(Exception e){
            System.out.println("Exception occurred : "+e.getMessage());
            e.printStackTrace();
        }
    }
}
