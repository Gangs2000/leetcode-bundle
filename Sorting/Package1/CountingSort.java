package Package1;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CountingSort {
    Map<Integer, Integer> mapper;
    int index=0;
    public CountingSort(){
        mapper=new HashMap<>();
    }
    public int[] sortArray(int[] nums) {
        int getMax=Arrays.stream(nums).max().getAsInt();
        int getMin=Arrays.stream(nums).min().getAsInt();
        for(int i=0;i<nums.length;i++){
            if(mapper.containsKey(nums[i]))                
                mapper.put(nums[i], mapper.get(nums[i])+1);
            else
                mapper.put(nums[i], 1);
        }     
        for(int i=getMin;i<=getMax;i++){
            if(mapper.containsKey(i)){
                int numOfTime=mapper.get(i);
                while(numOfTime>0){
                    nums[index]=i;
                    index++;
                    numOfTime--;
                }
            }
        }            
        return nums;        
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
            System.out.println(new CountingSort().sortArray(nums));
        }
        catch(Exception e){
            System.out.println("Exception occurred : "+e.getMessage());
            e.printStackTrace();
        }
    }
}
