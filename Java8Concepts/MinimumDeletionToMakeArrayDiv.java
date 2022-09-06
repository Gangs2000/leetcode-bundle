import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import FunctionalInterface.BiFunction;

public class MinimumDeletionToMakeArrayDiv {
    public static boolean isDivisble(int number,List<Integer> numsDivisible){
        boolean flag=true;
        for(int i=0;i<numsDivisible.size();i++){
            if(!(numsDivisible.get(i)%number==0)){
                flag=false;
                break;
            }
        }
        return flag;
    }
    public static void main(String[] args){
        Scanner sc;
        List<Integer> nums,numsDivisble;
        int deletionCount=0;
        BiFunction<Integer,List<Integer>,Boolean> object;
        try{
            sc=new Scanner(System.in);
            nums=new ArrayList<>();
            numsDivisble=new ArrayList<>();
            System.out.println("Enter length of nums list : ");
            int numsLength=sc.nextInt();
            for(int i=0;i<numsLength;i++)
                nums.add(sc.nextInt());
            System.out.println("Enter length of numsDivisble list : ");
            int numsDivLength=sc.nextInt();
            for(int i=0;i<numsDivLength;i++)
                numsDivisble.add(sc.nextInt());
            List<Integer> sortedNums=nums.stream().sorted().collect(Collectors.toList());
            object=MinimumDeletionToMakeArrayDiv::isDivisble;
            while(true){
                if(sortedNums.size()==0){
                    System.out.println("Deletion is not possible hence returning "+(-1));
                    break;
                }
                else if(object.apply(sortedNums.get(0), numsDivisble)){
                    System.out.println("Minimum number of deletions required to get numdiv divided by the smallest number is : "+deletionCount);
                    break;
                }
                else{
                    deletionCount++;
                    sortedNums.remove(0);
                }
            }
        }
        catch(Exception e){
            System.out.println("Exception occured : "+e.getMessage());
            e.printStackTrace();
        }
    }
}
