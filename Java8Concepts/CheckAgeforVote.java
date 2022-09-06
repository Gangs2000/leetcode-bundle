import FunctionalInterface.*;
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.stream.Collectors;
class CheckAgeforVote 
{
    private static List<Integer> checkAge(List<Integer> list)
    {
        List<Integer> validAge=list.stream().filter(value->(value>18)).collect(Collectors.toList());
        return validAge;
    }
    public static void main(String[] args)
    {
        Scanner sc;
        List<Integer> list;
        try
        {
            sc=new Scanner(System.in);
            list=new ArrayList<Integer>();
            System.out.println("Enter size of arraylist : ");
            int size=sc.nextInt();
            for(int i=0;i<size;i++)
                list.add(sc.nextInt());
            Predicate<List<Integer>> obj=CheckAgeforVote::checkAge;
            List<Integer> validAge=obj.test(list);
            System.out.println("Age greater than 18 : "+validAge);
        }
        catch(Exception e)
        {
            System.out.println("Exception occured : "+e.getMessage());
            e.printStackTrace();
        }
    }
}
