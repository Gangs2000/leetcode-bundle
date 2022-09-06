package Recursion;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class MinOprToReinitPerm {
    private static List<Integer> performOperationToReinitializePermuationArray(List<Integer> permutation){
        List<Integer> array=new LinkedList<>();
        for(int i=0;i<permutation.size();i++){
            if(i%2==0)
                array.add(permutation.get(i/2));
            else if(i%2==1)
                array.add(permutation.get((permutation.size()/2)+((i-1)/2)));
        }
        return array;
    }
    public static void main(String[] args){
        Scanner sc;
        List<Integer> originalList;
        int count=1;
        try{
            sc=new Scanner(System.in);
            originalList=new LinkedList<>();
            System.out.println("Enter the length of an array list : ");
            int length=sc.nextInt();
            if(length%2==1)
                throw new Exception("Length must be even number...");
            for(int i=0;i<length;i++)
                originalList.add(i);
            List<Integer> permutation=List.copyOf(originalList);
            while(true){
                permutation=MinOprToReinitPerm.performOperationToReinitializePermuationArray(permutation);
                System.out.println(permutation);
                boolean flag=true;
                for(int i=0;i<permutation.size();i++){
                    if(permutation.get(i)!=originalList.get(i)){
                        flag=false;
                        break;
                    }
                }
                if(flag){
                    System.out.println("Total number of iteration needed to reinitialize permutation array : "+count);
                    break;
                }
                else
                    count++;
            }
        }
        catch(Exception e){
            System.out.println("Exception occured : "+e.getMessage());
            e.printStackTrace();
        }
    }
}
