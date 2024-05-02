import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class LargestPositiveIntegerThatExistsWithItsNegative {
    int largestPositive=Integer.MIN_VALUE;
    Set<Integer> positiveSet, negativeSet;
    public LargestPositiveIntegerThatExistsWithItsNegative(){
        positiveSet=new HashSet<>();
        negativeSet=new HashSet<>();
    }
    public int findMaxK(int[] nums) {
        this.seggregateElementsBasedOnSign(nums);
        if(!positiveSet.isEmpty() && !negativeSet.isEmpty())
            this.findLargestPositiveValueFromSet(positiveSet, negativeSet);
        return (largestPositive==Integer.MIN_VALUE)?(-1):(largestPositive);
    }
    private void seggregateElementsBasedOnSign(int[] nums){
        for(int number : nums){
            if(number>0)
                positiveSet.add(number);
            else if(number<0)
                negativeSet.add(number);
        }
    }
    private void findLargestPositiveValueFromSet(Set<Integer> positiveSet, Set<Integer> negativeSet){
        for(int number : negativeSet){
            if(positiveSet.contains(Math.abs((int) number)))
                largestPositive=Math.max(largestPositive, Math.abs((int) number));
        }
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
            sc.close();
        } 
        catch (Exception e) {
            System.out.println("Exception occurred : "+e.getMessage());
            e.printStackTrace();
        }
    }
}
