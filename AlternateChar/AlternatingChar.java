import java.util.Stack;
import java.util.Scanner;
import java.util.ArrayList;
class AlternatingChar
{
    int deletion=0;
    Stack<Character> stack;
    AlternatingChar()
    {
        stack=new Stack<Character>();
    }
    private void deletionCount(ArrayList<String> al)
    {
        for(String string:al)
        {
            for(int i=0;i<string.length();i++)
            {
                if(stack.size()==0)
                    stack.push(string.charAt(i));
                else
                {
                    if(stack.peek()==string.charAt(i))
                        deletion++;
                    else
                        stack.push(string.charAt(i));
                }
            }
            System.out.println("Minimum deletion required for the string "+string+" is "+deletion);
            deletion=0;stack.clear();
        }
    }
    public static void main(String[] args)
    {
        Scanner sc;
        ArrayList<String> al;
        int inputs;
        try
        {
            sc=new Scanner(System.in);
            al=new ArrayList<String>();
            System.out.println("Enter number of String you want to insert : ");
            inputs=sc.nextInt();
            for(int i=0;i<inputs;i++)
                al.add(sc.next().toUpperCase());
            new AlternatingChar().deletionCount(al);
        }
        catch(Exception e)
        {
            System.out.println("Exception occured : "+e.getMessage());
            e.printStackTrace();
        }
    }
}