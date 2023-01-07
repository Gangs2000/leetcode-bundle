package MemoiDPAndBackTracking;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Permutations {
    List<List<Integer>> output;
    public Permutations(){
        output=new LinkedList<>();
    }
    public List<List<Integer>> permute(int[] nums) {
        boolean[] flag=new boolean[nums.length];
        Arrays.fill(flag, false);
        findAllValidPermuations(nums, new LinkedList<>(), flag);
        return output;        
    }
    public void findAllValidPermuations(int[] nums, List<Integer> list, boolean[] flag){
        if(list.size()==nums.length){            
            output.add(new LinkedList<>(list));
            return ;
        }
        for(int i=0;i<nums.length;i++){
            if(!flag[i]){
                list.add(nums[i]);
                flag[i]=true;                
                findAllValidPermuations(nums, list, flag);
                flag[i]=false;
                list.remove(list.size()-1);
            }
        }
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
            System.out.println(new Permutations().permute(nums));
        }
        catch(Exception e){
            System.out.println("Exception occurred : "+e.getMessage());
            e.printStackTrace();
        }
    }    
}
