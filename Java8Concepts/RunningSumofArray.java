import FunctionalInterface.Function;
import java.util.Stack;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
class RunningSumofArray 
{
    public static void main(String[] args)
    {
        Scanner sc;
        List<Integer> list;
        int size;
        try
        {
            sc=new Scanner(System.in);
            System.out.println("Enter size of an array : ");
            size=sc.nextInt();
            list=new ArrayList<Integer>();
            for(int i=0;i<size;i++)
                list.add(sc.nextInt());
            Function<List<Integer>,Stack<Integer>> obj=(elements)->{
                Stack<Integer> stack=new Stack<>();
                for(Integer value:elements)
                {
                    if(stack.size()==0)
                        stack.add(value);
                    else
                        stack.add(stack.peek()+value);
                }
                return stack;
            };
            System.out.println(obj.apply(list));
        }
        catch(Exception e)
        {
            System.out.println("Exception occured : "+e.getMessage());
            e.printStackTrace();
        }
    }
}
