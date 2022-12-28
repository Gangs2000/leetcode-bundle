package MemoizationAndDP;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class CombinationSumII {
    List<List<Integer>> output;
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        output=new LinkedList<>();
        List<Integer> list=new LinkedList<>();
        Arrays.sort(candidates);
        findAllSubSequences(0, candidates, target, list);
        return output;
    }
    public void findAllSubSequences(int index, int[] candidates, int target, List<Integer> list){        
        if(target==0){
            List<Integer> tempList=new LinkedList<>(list);
            if(!output.contains(tempList))
                output.add(tempList);
        }
        for(int i=index;i<candidates.length;i++){
            if(i>index && candidates[i]==candidates[i-1])
                continue;
            if(target>=candidates[index]){
                list.add(candidates[i]);
                findAllSubSequences(i+1, candidates, target-candidates[i], list);
                list.remove(list.size()-1);
            }
            else
                break;
        }
    }
    public static void main(String[] args){
        Scanner sc;
        int[] candidates;
        try{
            sc=new Scanner(System.in);
            System.out.println("Enter length of candidate array : ");
            int length=sc.nextInt();
            candidates=new int[length];
            for(int i=0;i<length;i++)
                candidates[i]=sc.nextInt();
            System.out.println("Enter target value : ");
            int target=sc.nextInt();
            System.out.println(new CombinationSumII().combinationSum2(candidates, target));
        }
        catch(Exception e){
            System.out.println("Exception occured : "+e.getMessage());
            e.printStackTrace();
        }
    }
}
