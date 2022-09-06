package ZOHOQuestions;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class NextGreatestNum {
    private static List<Integer> nextGreatest(List<Integer> list){
        for(int i=0;i<list.size()-1;i++)
            list.set(i,list.subList(i+1, list.size()).stream().max(Integer::compareTo).get());
        list.set(list.size()-1, -1);
        return list;
    }
    public static void main(String[] args){
        Scanner sc;
        List<Integer> array;
        try{
            sc=new Scanner(System.in);
            array=new LinkedList<>();
            System.out.println("Enter the length of the list : ");
            int length=sc.nextInt();
            for(int i=0;i<length;i++)
                array.add(sc.nextInt());
            System.out.println("Modified List is "+NextGreatestNum.nextGreatest(array));
        }
        catch(Exception e){
            System.out.println("Exception occured : "+e.getMessage());
            e.printStackTrace();
        }
    }
}
