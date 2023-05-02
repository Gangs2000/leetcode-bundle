package LeetcodeDailyStreaks;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class SignoftheProductofanArray {
    Map<Integer, Integer> map;
    public SignoftheProductofanArray(){
        map=new HashMap<>();
    }
    public int arraySign(int[] nums) {
        for(int i=0;i<nums.length;i++){
            if(nums[i]==0)
                return 0;
            else if(nums[i]>0){
                map.putIfAbsent(1, 0);
                map.put(1, map.get(1)+1);
            }                
            else if(nums[i]<0){
                map.putIfAbsent(-1, 0);
                map.put(-1, map.get(-1)+1);
            }
        }        
        return (map.containsKey(-1) && map.get(-1)%2==1)?(-1):(1);
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
            System.out.println(new SignoftheProductofanArray().arraySign(nums));
        }   
        catch(Exception e){
            System.out.println("Exception occurred : "+e.getMessage());
            e.printStackTrace();
        }
    }
}
