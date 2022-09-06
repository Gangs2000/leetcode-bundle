import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import FunctionalInterface.*;

class AntsFallOut {
    int minLength,maxLength;
    AntsFallOut(int minLength,int maxLength){
        this.minLength=minLength;
        this.maxLength=maxLength;
    }
    private List<Integer> antMoments(List<Integer> list,boolean flag){
        if(flag)
            return list.stream().map(element->element=element-1).filter(element->(element>minLength)).collect(Collectors.toList());
        else
            return list.stream().map(element->element=element+1).filter(element->(element<maxLength)).collect(Collectors.toList());
    }
    public static void main(String[] args){
        Scanner sc;
        List<Integer> left,right;
        int lengthOfPlank,count=0;
        try{
            sc=new Scanner(System.in);
            left=new ArrayList<>();
            right=new ArrayList<>();
            System.out.println("Enter the length of Plank : ");
            lengthOfPlank=sc.nextInt();
            System.out.println("Enter left and right side array lengths : ");
            int leftLength=sc.nextInt();
            int rightLength=sc.nextInt();
            System.out.println("Enter left side elements : ");
            for(int i=0;i<leftLength;i++)
                left.add(sc.nextInt());
            System.out.println("Enter right side elements : ");
            for(int i=0;i<rightLength;i++)
                right.add(sc.nextInt());
            System.out.println("Left : "+left+" Right : "+right);
            AntsFallOut object=new AntsFallOut(0,lengthOfPlank);
            for(;;){
                if(left.size()==0 && right.size()==0)
                    break;
                else{
                    BiFunction<List<Integer>,Boolean,List<Integer>> obj=object::antMoments;
                    left=obj.apply(left,true);
                    right=obj.apply(right,false);
                    count++;
                }
            }
            System.out.println("Last Moment Before All Ants Fall Out of a Plank is : "+count);
        }
        catch(Exception e){
            System.out.println("Exception occured : "+e.getMessage());
            e.printStackTrace();
        }
    }
}

