import FunctionalInterface.*;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
class SumOfListAndOdd 
{
    private static void checkForOdd(List<Integer> list)
    {
        System.out.println("Odd numbers in arraylist : ");
        list.stream().filter(value->(value%2==1)).forEach(System.out::println);
    }
    public static void main(String[] args)
    {
        Scanner sc;
        List<Integer> list;
        try
        {
            sc=new Scanner(System.in);
            list=new ArrayList<Integer>();
            System.out.println("Enter the size of an arraylist to find out the sum : ");
            int size=sc.nextInt();
            for(int i=0;i<size;i++)
                list.add(sc.nextInt());
            Consumer<List<Integer>> obj1=(array)->{
                int sum=list.stream().mapToInt(Integer::intValue).sum();
                System.out.println("Sum of given array is : "+sum);
            };
            obj1.accept(list);

            Consumer<List<Integer>> obj2=SumOfListAndOdd::checkForOdd;
            obj2.accept(list);
        }
        catch(Exception e)
        {
            System.out.println("Exception occured : "+e.getMessage());
            e.printStackTrace();
        }
    }
}
