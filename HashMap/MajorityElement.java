import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class MajorityElement {
    Map<Integer, Integer> mapper;
    int majorityElement=0, count=1;
    public MajorityElement(){
        mapper=new HashMap<>();
    }
    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        if(nums.length==1)
            return 1;                
        for(int i=1;i<nums.length;i++){
            if(nums[i]==nums[i-1])
                count++;
            else {                
                mapper.put(nums[i-1], count);
                if(count>(nums.length)/2)
                    majorityElement=nums[i-1];
                count=1;
            }
        }
        if(count!=1){
            mapper.put(nums[nums.length-1], count);        
            if(count>(nums.length)/2)
                majorityElement=nums[nums.length-1];
        }
        return majorityElement;
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
            System.out.println(new MajorityElement().majorityElement(nums));       
        }
        catch(Exception e){
            System.out.println("Exception occurred : "+e.getMessage());
            e.printStackTrace();
        }
    }
}
