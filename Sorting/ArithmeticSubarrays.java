import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class ArithmeticSubarrays {
    List<Boolean> resultList;
    PriorityQueue<Integer> priorityQueue;
    public ArithmeticSubarrays(){
        resultList=new LinkedList<>();
        //Priority Queue Elements to be sorted in descending order
        priorityQueue=new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer arg0, Integer arg1) {
                return arg1.compareTo(arg0);
            }            
        });
    }
    public List<Boolean> checkArithmeticSubarrays(int[] nums, int[] l, int[] r) {
        for(int i=0;i<l.length;i++){
            int leftPointer=l[i];
            int rightPointer=r[i];
            //Separate method to put element from and to range and validating arithmatic sequence between elements
            if(this.addElementsAndValidateArithMeticSubArray(leftPointer, rightPointer, nums))
                resultList.add(true);
            else
                resultList.add(false);
            priorityQueue.clear();
        }
        return resultList;
    }
    public boolean addElementsAndValidateArithMeticSubArray(int lp, int rp, int[] nums){
        //Inserting elements nums range(from, to) into priorityqueue and PQ will sort it in Descending order
        for(int i=lp;i<=rp;i++)
            priorityQueue.add(nums[i]);
        int peekElement=priorityQueue.poll();
        int difference=peekElement-priorityQueue.peek();
        //Validating arithmatic sequence between elements
        while(!priorityQueue.isEmpty()){
            peekElement=priorityQueue.poll();
            if(!priorityQueue.isEmpty()){
                if(peekElement-priorityQueue.peek()!=difference)
                    return false;
            }
        }
        return true;
    }
    public static void main(String[] args){
        Scanner sc;
        int[] nums, left, right;
        try{
            sc=new Scanner(System.in);
            System.out.println("Enter length of nums array : ");
            int n=sc.nextInt();
            nums=new int[n];
            for(int i=0;i<n;i++)
                nums[i]=sc.nextInt();            
            System.out.println("Enter L and R length : ");
            int l=sc.nextInt();
            left=new int[l];
            int r=sc.nextInt();
            right=new int[r];
            for(int i=0;i<l;i++){
                left[i]=sc.nextInt();
                right[i]=sc.nextInt();                
            }
            System.out.println(new ArithmeticSubarrays().checkArithmeticSubarrays(nums, left, right));
        }
        catch(Exception e){
            System.out.println("Exception occurred : "+e.getMessage());
            e.printStackTrace();
        }
    }
}
