package MemoiDPAndBackTracking;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class PrintAllPossibleOfRElements {
    List<List<Integer>> outputList;
    public PrintAllPossibleOfRElements(){
        outputList=new LinkedList<>();
    }
    public List<List<Integer>> printAllCombo(int[] nums, int r){
        tryAllPossibilities(nums, 0, new LinkedList<>(), r);        
        return outputList;
    }
    public void tryAllPossibilities(int[] nums, int index, List<Integer> list, int r){
        if(list.size()==r){
            List<Integer> tempList=new LinkedList<>(list);
            outputList.add(tempList);
            return ;
        }
        for(int i=index;i<nums.length;i++){
            list.add(nums[i]);
            tryAllPossibilities(nums, i+1, list, r);
            list.remove(list.size()-1);
        }        
    }
    public static void main(String[] args){
        Scanner sc;                
        try{
            sc=new Scanner(System.in);
            System.out.println("Enter length of nums array : ");
            int length=sc.nextInt();
            int[] nums=new int[length];
            for(int i=0;i<length;i++)
                nums[i]=sc.nextInt();
            System.out.println("Enter R value : ");
            int r=sc.nextInt();
            System.out.println(new PrintAllPossibleOfRElements().printAllCombo(nums, r));
        }
        catch(Exception e){
            System.out.println("Exception occurred : "+e.getMessage());
            e.printStackTrace();
        }
    }
}
