import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class FirstMissingPositive {
    Set<Integer> numberSet;
    public FirstMissingPositive(){
        numberSet=new HashSet<>();
    }
    public int firstMissingPositive(int[] nums) {
        for(int number : nums){
            if(number>0)
                numberSet.add(number);
        }
        return this.getFirstMissingNumber();
    }
    public int getFirstMissingNumber(){
        for(int i=1;i<=100005;i++){
            if(!numberSet.contains(i))
                return i;
        }
        return -1;
    }
    public static void main(String[] args) {
        Scanner sc;
        int[] nums;
        try{
            sc=new Scanner(System.in);
            System.out.println("Enter length of nums array : ");
            int length=sc.nextInt();
            nums=new int[length];
            for(int i=0;i<length;i++)
                nums[i]=sc.nextInt();
            System.out.println(new FirstMissingPositive().firstMissingPositive(nums));
            sc.close();
        }
        catch(Exception e){
            System.out.println("Exception occurred : "+e.getMessage());
            e.printStackTrace();
        }
    }
}