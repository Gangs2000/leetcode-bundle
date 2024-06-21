import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class MinimumIncrementToMakeArrayUnique {
    int minimumIncrement=0;
    PriorityQueue<Integer> descPriorityQueue, ascPriorityQueue;
    public MinimumIncrementToMakeArrayUnique(){
        descPriorityQueue=new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2.compareTo(o1);
            }
        });
        ascPriorityQueue=new PriorityQueue<>();
    }
    public int minIncrementForUnique(int[] nums) {
        for(int number : nums)
            ascPriorityQueue.add(number);
        while (!ascPriorityQueue.isEmpty()) {
            int currentElement=ascPriorityQueue.poll();
            if(descPriorityQueue.contains(currentElement)){
                descPriorityQueue.add(descPriorityQueue.peek()+1);
                minimumIncrement+=Math.abs(descPriorityQueue.peek()-currentElement);
            }
            else
                descPriorityQueue.add(currentElement);
        }
        return minimumIncrement;
    }
    public static void main(String[] args) {
        Scanner sc;
        int[] nums;
        try {
            sc=new Scanner(System.in);
            System.out.println("Enter length of nums array : ");
            int length=sc.nextInt();
            nums=new int[length];
            for(int i=0;i<length;i++)
                nums[i]=sc.nextInt();
            System.out.println(new MinimumIncrementToMakeArrayUnique().minIncrementForUnique(nums));
            sc.close();
        } 
        catch (Exception e) {
            System.out.println("Exception occurred : "+e.getMessage());
            e.printStackTrace();
        }
    }
}
