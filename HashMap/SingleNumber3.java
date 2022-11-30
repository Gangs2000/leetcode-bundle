import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class SingleNumber3 {
    public int[] singleNumber(int[] nums){
        Map<Integer,Integer> map=new LinkedHashMap<>();
        for(int i=0;i<nums.length;i++){
            if(map.containsKey(nums[i]))
                map.put(nums[i], map.get(nums[i])+1);
            else
                map.put(nums[i], 1);
        }                
        return map.entrySet().stream().filter(entry->entry.getValue()==1).mapToInt(entry->entry.getKey()).toArray();
    }
    public static void main(String[] args){
        Scanner sc;
        int[] numsArray;
        try{    
            sc=new Scanner(System.in);
            System.out.println("Enter a length of an array : ");
            int length=sc.nextInt();
            numsArray=new int[length];
            for(int i=0;i<length;i++)
                numsArray[i]=sc.nextInt();
            System.out.println(Arrays.toString(new SingleNumber3().singleNumber(numsArray)));
        }
        catch(Exception e){
            System.out.println("Exception occured : "+e.getMessage());
            e.printStackTrace();
        }
    }
}
