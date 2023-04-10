package ZOHOQuestions;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class SeggregateLists {
    List<Integer> list1, list2, list3;
    int listIteration=1;
    public SeggregateLists(){
        list1=new LinkedList<>();
        list2=new LinkedList<>();
        list3=new LinkedList<>();
    }
    public void separateNumsAndStoreIntoLists(int[] nums){        
        List<Integer> numsList=Arrays.stream(nums).boxed().collect(Collectors.toList());        
        for(int i=0;i<nums.length;i=i+3){    
            if(listIteration==4)
                listIteration=1;          
            List<Integer> list=(listIteration==1)?(list1):((listIteration==2)?(list2):(list3));
            if(nums.length-i>=3){                                
                list.addAll(numsList.subList(i, i+3));
                listIteration++;
            } 
            else                 
                list.addAll(numsList.subList(i, nums.length));
        }        
        System.out.println(list1+" "+list2+" "+list3);
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
            new SeggregateLists().separateNumsAndStoreIntoLists(nums);
        }
        catch(Exception e){
            System.out.println("Exception occurred : "+e.getMessage());
            e.printStackTrace();
        }
    }
}
