import FunctionalInterface.*;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
class SubToUpper 
{
    private List<String> changeItToUpper(List<String> list,Function<String,String> obj)
    {
        List<String> newList=new LinkedList<>();
        for(String str:list)
            newList.add(obj.apply(str));
        return newList;
    }
    public static void main(String[] args)
    {
        String getString;
        Scanner sc=new Scanner(System.in).useDelimiter("\n");
        System.out.println("Enter a string to perform operation on it :");
        getString=sc.next();
        Function<String,String> obj1=(value)->{
            return value.substring(0,value.length()-2).toUpperCase();
        };
        System.out.println("Modified String is "+obj1.apply(getString));
        Function<String,String> obj2=value->{
            return value.toUpperCase();
        };
        List<String> list=new LinkedList<String>();
        System.out.println("Enter a string to convert it into uppercase : ");
        for(int i=0;i<5;i++)
            list.add(sc.next());
        System.out.println("Modified list is : "+new SubToUpper().changeItToUpper(list,obj2));
    }
}
