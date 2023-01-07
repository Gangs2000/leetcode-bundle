package MemoiDPAndBackTracking;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class CombinationSum {
    List<List<Integer>> output=new LinkedList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {        
        List<Integer> list=new LinkedList<>();
        findAllCombinations(0, target, candidates, list);
        return output;
    }
    public void findAllCombinations(int index, int target, int[] candidates, List<Integer> list){
        if(index==candidates.length){
            if(target==0)                                
                output.add(new LinkedList<>(list));               
            return;
        }
        if(target==0){                               
            output.add(new LinkedList<>(list));               
            return ;                
        }
        if(target>=candidates[index]){
            target-=candidates[index];
            list.add(candidates[index]);
            findAllCombinations(index, target, candidates, list);            
            list.remove(list.size()-1);
            target+=candidates[index];            
        }
        findAllCombinations(index+1, target, candidates, list);
    }
    public static void main(String[] args){
        Scanner sc;
        int[] candidates;
        try{
            sc=new Scanner(System.in);
            System.out.println("Enter length of candidates array : ");
            int length=sc.nextInt();
            candidates=new int[length];
            for(int i=0;i<length;i++)
                candidates[i]=sc.nextInt();
            System.out.println("Enter target value : ");
            int target=sc.nextInt();
            System.out.println(new CombinationSum().combinationSum(candidates, target));
        }
        catch(Exception e){
            System.out.println("Exception occurred : "+e.getMessage());
            e.printStackTrace();
        }
    }
}
