import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class FindAllDuplicateElements {
    List<Integer> redundantElementList;
    Map<Integer, Integer> map;
    public FindAllDuplicateElements(){
        redundantElementList=new LinkedList<>();
        map=new HashMap<>();
    }
    public List<Integer> findDuplicates(int[] nums) {      
        for(int i=0;i<nums.length;i++){
            if(map.containsKey(nums[i])){
                redundantElementList.add(nums[i]);
                map.put(nums[i], map.get(nums[i])+1);
            }
            else
                map.put(nums[i], 1);
        }  
        return redundantElementList;
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
            System.out.println(new FindAllDuplicateElements().findDuplicates(nums));       
        }
        catch(Exception e){
            System.out.println("Exception occurred : "+e.getMessage());
            e.printStackTrace();
        }
    }
}
