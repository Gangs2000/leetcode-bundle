import java.util.Scanner;
import java.util.LinkedList;
import java.util.List;
class RopeCutting 
{
    List<Integer> output=new LinkedList<>();
    private int getMinimum(List<Integer> list)
    {
        int min=Integer.MAX_VALUE;
        for(Integer value:list)
        {
            if(value<min)
                min=(int) value;
        }
        return min;
    }
    private void cutRope(List<Integer> list)
    {
        int minimumLength=getMinimum(list);
        if(list.size()==0)
            System.out.println(output);
        else if(list.size()>0)
        {
            List<Integer> temp=new LinkedList<>();
            for(int i=0;i<list.size();i++)
            {
                if(list.get(i)!=minimumLength)
                    temp.add(list.get(i));
            }
            if(temp.size()!=0)
                output.add(temp.size());
            cutRope(temp);
        }
    }
    public static void main(String[] args) throws Exception
    {
        Scanner sc;
        List<Integer> list;
        int ropeCount=0;
        sc=new Scanner(System.in);
        System.out.println("Enter number of ropes : ");
        ropeCount=sc.nextInt();
        list=new LinkedList<Integer>();
        if(ropeCount<0)
            throw new Exception("Rope count can't be negative..");
        else
        {
            for(int i=0;i<ropeCount;i++)
                list.add(sc.nextInt());
        }
        new RopeCutting().cutRope(list);
    }
}
