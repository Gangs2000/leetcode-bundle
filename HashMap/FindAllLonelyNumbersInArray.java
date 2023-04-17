import java.util.Scanner;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class FindAllLonelyNumbersInArray {
    List<Integer> resulList;
    Map<Integer, Integer> map;
    public FindAllLonelyNumbersInArray(){
        resulList=new LinkedList<>();
        map=new HashMap<>();
    }
    public List<Integer> findLonely(int[] nums) {
        Arrays.sort(nums);
        for(int number : nums){
            if(map.containsKey(number))
                map.put(number, map.get(number)+1);
            else
                map.put(number, 1);
        }
        for(Map.Entry<Integer, Integer> entry : map.entrySet()){            
            int key=(int) entry.getKey();
            if((int) entry.getValue()==1 && !map.containsKey(key-1) && !map.containsKey(key+1))
                resulList.add(key);
        }
        return resulList;
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
            System.out.println(new FindAllLonelyNumbersInArray().findLonely(nums));
        }
        catch(Exception e){
            System.out.println("Exception occurred : "+e.getMessage());
            e.printStackTrace();
        }
    }
}
