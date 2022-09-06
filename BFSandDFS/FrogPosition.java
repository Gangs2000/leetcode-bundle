import java.util.Scanner;
import java.util.Stack;
class FrogPosition
{
    Stack<Integer> stack;
    double prob=1.0;
    FrogPosition()
    {   
        stack=new Stack<Integer>();
        stack.push(1);                                          //Push 1 to the stack.. Assume starts from position 1 
    }
    private double findPosition(int edges[][],int seconds,int target)
    {
        boolean flag=true;                                      //Will keep flag true if no elements found in stack later it can be popped up
        if(stack.size()<=(seconds+1))
        {
            for(int i=0;i<edges.length;i++)
            {
                if(edges[i][0]==stack.peek() && edges[i][1]!=0)
                {
                    flag=false;                                 //Swap flag value as false to add child node of current root
                    stack.push(edges[i][1]);
                    edges[i][1]=0;                              //Marking array[i][1] as 0, 0 indicates visited nodes which can't be revisited again
                    break;                                      //break is important otherwise it will override child value of root as it is in for loop
                }
            }
            if(flag)
                stack.pop();                                    //Pop it of if no element is found in stack
            if(stack.size()<=seconds)
                findPosition(edges,seconds,target);                   
            else if(stack.size()==(seconds+1))
            {
                if(stack.peek()==target)                           //Check peek value is same as target if so, Stops recursion and calculating probability
                {
                    for(int i=0;i<stack.size()-1;i++)
                        prob*=(1.0/(double) countValue(edges,stack.get(i)));
                }
                else                                            //If peek value is not same as target value then pop it out of stack
                {
                    stack.pop();
                    findPosition(edges,seconds,target);
                }
            }
        }
        return prob;
    }
    private int countValue(int edges[][],int value)                           //To find number of occurence of value present in array
    {
        int count=0;
        for(int i=0;i<edges.length;i++)
        {
            if(edges[i][0]==value)
                count++;
        }
        return count;
    }
    public static void main(String[] args)
    {
        Scanner sc;
        int nodes=0,target=0,seconds=0,edges[][];
        try
        {
            sc=new Scanner(System.in);
            System.out.println("Enter number of nodes : ");
            nodes=sc.nextInt();
            System.out.println("Enter target value : ");
            target=sc.nextInt();
            if(!(target>=1 && target<=nodes))
                throw new Exception("Target value must be fallen between "+1+" and "+nodes);
            System.out.println("Enter number of seconds : ");
            seconds=sc.nextInt();
            if(!(seconds>=1 && seconds<=50))
                throw new Exception("Seconds must be falled between "+1+" and "+50);
            edges=new int[nodes-1][2];
            for(int i=0;i<nodes-1;i++)
            {
                for(int j=0;j<2;j++)
                {
                    int value=sc.nextInt();
                    if(value>=1 && value<=nodes)
                        edges[i][j]=value;
                    else
                        throw new Exception("Value must be fallen between "+1+" and "+nodes);
                }
            }
            System.out.println("Probability of frog position after "+seconds+" seconds is "+new FrogPosition().findPosition(edges,seconds,target));
        }
        catch(Exception e)
        {
            System.out.println("Exception occured : "+e.getMessage());
            e.printStackTrace();
        }
    }
}