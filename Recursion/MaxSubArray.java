package Recursion;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MaxSubArray {
    int maxValue=0,output=0;
    private int maxSubArray(List<Integer> list,int beginIndex,int endIndex){
        if(endIndex==-1 || endIndex==list.size())
            output=maxValue;
        else{
            List<Integer> uniqueList=new ArrayList<>();
            boolean flag=true;
            for(int i=beginIndex;i<=endIndex;i++){
                if(uniqueList.contains(list.get(i))){
                    flag=false;
                    break;
                }
                else    
                    uniqueList.add(list.get(i));
            }
            if(flag){
                int sum=uniqueList.stream().reduce(0, (a,b)->a+b);
                maxValue=(sum>maxValue)?(sum):(maxValue);
                endIndex++;
                maxSubArray(list, beginIndex, endIndex);
            }
            else
                maxSubArray(list, beginIndex, -1);
        }
        return output;
    } 
    public static void main(String[] args){
        Scanner sc;
        List<Integer> list;
        int maxSubArraySum=0;
        try{
            sc=new Scanner(System.in);
            list=new ArrayList<>();
            System.out.println("Enter the length of an array list : ");
            int length=sc.nextInt();
            for(int i=0;i<length;i++)
                list.add(sc.nextInt());
            for(int i=0;i<list.size();i++){
                int element=new MaxSubArray().maxSubArray(list, i, i);
                if(element>maxSubArraySum)
                    maxSubArraySum=element;
            }
            System.out.println("Max Sub Array Sum is "+maxSubArraySum);
        }
        catch(Exception e){
            System.out.println("Exception occured : "+e.getMessage());
            e.printStackTrace();
        }
    }
}
