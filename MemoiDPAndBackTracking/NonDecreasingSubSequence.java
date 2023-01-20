package MemoiDPAndBackTracking;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class NonDecreasingSubSequence {
    List<List<Integer>> result=new LinkedList<>();
    public List<List<Integer>> findSubsequences(int[] nums) {
        findAllPossibilites(0, nums, new LinkedList<>());
        return result;
    }
    public void findAllPossibilites(int index, int[] nums, List<Integer> list){        
        if(list.size()>=2){
            List<Integer> tempList=new LinkedList<>(list);
            if(!result.contains(tempList))
                result.add(tempList);
            if(index==nums.length)
                return ;
        }                
        for(int i=index;i<nums.length;i++){            
            if(list.size()==0 || list.get(list.size()-1)<=nums[i]){
                list.add(nums[i]);
                findAllPossibilites(i+1, nums, list);
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
            System.out.println(new NonDecreasingSubSequence().findSubsequences(nums));   
        }
        catch(Exception e){
            System.out.println("Exception occurred : "+e.getMessage());
            e.printStackTrace();
        }
    }
}
