import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class MaximumSubSequenceScore {
    PriorityQueue<List<Integer>> priorityQueue;
    public MaximumSubSequenceScore(){
        priorityQueue=new PriorityQueue<>(new Comparator<List<Integer>>() {
            @Override
            public int compare(List<Integer> list1, List<Integer> list2) {
                if(list1.get(0)==list2.get(0))
                    return list2.get(1).compareTo(list1.get(1));
                return list2.get(0).compareTo(list1.get(0));
            }            
        });
    }
    public long maxScore(int[] nums1, int[] nums2, int k) {
        for(int i=0;i<nums1.length;i++)
            priorityQueue.add(List.of(nums2[i], nums1[i]));        
        long sum=0, minVal=Long.MAX_VALUE;
        while(!priorityQueue.isEmpty()){            
            List<Integer> tempList=priorityQueue.poll();                           
            sum+=tempList.get(1);            
            minVal=Math.min(minVal, tempList.get(0));            
        }        
        return sum*minVal;        
    }
    public static void main(String[] args){
        Scanner sc;
        int[] nums1, nums2;
        try{
            sc=new Scanner(System.in);            
            int length=sc.nextInt();
            nums1=new int[length];
            for(int i=0;i<length;i++)
                nums1[i]=sc.nextInt();
            nums2=new int[length];
            for(int i=0;i<length;i++)
                nums2[i]=sc.nextInt();
            System.out.println("Enter K value : ");
            int k=sc.nextInt();
            System.out.println(new MaximumSubSequenceScore().maxScore(nums1, nums2, k));
        }
        catch(Exception e){
            System.out.println("Exception occurred : "+e.getMessage());
            e.printStackTrace();
        }
    }
}