import java.util.PriorityQueue;
import java.util.Scanner;

public class SquaresofaSortedArray {
    PriorityQueue<Integer> priorityQueue;
    int index=0;
    public SquaresofaSortedArray(){
        priorityQueue=new PriorityQueue<>();
    }
    public int[] sortedSquares(int[] nums) {
        for(int number : nums)
            priorityQueue.add(number*number);
        while (!priorityQueue.isEmpty())
            nums[index++]=priorityQueue.poll();
        return nums;
    }
    public static void main(String[] args) {
        Scanner sc;
        int[] nums;
        try {
            sc=new Scanner(System.in);
            System.out.println("Enter length of an array : ");
            int length=sc.nextInt();
            nums=new int[length];
            for(int i=0;i<length;i++)
                nums[i]=sc.nextInt();
            System.out.println(new SquaresofaSortedArray().sortedSquares(nums));
            sc.close();
        } 
        catch (Exception e) {
            e.printStackTrace();
            System.out.println("Exception error : "+e.getMessage());
        }
    }    
}