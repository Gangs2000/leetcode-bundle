import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class MajorityElementsII {
    Map<Integer, Integer> freqMapper;
    List<Integer> resultList;
    public MajorityElementsII(){
        freqMapper=new HashMap<>();
        resultList=new LinkedList<>();
    }
    public List<Integer> majorityElement(int[] nums) {
        for(int i=0;i<nums.length;i++){
            freqMapper.putIfAbsent(nums[i], 0);
            freqMapper.put(nums[i], freqMapper.get(nums[i])+1);
        }
        for(Map.Entry<Integer, Integer> entry : freqMapper.entrySet()){
            if((int) entry.getValue()>(nums.length/3))
                resultList.add((int) entry.getKey());
        }
        return resultList;
    }
    public static void main(String[] args){
        Scanner sc;
        int[] nums;
        try{
            sc=new Scanner(System.in);
            System.out.println("Enter Length of Nums array : ");
            int length=sc.nextInt();
            nums=new int[length];
            for(int i=0;i<length;i++)
                nums[i]=sc.nextInt();
            
        }
        catch(Exception e){
            System.out.println("Exception occurred : "+e.getMessage());
            e.printStackTrace();    
        }
    }
}
