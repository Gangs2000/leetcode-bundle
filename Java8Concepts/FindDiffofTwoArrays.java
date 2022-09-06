import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import FunctionalInterface.BiFunction;

public class FindDiffofTwoArrays {
    public static List<Integer> findDiff(List<Integer> list1,List<Integer> list2){
       return list1.stream().distinct().filter(element->!list2.contains(element)).collect(Collectors.toList());
    }
    public static void main(String[] args){
        Scanner sc;
        List<Integer> list1,list2;
        List<List<Integer>> output;
        BiFunction<List<Integer>,List<Integer>,List<Integer>> object;
        try{
            sc=new Scanner(System.in);
            System.out.println("Enter length of both lists : ");
            int length=sc.nextInt();
            list1=new ArrayList<>();
            list2=new ArrayList<>();
            output=new ArrayList<>();
            System.out.println("Enter values of list 1 : ");
            for(int i=0;i<length;i++)
                list1.add(sc.nextInt());
            System.out.println("Enter values of list 2 : ");
            for(int i=0;i<length;i++)
                list2.add(sc.nextInt());
            object=FindDiffofTwoArrays::findDiff;
            output.add(object.apply(list1, list2));
            output.add(object.apply(list2, list1));
            System.out.println("Final Output : "+output);
        }
        catch(Exception e){
            System.out.println("Exception ");
        }
    }
}
