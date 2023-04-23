import java.util.Scanner;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class MajorityElementII {
    List<Integer> list;
    Map<Integer, Integer> mapper;
    public MajorityElementII(){
        list=new LinkedList<>();
        mapper=new HashMap<>();
    }
    public List<Integer> majorityElement(int[] nums) {
        Arrays.sort(nums);
        int count=1;
        for(int i=1;i<nums.length;i++){
            if(nums[i]==nums[i-1])
                count++;
            else{
                mapper.put(nums[i-1], count);
                if(count>(nums.length/3))
                    list.add(nums[i-1]);
                count=1;
            }
        }                
        mapper.put(nums[nums.length-1], count);        
        if(count>(nums.length/3))
            list.add(nums[nums.length-1]);        
        return list;                
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
            System.out.println(new MajorityElementII().majorityElement(nums));
        }
        catch(Exception e){
            System.out.println("Exception occurred : "+e.getMessage());
            e.printStackTrace();
        }
    }
}
