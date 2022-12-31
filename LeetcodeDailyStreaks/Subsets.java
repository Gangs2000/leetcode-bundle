package LeetcodeDailyStreaks;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Subsets {
    List<List<Integer>> output;
    public Subsets(){
        output=new LinkedList<>();
    }
    public List<List<Integer>> subsets(int[] nums) {
        findAllCombinations(0, nums, new LinkedList<>());
        return output;
    }
    public void findAllCombinations(int index, int[] nums, List<Integer> list){
        if(index==nums.length){
            List<Integer> tempList=new LinkedList<>(list);
            //List<Integer> tempList=new LinkedList<>(list.stream().sorted().collect(Collectors.toList()));     //This line can be used for subsets-II solution
            if(!output.contains(tempList))
                output.add(tempList);
            return ;
        }
        list.add(nums[index]);
        findAllCombinations(index+1, nums, list);
        list.remove(list.size()-1);
        findAllCombinations(index+1, nums, list);
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
            System.out.println(new Subsets().subsets(nums));
        }   
        catch(Exception e){
            System.out.println("Exception occurred : "+e.getMessage());
            e.printStackTrace();
        }
    }
}
