import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class NumberofGoodPairs {
    int countGoodPairs=0;
    Map<Integer, Integer> freqCount;
    public NumberofGoodPairs(){
        freqCount=new HashMap<>();
    }
    public int numIdenticalPairs(int[] nums) {
        for(int i=0;i<nums.length;i++){
            freqCount.putIfAbsent(nums[i], 0);
            freqCount.put(nums[i], freqCount.get(nums[i])+1);
        }
        for(Map.Entry<Integer, Integer> entry : freqCount.entrySet()){
            int getValue=(int) entry.getValue();
            if(getValue>1)
                countGoodPairs+=((getValue*(getValue-1))/2);
        }
        return countGoodPairs;
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
            System.out.println(new NumberofGoodPairs().numIdenticalPairs(nums));
        }
        catch(Exception e){
            System.out.println("Exception occurred : "+e.getMessage());
            e.printStackTrace();
        }
    }
}
